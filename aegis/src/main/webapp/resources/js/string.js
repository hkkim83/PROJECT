String.prototype.startsWith = function(suffix) {
    return this.indexOf(suffix, 0, suffix.length) !== -1;
};

String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
};

String.prototype.replaceAll = function(src, target) {
    return this.split(src).join(target);
};


String.prototype.trim = function(){ 
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

String.prototype.ltrim = function(){ 
	return this.replace(/(^\s*)/g, "");
};

String.prototype.rtrim = function(){ 
	return this.replace(/(\s*$)/g, "");
};


//
// 천단위 콤마
//
String.prototype.addCommas = function()
{
	x = this.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
};


//
//날짜 하이픈
//
String.prototype.addDateHyphen = function()
{
	return this.substr(0, 4) + "-" + this.substr(4, 2) + "-" + this.substr(6, 2);
};


//
// 이메일 검사
//
String.prototype.isEmailValid = function(){
	
	var expr =  /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	//alert(this);
	if(!expr.test(this)){
		return false;
	}
	return true;
	
	/*var pattern = new RegExp(/^(("[\w-+\s]+")|([\w-+]+(?:\.[\w-+]+)*)|("[\w-+\s]+")([\w-+]+(?:\.[\w-+]+)*))(@((?:[\w-+]+\.)*\w[\w-+]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][\d]\.|1[\d]{2}\.|[\d]{1,2}\.))((25[0-5]|2[0-4][\d]|1[\d]{2}|[\d]{1,2})\.){2}(25[0-5]|2[0-4][\d]|1[\d]{2}|[\d]{1,2})\]?$)/i);
    return pattern.test(emailAddress);*/
};




//
//opener와 closer 사이의 내용 반환
//
String.prototype.getFirstStrBetweenParameters = function(opener, closer){

	var cnt = 0;
	var startIdx = 0;
	var endIdx = this.length-1;
	var isStartParenthesisIncluded = false;
	for(var i=0; i<this.length; i++){
		var ch = this.charAt(i);
		if(ch == opener){
			cnt++;
			if(cnt == 1){
				isStartParenthesisIncluded = true;
				startIdx = i;
			}
		}else if(ch == closer){
			cnt--;
		}
		
		if(isStartParenthesisIncluded && cnt == 0){
			endIdx = i;
			return this.substring(startIdx+1, endIdx);
		}
	}
	return '';
};



String.prototype.lpad = function(target, length) {
    var result = this;
	if (!target || result.length >= length) {
        return result;
    }
    var max = (length-result.length)/target.length;
    for (var i=0; i<max; i++) {
    	result = target + result;
    }
    return result;
};

String.prototype.rpad = function(target, length) {
	var result = this;
	if (!target || result.length >= length) {
        return result;
    }
    var max = (length-result.length)/target.length;
    for (var i=0; i<max; i++) {
    	result += target;
    }
    return result;
};



String.prototype.regexIndexOf = function(regex, startpos) {
    var indexOf = this.substring(startpos || 0).search(regex);
    return (indexOf >= 0) ? (indexOf + (startpos || 0)) : indexOf;
};

String.prototype.regexLastIndexOf = function(regex, startpos) {
    regex = (regex.global) ? regex : new RegExp(regex.source, "g" + (regex.ignoreCase ? "i" : "") + (regex.multiLine ? "m" : ""));
    if(typeof (startpos) == "undefined") {
        startpos = this.length;
    } else if(startpos < 0) {
        startpos = 0;
    }
    var stringToWorkWith = this.substring(0, startpos + 1);
    var lastIndexOf = -1;
    var nextStop = 0;
    while((result = regex.exec(stringToWorkWith)) != null) {
        lastIndexOf = result.index;
        regex.lastIndex = ++nextStop;
    }
    return lastIndexOf;
};