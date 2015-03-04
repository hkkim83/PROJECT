//
// FOCUST DB 분석자 클래
//
// TODO 연산자 치환, 파라미터(#1, #2...) 치환
var KiprisParser = function(){
	
	// 날짜형식의 키워드 정규식 e.g. AD=[20120101~20121231]
	var exprDateKeyword = /AD|OPD|PD|GD|RD/;
	
	
	this.parse = function(strSource){
		console.log(4);
		
		if(strSource.trim() == ''){
			return null;
		}

		var oKeyword = new Object();
		console.log(5);
		
		// 키워드 parsing
		{
			var keyword = '';
			var firstCh = strSource.charAt(0);
			console.log(6);
			
			if(firstCh != '('){
				var arrResult = strSource.match(/.+?=\[/);
				console.log("strSource::::"+strSource);
				console.log("arrResult11::::"+arrResult);
				console.log("arrResult22::::"+arrResult[0]);
				if(arrResult){
					var errorIdx = arrResult[0].regexLastIndexOf(/\*|\+/);
					// 시작문자가 '('가 아니고 필드도 포함되지않을경우('*', '+'가 포함된경우 올바른 필드가 아니다.)의 키워드를 선택한다.
					// e.g. 자동차*엔진*AN=[1020020012345] ==> keyword = 자동차*엔진
					if(errorIdx != -1){
						oKeyword['field'] = '';
						keyword = strSource.substring(0, errorIdx);
						strSource = strSource.replace(keyword, '');
					}
					// 올바른 필드인경우
					else{
						var idx = strSource.indexOf('=');
						field = strSource.substring(0, idx);
						strSource = strSource.replace(field+'=', '');
						oKeyword['field'] = field.toUpperCase();
						keyword = strSource.getFirstStrBetweenParameters('[', ']');
						strSource = strSource.replace('['+keyword+']', '');
						if(oKeyword['field'].match(exprDateKeyword)){			// 날짜형태의 키워드일경우
							keyword = keyword.replace(/(\d)~(\d)/, '$1-$2');
						}
					}
				}
			}else{		// 필드가 전체인경우
				oKeyword['field'] = '';
				keyword = strSource.getFirstStrBetweenParameters('(', ')');
				strSource = strSource.replace('('+keyword+')', '');
			}
			if(oKeyword['field'].match(exprDateKeyword) == null){		// 날짜형태의 키워드일경우 연산자를 변경하지 않는다.
				for(var i=0; i<this.arrKeywordOperator.length; i++){
					var operator = this.arrKeywordOperator[i];
					//console.debug('111 = ' + operator['KIPRIS'] + ' = ' + operator['STR'] + ' : ' + keyword);
					keyword = keyword.replace(operator['KIPRIS'], operator['STR']);
					//console.debug('222 = ' + operator['KIPRIS'] + ' = ' + operator['STR'] + ' : ' + keyword);
				}
			}
			oKeyword['keyword'] = keyword.trim();
			
			// 키워드에 near 또는 adj가 포함될 경우 파라미터를 추가한다.
			oKeyword = this.parseParameters(oKeyword);
		}
		
		console.log(7);
		
		// 연산자 parsing
		{
			console.log(8);
			if(strSource.trim() != ''){
				strSource = strSource.ltrim();	// 왼쪽 공백제거
				var conjunction = '';
				if(strSource.substring(0, 1).toUpperCase() == '*'){
					conjunction = '\\*';
				}else if(strSource.substring(0, 1).toUpperCase() == '+'){
					conjunction = '\\+';
				}else{
					alert('지원하지않는 검색식입니다.\n' + strSource);
					throw 'error';
				}
				strSource = strSource.replace(eval('/'+conjunction+'/i'), '');
			}
		}
		this.arrKeyword.push(oKeyword);
		
		strSource = strSource.trim();
		if(strSource == ''){
			//alert(JSON.stringify(this.arrKeyword));
			return this.arrKeyword;
		}else{
			return this.parse(strSource);
		}
	};
};