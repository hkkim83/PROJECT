//
// FOCUST DB 분석자 클래
//
var FocustParser = function(){
	
	// 날짜형식의 키워드 정규식 e.g. (AD>=2012) AND (AD<=2013)
	var exprDateKeyword = /AD[<|>]|PD[<|>]|PDE[<|>]|RD[<|>]|PRD[<|>]/;
	
	
	this.parse = function(strSource){
		
		if(strSource.trim() == ''){
			return null;
		}
		
		var oKeyword = new Object();
		
		// 키워드 parsing
		{
			var arrResult = strSource.match(/^[^\(].+?=\(/);	// 키워드가 포함된 형태인지 검사. e.g. TI=(
			if(arrResult){		// 필드값 parsing
				var idx = strSource.indexOf('=');
				field = strSource.substring(0, idx);
				strSource = strSource.replace(field+'=', '');
				oKeyword['field'] = field.toUpperCase();
			}else{
				oKeyword['field'] = '';
			}
			
			var keyword = strSource.getFirstStrBetweenParameters('(', ')');
			strSource = strSource.replace('('+keyword+')', '');
			for(var i=0; i<this.arrKeywordOperator.length; i++){
				var operator = this.arrKeywordOperator[i];
				//console.debug('aaaaaa = ' + operator['FOCUST'] + ' = ' + operator['STR'] + ' : ' + keyword);
				keyword = keyword.replace(operator['FOCUST'], operator['STR']);
				//console.debug('bbbbbb = ' + operator['FOCUST'] + ' = ' + operator['STR'] + ' : ' + keyword);
			}
			oKeyword['keyword'] = keyword.trim();
			
			var arrResult = oKeyword['keyword'].match(exprDateKeyword);
			if(arrResult){ 			// 키워드가 날짜형식이라면...
				var from = oKeyword['keyword'].match(/>=\d+/);
				if(from){
					from = from[0].substring(2);
				}else{
					from = '';
				}
				var to = oKeyword['keyword'].match(/<=\d+/);
				if(to){
					to = to[0].substring(2);
				}else{
					to = '';
				}
				oKeyword['keyword'] = from+'-'+to;
				oKeyword['field'] = arrResult[0].substring(0, arrResult[0].length-1);
			}
			
			
			// 키워드에 near 또는 adj가 포함될 경우 파라미터를 추가한다.
			{
				oKeyword = this.parseParameters(oKeyword);
			}
			
		}
		
		
		// 연산자 parsing
		{
			if(strSource.trim() != ''){
				strSource = strSource.ltrim();	// 왼쪽 공백제거
				var conjunction = '';
				if(strSource.substring(0, 3).toUpperCase() == 'AND'){
					conjunction = 'AND';
				}else if(strSource.substring(0, 2).toUpperCase() == 'OR'){
					conjunction = 'OR';
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