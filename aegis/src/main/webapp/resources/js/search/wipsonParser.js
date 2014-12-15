//
// WIPSON DB 분석자 클래스
//
WipsonParser = function(){
	
	// 날짜형식의 키워드 정규식 e.g. (@AD>=2012<=2013)
	var exprDateKeyword = /@AD|@PD|@FD|@RD|@PRD/;
	
	
	this.parse = function(strSource){
		
		if(strSource.trim() == ''){
			return null;
		}
		
		var oKeyword = new Object();
		
		// 키워드 parsing
		{
			var keyword = strSource.getFirstStrBetweenParameters('(', ')');
			strSource = strSource.replace('('+keyword+')', '');
			for(var i=0; i<this.arrKeywordOperator.length; i++){
				//console.debug('111 = ' + this.arrKeywordOperator[i]['WIPSON'] + ' : ' + keyword);
				keyword = keyword.replace(this.arrKeywordOperator[i]['WIPSON'], this.arrKeywordOperator[i]['STR']);
				//console.debug('222 = ' + this.arrKeywordOperator[i]['WIPSON'] + ' : ' + keyword);
			}
			oKeyword['keyword'] = keyword.trim();
			
			// 키워드에 near 또는 adj가 포함될 경우 파라미터를 추가한다.
			oKeyword = this.parseParameters(oKeyword);
		}
		
		
		// 필드값 parsing
		{
			var field = '';
			var ch = strSource.charAt(0);
			if(ch == '.'){
				var idx = strSource.indexOf('.', 1);
				field = strSource.substring(0, idx+1);
				strSource = strSource.replace(field, '');
				field = field.substring(1, field.length-1);
				oKeyword['field'] = field.toUpperCase();
			}else{
				var arrResult = oKeyword['keyword'].match(exprDateKeyword);		// 키워드가 날짜형식이라면...
				if(arrResult){
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
					oKeyword['field'] = arrResult[0].substring(1, arrResult[0].length);
				}else{
					oKeyword['field'] = '';
				}
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

