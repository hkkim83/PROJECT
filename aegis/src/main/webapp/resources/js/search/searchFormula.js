// 형식 --> {'keyword':'철도* OR 열차*', 'field':'ti', parameters:[{'keyword':'승강* 출입*', 'field':'ti'}, {'keyword':'문* 장치* device*', 'field':'ti'}]}
var SearchFormula = function(){
	
	//
	// 분석
	//
	this.parse = function(srcSource){
		console.log(1);
		var parser = new SearchFormulaParser();
		var dbTypeCd = parser.checkDbType(srcSource);
		console.log("dbTypeCod ::: "+dbTypeCd);
		switch(dbTypeCd){
		case SearchFormula.DB_TYPE_WIPSON :
			parser = new WipsonParser();
			break;
		case SearchFormula.DB_TYPE_FOCUST :
			parser = new FocustParser();
			break;
		case SearchFormula.DB_TYPE_KIPRIS :
			parser = new KiprisParser();
			break;
		}

		console.log(2);
		var strTarget = srcSource;
		strTarget = parser.removeUselessParenthesis(strTarget);
		var arrKeyword = parser.parse(strTarget);
		console.log(3);
		
		var mapResult = new Object();
		mapResult['dbTypeCd'] = dbTypeCd;
		mapResult['searchFormula'] = srcSource;
		mapResult['arrKeyword'] = arrKeyword;
		
		return mapResult;
	};
	
	
	{
		WipsonParser.prototype = new SearchFormulaParser();
		FocustParser.prototype = new SearchFormulaParser();
		KiprisParser.prototype = new SearchFormulaParser();
	}
};
SearchFormula.DB_TYPE_WIPSON = '11';
SearchFormula.DB_TYPE_FOCUST = '12';
SearchFormula.DB_TYPE_KIPRIS = '13';

// 매칭되지 않는 정규식 정의
SearchFormula.EXPR_NONE = /$^/;

//
// 검색식 생성자 클래스
//
var SearchFormulaGenerator = function(){

	// 키워드내의(필드제외) 연산자 치환을 위한 대상연산자 정의
	var arrKeywordOperator = [
        /*{대상필드,			원본문자열의 바꿀대상 정규식, 	WIPSON, 				FOCUST, 					KIPRIS}*/
        , {'FIELD_CD':'00',		'SRC':/\?/gi,						'11':'?',				'12':'?',					'13':''}
        , {'FIELD_CD':'00',		'SRC':/\*/gi,						'11':'*',				'12':'*',					'13':''}
        , {'FIELD_CD':'04',		'SRC':/(.+?[^\*^\?])(\)|\s|$)/gi,	'11':'$1*$2',			'12':'$1*$2',				'13':'$1$2'}	/* IPC */
        , {'FIELD_CD':'18',		'SRC':/(.+?[^\*^\?])(\)|\s|$)/gi,	'11':'$1*$2',			'12':'$1*$2',				'13':''}		/* F-TERM */
        , {'FIELD_CD':'00', 	'SRC':/ AND(\*\s|\s)/gi,			'11':'^@@^AND^@@^',		'12':'^@@^AND^@@^',			'13':'==@@=='}
        , {'FIELD_CD':'00',		'SRC':/ OR(\*\s|\s)/gi,				'11':'^@@^OR^@@^',		'12':'^@@^OR^@@^',			'13':'+'}
        , {'FIELD_CD':'00',		'SRC':/ NOT(\*\s|\s)/gi,			'11':'^@@^NOT^@@^',		'12':'^@@^NOT^@@^', 		'13':'!'}
        , {'FIELD_CD':'00',		'SRC':/ ADJ(\d)(\*\s|\s)/gi,		'11':'^@@^ADJ$1^@@^',	'12':'^@@^WITHIN/$1^@@^',	'13':'^$1'}
        , {'FIELD_CD':'00',		'SRC':/ ADJ(\*\s|\s)/gi,			'11':'^@@^ADJ^@@^',		'12':'^@@^WITHIN^@@^',		'13':'^'}
        , {'FIELD_CD':'00',		'SRC':/ NEAR(\d)(\*\s|\s)/gi,		'11':'^@@^NEAR$1^@@^',	'12':'^@@^NEAR/$1^@@^',		'13':'^$1'}
        , {'FIELD_CD':'00',		'SRC':/ NEAR(\*\s|\s)/gi,			'11':'^@@^NEAR^@@^',	'12':'^@@^NEAR^@@^',		'13':'^'}
        , {'FIELD_CD':'00',		'SRC':/\s/gi,						'11':'^@@^',			'12':'^@@^OR^@@^',			'13':'+'}
        
        /**
         * 공백을 " OR "로 변경하는 경우가 있어서 이미 변경한 문자열의 공백은 특수문자로 지정하여 변경처리되지않도록 하였다.
         * 그렇기 때문에 특수문자를 다시 공백으로 되돌려야한다. 
         */
        , {'FIELD_CD':'00',		'SRC':/\^@@\^/gi,				'11':' ',				'12':' ',					'13':''}
        
        /**
         * 특수문자 '==@@==' 처리 '*'로 변경.
         */
        , {'FIELD_CD':'00',		'SRC':/==@@==/gi,				'11':'',				'12':'',					'13':'*'}
    ];

	
	// 키워드(필드포함) 수식 치환을 위한 대상수식 정의
	var mapFormula = {
		/*{원본문자열의 바꿀대상 정규식, 	WIPSON, 			FOCUST, 			KIPRIS}*/
		'SRC':/\((.*?)\)\.(.+?)\./gi,		'11':'($1).$2.',	'12':'$2=($1)',		'13':'$2=[$1]'
	};

	
	// 키워드와 키워드를 연결하기위한 대상접속사 정의
	var mapConjunction = {
	    /*       	{WIPSON, 			FOCUST, 			KIPRIS}*/
	      'AND':	{'11':' AND ',		'12':' AND ',		'13':'*'}
	    , 'OR':		{'11':' OR ',		'12':' OR ',		'13':'+'}
	};
	
	
	
	var assemble = function(arrKeyword, dbType){
		
		// 키워드연산자 치환함수
		var replaceKeywordOperator = function(target, fieldCode){
			$.each(arrKeywordOperator, function(){
				if(this['FIELD_CD'] == '00' || this['FIELD_CD'] == fieldCode){
					//console.debug('aaaaaa = ' + this['SRC'] + ' = ' + this['11'] + ' : ' + target);
					target = target.replace(this['SRC'], this[dbType]);
					//console.debug('bbbbbb = ' + this['SRC'] + ' = ' + this['11'] + ' : ' + target);
				}
			});
			return target;
		};
		
		// 일자키워드 연산자 치환함수
		var replaceDateKeyword = function(oKeyword, keyword){
			if(oKeyword['fieldCode'].match(/09|11|13|15|17/)){	// 일자필드인경우
				var fromExpr = /^[0-9]{4,8}-/;
				var toExpr = /-[0-9]{4,8}$/;
				var from = keyword.match(fromExpr);
				var to = keyword.match(toExpr);
				if(from){
					from = from[0].substring(0, from[0].length-1);
				}
				if(to){
					to = to[0].substring(1, to[0].length);
				}
				if(dbType == '11'){			// (@AD>=[form]<=[to])
					if(from && to){
						keyword = '(@' + oKeyword['field'] + '>=' + from + '<=' + to + ')';
					}else if(from){
						keyword = '(@' + oKeyword['field'] + '>=' + from + ')';
					}else if(to){
						keyword = '(@' + oKeyword['field'] + '<=' + to + ')';
					}else{
						alert('수식오류입니다.\n['+keyword+']');
						throw '수식오류입니다.\n['+keyword+']';
					}
				}else if(dbType == '12'){	// (AD>=[from]) AND (AD<=[to])
					if(from && to){
						keyword = '((' + oKeyword['field'] + '>=' + from + ') AND (' + oKeyword['field'] + '<=' + to + '))';
					}else if(from){
						keyword = '(' + oKeyword['field'] + '>=' + from + ')';
					}else if(to){
						keyword = '(' + oKeyword['field'] + '<=' + to + ')';
					}else{
						alert('수식오류입니다.\n['+keyword+']');
						throw '수식오류입니다.\n['+keyword+']';
					}
				}else if(dbType == '13'){	// AD=[from]~[to]
					if(from && to){
						keyword = oKeyword['field'] + '=[' + from.rpad('01', 8) + '~' + to.rpad('31', 8) + ']';
					}else if(from){
						keyword = oKeyword['field'] + '=[' + from.rpad('01', 8) + '~' + from.rpad('31', 8) + ']';
					}else if(to){
						keyword = oKeyword['field'] + '=[' + to.rpad('01', 8) + '~' + to.rpad('31', 8) + ']';
					}else{
						alert('수식오류입니다.\n['+keyword+']');
						throw '수식오류입니다.\n['+keyword+']';
					}
				}
			}else{
				keyword = '(' + keyword + ')';
				if(oKeyword['field'] != ''){
					keyword += ('.' + oKeyword['field'] + '.');
				}
				keyword = keyword.replace(mapFormula['SRC'], mapFormula[dbType]);							// 검색식 치환
			}
			return keyword;
		};
		
		// 발명의 명칭, 요약, 대표청구항은 연산자를 or로 추가한다.
		var orSearchKeyword = function(oResult) {
			if(oKeyword['field'].match(/01|02|03/)) {	// 발명의 명칭, 요약, 대표청구항인 경우
				orSearchString += oKeyword['keyword'] + mapConjunction['OR'][this.dbType];
			}
		}
		
		
		//===================================//
		//              처리시작             //
		//===================================//
		var arrResult   = new Array();
		var arrResultOr = new Array();
		var arrResultKp = new Array();
		for(var i=0; i<arrKeyword.length; i++){
			var oKeyword = arrKeyword[i];
			
			var keyword = oKeyword['keyword'];
			var oSharpIterator = new SharpIterator(keyword);
			while((oSharpIterator.nextSharp()) != ''){		// 파라미터(#)의 수만큼 반복한다.
				var oParameter = oKeyword['parameters'][oSharpIterator.getIdx()];
				//console.debug('###### ' + oParameter['parameter']);
				keyword = oSharpIterator.replace('('+oParameter['parameter']+')');
			}
			
			keyword = replaceKeywordOperator(keyword, oKeyword['fieldCode']);	// 키워드연산자 치환
			if(oKeyword['fieldCode'] != '00'){						// 필드가 전체가 아닌경우
				keyword = replaceDateKeyword(oKeyword, keyword);
			}else{
				keyword = '(' + keyword + ')';
			}
			var oResult = new Object();
			oResult['keyword'] = keyword;
			oResult['field'] = oKeyword['field'];
			console.log("oKeyword['field']::::"+oKeyword['field']);
			if(oKeyword['fieldCode'].match(/01|02|03/)) {	// 발명의 명칭, 요약, 대표청구항인 경우 OR로 결합한다.
				arrResultOr.push(oResult);				
			} else {
				if(oKeyword['fieldCode'].match(/00|04|05|06/)) {	// 전체, IPC, 발명자, 출원원은 키프리스 검색식에 사용한다.
					arrResultKp.push(oResult);		
				}
				arrResult.push(oResult);				
			}
		}
		
		// 발명의 명칭, 요약, 대표청구항인 경우 OR로 연결 
		var searchFormulaOr = '';
		for(var i=0; i<arrResultOr.length; i++){
			console.log(":::::arrResultOr:::::");
			console.log(arrResultOr[i])
			var oResult = arrResultOr[i];
			if(oResult['keyword'] != '()'){
				if(i != 0){
					searchFormulaOr += mapConjunction['OR'][dbType];
				} 
				searchFormulaOr += oResult['keyword'];
			}
		}
		searchFormulaOr = arrResultOr.length < 2 ? searchFormulaOr : '('+searchFormulaOr+')';
		
		// 그외 필드인 경우에는 AND로 연결 
		var searchFormula = '';
		for(var i=0; i<arrResult.length; i++){
			console.log(":::::arrResult:::::");
			console.log(arrResult[i])
			var oResult = arrResult[i];
			if(oResult['keyword'] != '()'){
				if(i != 0){
					searchFormula += mapConjunction['AND'][dbType];
				} 
				searchFormula += oResult['keyword'];
			}
		}
		if(searchFormulaOr != '')
			searchFormula += mapConjunction['AND'][dbType] + searchFormulaOr;

		// 키프리스를 위한 검색식 만들기  
		var searchFormulaKp = '';
		for(var i=0; i<arrResultKp.length; i++){
			console.log(":::::arrResult:::::");
			console.log(arrResultKp[i])
			var oResult = arrResultKp[i];
			if(oResult['keyword'] != '()'){
				if(i != 0){
					searchFormulaKp += mapConjunction['AND'][dbType];
				} 
				searchFormulaKp += oResult['keyword'];
			}
		}
		if(searchFormulaOr != '')
			searchFormulaKp += mapConjunction['AND'][dbType] + searchFormulaOr;
		
		return searchFormula+","+searchFormulaKp;
	};
	
	
	//
	// 검색식 생성
	//
	this.generate = function(arrKeyword, dbType){
		
		var searchFormula = assemble(arrKeyword, dbType);
		return searchFormula;
	};
};




//
// 검색식 분석자 클래스
// WipsonParser, FocustParser, KiprisParser의 super class
//
var SearchFormulaParser = function(){
	
	var EXPR_DB_TYPE_WIPSON = /\(.+?\)\..+\./;
	var EXPR_DB_TYPE_FOCUST = /.+?=\(.+?\)/;
	var EXPR_DB_TYPE_KIPRIS = /.+?=\[.+?\]/;
	
		
	this.arrKeywordOperator = [
	    /*{변경할문자열,,					WIPSON 변경대상 정규식},					FOCUST 변경대상 정규식,										KIPRIS 변경대상 정규식}*/
      	  {'STR':'==@@==',					'WIPSON':/\?/gi,							'FOCUST':/\?/gi,											'KIPRIS':SearchFormula.EXPR_NONE}
	    , {'STR':' AND ',					'WIPSON':/ AND /gi,							'FOCUST':/ AND /gi,											'KIPRIS':/\*/gi}
      	, {'STR':' ',						'WIPSON':/ OR /gi,							'FOCUST':/ OR /gi,											'KIPRIS':/\+/gi}
      	, {'STR':' NOT~~@@~~',				'WIPSON':/ NOT /gi,							'FOCUST':/ NOT /gi,											'KIPRIS':/!/gi}
      	, {'STR':'$1 ADJ$2~~@@~~$3',		'WIPSON':/(.+) ADJ((?:\d|)) (.+)/gi,		'FOCUST':/(.+) (?:WITHIN|W)(?:\/|)((?:\d|)) (.+)/gi,		'KIPRIS':SearchFormula.EXPR_NONE}
      	, {'STR':'$1 NEAR$2~~@@~~$3',		'WIPSON':/(.+) NEAR((?:\d|)) (.+)/gi,		'FOCUST':/(.+) (?:NEAR|N)(?:\/|)((?:\d|)) (.+)/gi,			'KIPRIS':/(.+)\^(:?\d|)(.+)/gi}
      	, {'STR':'$1==@@== ',				'WIPSON':SearchFormula.EXPR_NONE,			'FOCUST':SearchFormula.EXPR_NONE,							'KIPRIS':/(.+?[^\)])\s/gi}
      	, {'STR':'$1==@@==$2',				'WIPSON':SearchFormula.EXPR_NONE,			'FOCUST':SearchFormula.EXPR_NONE,							'KIPRIS':/(.+?)(:?\)|\])/gi}
      	, {'STR':'$1==@@==',				'WIPSON':SearchFormula.EXPR_NONE,			'FOCUST':SearchFormula.EXPR_NONE,							'KIPRIS':/(.+[^\)|^\]])$/gi}
      	
      	/* 
      	 * 문자 원위치
      	 */
      	, {'STR':'*',						'WIPSON':/==@@==/gi,						'FOCUST':/==@@==/gi,										'KIPRIS':/==@@==/gi}
      	, {'STR':' ',						'WIPSON':/~~@@~~/gi,						'FOCUST':/~~@@~~/gi,										'KIPRIS':/~~@@~~/gi}
    ];
	
	this.arrKeyword = new Array();

	
	
	//
	// DB유형검사
	//
	this.checkDbType = function(strTarget){

		var arrResult = strTarget.match(EXPR_DB_TYPE_WIPSON);
		if(arrResult){
			return SearchFormula.DB_TYPE_WIPSON;
		}
		
		arrResult = strTarget.match(EXPR_DB_TYPE_FOCUST);
		if(arrResult){
			return SearchFormula.DB_TYPE_FOCUST;
			
		}
		
		arrResult = strTarget.match(EXPR_DB_TYPE_KIPRIS);
		if(arrResult){
			return SearchFormula.DB_TYPE_KIPRIS;
		}
		
		return SearchFormula.DB_TYPE_WIPSON;
	};
	
	
	//
	// 의미없는 외부괄호 제거
	//
	this.removeUselessParenthesis = function(strTarget){
		
		// 인접연산자(near, adj, within, ^)의 경우 의미있는 괄호처리 
		var procNearOperator = function(strTarget){
			var arrFront = strTarget.match(/^.+(?:near|adj|within|\^)/i);	// 인접연산자의 앞부분
			var arrEnd = strTarget.match(/(?:near|adj|within|\^).+$/i);		// 인접연산자의 뒷부분
			var strFront = '';
			var strEnd = '';
			if(arrFront){
				var frontInsideStr = arrFront[0].getFirstStrBetweenParameters('(', ')');
				strFront = arrFront[0].replace(frontInsideStr, '');
			}
			if(arrEnd){
				var endInsideStr = arrEnd[0].getFirstStrBetweenParameters('(', ')');
				strEnd = arrEnd[0].replace(endInsideStr, '');
			}
			if(strFront.match(/^\(\) (?:near|adj|within|\^)/i)){			// near 앞부분의 문자가 빈괄호('()')일경우 문자열에 괄호를 감싸준다.
				strTarget = '('+strTarget +')';
			}else if(strEnd.match(/(?:near|adj|within|\^) \(\)$/i)){		// near 뒷부분의 문자가 빈괄호('()')일경우 문자열에 괄호를 감싸준다.
				strTarget = '('+strTarget +')';
			}
			return strTarget;
		};
		strTarget = procNearOperator(strTarget);
		
		if(strTarget.match(/\(|\)|\[|\]/) == null){	// 괄호가 없을경우 외부에 괄호를 감싼다.
			strTarget = '('+strTarget+')';
			return strTarget;
		}
		
		// 괄호안에 더이상의 괄호가 없는 경우 가장 외부의 괄호라 할지라도 의미가 있는 괄호이다.
		// e.g. (keyword)
		var testTarget = strTarget.getFirstStrBetweenParameters('(', ')');
		if(testTarget.match(/\(|\)/gi) == null){	
			return strTarget;
		}
		
		var exprOpenParenthesis = /\(/gi;			// 여는괄호('(')를 뽑아내기위한 정규식.
		var exprNotParenthesis = /[^\(||^\)]/gi;	// 괄호('(', ')')를 제외하기위한 정규식.
		
		//
		// 가장 안쪽의 괄호내용을 가지고온다.
		//
		var getLastInsideStrBetweenParameters = function(strTarget, opener, closer){
			
			if(strTarget.match(exprNotParenthesis) == null){		// 괄호안의 내용이 괄호만 남은경우
				return '';
			}
			while(true){
				var insideStr = strTarget.getFirstStrBetweenParameters(opener, closer);
				if(insideStr == ''){		// 괄호안의 내용이 없는경우
					break;
				}
				strTarget = insideStr;
			}
			return strTarget;
		};

		var arrStrStack = new Array();
		var tmpStrTarget = strTarget;
		var historyStrTarget = strTarget;
		while(true){
			var lastInsideStr = getLastInsideStrBetweenParameters(tmpStrTarget, '(', ')');
			if(lastInsideStr == ''){	// 가장 안쪽괄호의 문자열이 더이상 없다면 루프를 종료한다.
				break;
			}
			tmpStrTarget = tmpStrTarget.replace(lastInsideStr, '');	// 가장 안쪽괄호의 문자열을 공백문자로 치환한다.
		}
		var arrResult = tmpStrTarget.match(exprOpenParenthesis);
		if(arrResult){
			var parenthesisCnt = arrResult.length;		// 의미없는 괄호쌍의 개수를 구한다.
			strTarget = strTarget.substring(parenthesisCnt, strTarget.length-parenthesisCnt);
		}
		
		strTarget = procNearOperator(strTarget);
		//alert('strTarget : ' + strTarget);
		return strTarget;
	};
	
	
	//
	// 키워드의 파라미터 분석
	//
	this.parseParameters = function(oKeyword){
		
		var exprNear = / ADJ[\d] | NEAR[\d] | ADJ | NEAR /gi;
		
		var keyword = oKeyword['keyword'];
		//alert('keyword : ' + keyword);
		arrResult = keyword.match(exprNear);
		//alert(arrResult);
		if(arrResult){
			oKeyword['parameters'] = new Array();
			var sharpIdx = 1;
			for(var i=0; i<arrResult.length; i++){
				var idx = keyword.indexOf(arrResult[i]);
				var beginIdx = -1;
				var orgLeftParam = '';
				var leftParam = '';
				var ch = keyword.charAt(idx-1, idx);
				if(ch == ')'){					// 닫는괄호가 있다면 시작하는 괄호를 찾는다.
					beginIdx = keyword.regexLastIndexOf(/\(/, idx-1);
					orgLeftParam = keyword.substring(beginIdx, idx);
					leftParam = orgLeftParam;
				}else{
					beginIdx = keyword.regexLastIndexOf(/\s|\(/, idx-1)+1;
					orgLeftParam = keyword.substring(beginIdx, idx);
					leftParam = '('+orgLeftParam+')';
				}
				
				beginIdx = idx + arrResult[i].length;
				var orgRightParam = '';
				var rightParam = '';
				var ch = keyword.charAt(beginIdx);
				var endIdx = -1;
				if(ch == '('){					// 시작괄호가 있다면 닫는 괄호를 찾는다.
					endIdx = keyword.regexIndexOf(/\)/, beginIdx);
					orgRightParam = keyword.substring(beginIdx, endIdx+1);
					rightParam = orgRightParam;
				}else{
					endIdx = keyword.regexIndexOf(/\s|\)|$/, beginIdx)-1;
					orgRightParam = keyword.substring(beginIdx, endIdx+1);
					rightParam = '('+orgRightParam+')';
				}
				
				keyword = keyword.replace(orgLeftParam, '#'+(sharpIdx++));
				keyword = keyword.replace(orgRightParam, '#'+(sharpIdx++));
				oKeyword['keyword'] = keyword;
				var oParameter1 = new Object();
				oParameter1['parameter'] = leftParam.getFirstStrBetweenParameters('(', ')');
				oParameter1['field'] = '';
				oKeyword['parameters'].push(oParameter1);
				
				var oParameter2 = new Object();
				oParameter2['parameter'] = rightParam.getFirstStrBetweenParameters('(', ')');
				oParameter2['field'] = '';
				oKeyword['parameters'].push(oParameter2);
			}
		}
		
		return oKeyword;
	};
};




//
// #문자열 반환 반복자
//
var SharpIterator = function(keyword){
	
	var CNT_SHARP_STRING = 2;	// #뒤로 1자리(#포함 2자리)를 샵스트링으로 인지한다.
	
	var idx = -1;
	var beginIdx = -1;
	var endIdx = -1;
	
	this.nextSharp = function(){
		beginIdx = keyword.indexOf('#', endIdx);
		endIdx = beginIdx + CNT_SHARP_STRING;
		var str = keyword.substring(beginIdx, endIdx);
		if(beginIdx > -1 && str.length == CNT_SHARP_STRING){
			lastIdx = endIdx;
			idx++;
			return keyword.substring(beginIdx, endIdx); 
		}else{
			beginIdx = -1;
			lastIdx = -1;
		}
		return '';
	};
	
	this.getIdx = function(){
		return idx;
	};

	this.replace = function(target){
		var head = keyword.substring(0, beginIdx);
		var tail = keyword.substring(endIdx, keyword.length);
		keyword = head + target + tail;
		endIdx = beginIdx + target.length;
		return keyword;
	};
};