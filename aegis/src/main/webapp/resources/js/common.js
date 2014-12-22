Common = {};

// 공통코드 조회
Common.getCommonCodeList = function(groupCode){

  console.log("getCommonCodeList:::"+groupCode);
	var result = null;
	
	var strParam = 'GROUP_CODE=' + groupCode;
	$.ajax({
		url : "/commcode.do",
		type : "POST",
		async : false,
		data : strParam,
		success : function(data) {
			result = data.COMMON_CODE;
		}
	});	
	return result;
};

// 공통코드 콤보 셋팅
Common.setCommonCodeCombo = function(groupCode, $combo, fn) {
  console.log("setCommonCodeCombo::"+groupCode);
	$combo.find('option').remove();
	var data = Common.getCommonCodeList(groupCode);
	$.each(data, function() {
		var $option = $("<option></option>");
		$option.val(this['COMM_CODE']);
		$option.text(this['COMM_NAME']);
		if(this['VAL_1'] != null && this['VAL_1'] != ''){
			$option.attr('VAL_1', this['VAL_1']);
		}else if(this['VAL_2'] != null && this['VAL_2'] != ''){
			$option.attr('VAL_2', this['VAL_2']);
		}else if(this['VAL_3'] != null && this['VAL_3'] != ''){
			$option.attr('VAL_3', this['VAL_3']);
		}
		$combo.append($option);
		if(fn != null){
			return fn.call(this, $option[0]);
		}
	});
};

// 로그인 체크
Common.checkLogin = function(){
	var result = false;
	var strParam = '';
	$.ajax({
		url : "/checkLogin.do",	// 세션검사를 위해서만 사용.
		type : "POST",
		async : false,
		data : strParam,
		success : function(data) {
			if(data.RESULT_CD != 'ERR_9999'){
				result = true;
			}
		}
	});	
	return result;	
};

//
// json object를 문자열로 반환
// ajax post전송시 '+'문자가 인코딩되지않아서 encodeURIComponent함수처리.
//
Common.stringify = function(oJson){
	return encodeURIComponent(JSON.stringify(oJson));
};

// 데이터 인코딩 
Common.encodeURI = function(str){
	return encodeURIComponent(str);
};
	
// 세션 체크
Common.checkSession = function(data){
	// 정상처리
	if(data.RESULT_CD == 'SUCC_0001'){
		return true;
	}
	
	return false;
};

// 데이터 변경하기 
// &, + 같은 특수문자 처리
Common.replace = function(str) {
    str = str.replace(/&/g,"%26"); 
    str = str.replace(/\+/g,"%2B"); 
    return str;
};

// 카테고리 리스트 조회
Common.getCategoryList = function(projectId, flag, cate){
	
	var result = null;
	
	var strParam = 'PROJECT_ID=' + projectId + '&FLAG=' + flag + '&CATE=' + cate;
	$.ajax({
		url : "/category/categoryList.do",
		type : "POST",
		async : false,
		data : strParam,
		success : function(data) {
			result = data.LIST;
		}
	});	
	return result;
};

// 카테고리 콤보 셋팅
Common.setCategoryCombo = function(projectId, flag, cate, $combo, fn) {
	$combo.find('option').remove();
	var data = Common.getCategoryList(projectId, flag, cate);
	var $option = $("<option></option>");
	$option.val(null);
	$option.text("선택");
	$combo.append($option);
	$.each(data, function() {
		$option = $("<option></option>");
		$option.val(this['CATE']);
		$option.text(this['CATE']);
		$combo.append($option);
		if(fn != null){
			return fn.call(this, $option[0]);
		}
	});
};

// ajax 초기 설정
$(document).ready(function(){
	
	$.ajaxSetup({
		  cache: true
		, dataType: 'json'
		, timeout: 60000
		, type: 'POST'
		, async: false
		, error: function(xhr, status, error){
			alert('An error occurred: ' + '\nxhr : ' + xhr + '\n status : ' + status + '\n error : ' + error);
		}
		, dataFilter:function(data, type) {
			var objJson = jQuery.parseJSON(data);
			Common.checkSession(objJson);
			return data;
		}
	});
});

// 그리드 설정
var CommonGrid = function(gridName, arr) {
	this.grid = new dhtmlXGridObject(gridName);
	this.dp = new dataProcessor();
	
	var v_header="";	
	var v_Ids="";		
    var v_width="";		
    var v_align="";		
    var v_types="";		
    var v_sorting="";	
    var cm = "";
    
    for(var i=0;i<arr.length;i++){    
      if(i != 0) cm=",";      
      v_header=v_header+cm+arr[i][0];
      v_Ids=v_Ids+cm+arr[i][1];
      v_width=v_width+cm+arr[i][2];
      v_align=v_align+cm+arr[i][3];
      v_types=v_types+cm+arr[i][4];
      v_sorting=v_sorting+cm+arr[i][5];
    }
	
    this.grid.setImagePath("/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/imgs/");
    this.grid.setHeader(v_header);		// 헤더설정
    this.grid.setColumnIds(v_Ids);		// 컬럼 ID 설정
	this.grid.setInitWidths(v_width);	// 컬럼 너비 설정
	this.grid.setColAlign(v_align);		// 컬럼 정렬 설정
	this.grid.setColTypes(v_types); 	// 컬럼 타입 설정
	this.grid.setColSorting(v_sorting);	// 컬럼 정렬여부
    this.grid.setSkin("dhx_skyblue");	// skin 설정
	this.grid.enableEditEvents(true,false,false);  
    this.grid.init();
    
    // 저장 데이터셋 설정
	this.dp = new dataProcessor();
	this.dp.enableDataNames(true);
	this.dp.setUpdateMode("off");
	this.dp.setTransactionMode("POST", true);
	this.dp.autoUpdate=false;
	this.dp.init(this.grid);	
}; 

// 객체를 배열로 변경
CommonGrid.prototype.getObjectToArray = function(data) {
	var dataArray = new Array();
	$.each(data, function(index, m) {
		for(var col=0; col<this.grid.getColumnsNum(); col++) {
			var colid = this.grid.getColumnId(col);
			if(col == 0) {
				dataObj[colid] = colid == "CHK" ? "0" : index+1;
			} else {
				dataObj[colid] = m[colid];	
			}	
		}
		dataArray.push(columnArray);
	});
	return dataArray;
};
	
// 데이터 직렬화
CommonGrid.prototype.serialize = function(status) {
	var dataArray = new Array();

	for(var row=0; row < this.dp.updatedRows.length; row++) {
		var dataObj = new Object();
		var rowId = this.dp.updatedRows[row];
		if(status == undefined) {
			dataObj["STATUS"] = this.dp.getState(rowId).toUpperCase();
		} else {
			dataObj["STATUS"] = status;
		}
		for(var col=0; col<this.grid.getColumnsNum(); col++) {
			dataObj[this.grid.getColumnId(col)] = this.grid.cells(rowId,col).getValue();	
		}
		dataArray.push(dataObj);
	}
	return Common.stringify(dataArray);
};

// 데이터 배열(jsarray)로 저장
CommonGrid.prototype.parse = function(data) {
	var dataArray = new Array();
	for(var i=0; i<data.length; i++) {
		var map = data[i];
		var columnArray = new Array();
		for(var col=0; col<this.grid.getColumnsNum(); col++) {
			var colid = this.grid.getColumnId(col);
			if(col == 0) {
				columnArray[col] = colid == "CHK" ? "0" : i+1;
			} else {
				columnArray[col] = map[colid];	
			}	
		}
		dataArray.push(columnArray);
	}
	this.grid.clearAll();
	this.grid.parse(dataArray, 'jsarray');
};

// data값으로 일치하는 행 가져오기
CommonGrid.prototype.findRow = function(colId, data) {
	var ret = 0;
	for(var row=0; row<this.grid.getRowsNum(); row++) {
		if(this.grid.cells2(row, colId).getValue() == data) {
			ret = row;
			break;
		}
	}
	return ret;
};

// 셀렉터와 그리드 연결하기
CommonGrid.prototype.bindData = function(rowId) {
	for(var col=0; col<this.grid.getColumnsNum(); col++) {
		$('#'+this.grid.getColumnId(col)).val(this.grid.cells(rowId,col).getValue());
	}
};

// 셀렉터의 값 데이터셋에 셋팅하기
CommonGrid.prototype.setData = function(colId) {
	var rowId = this.grid.getSelectedId();
	var val = $('#'+colId).val();
	this.grid.cells(rowId,this.grid.getColIndexById(colId)).setValue(val);
	if(this.grid.getUserData(rowId,"!nativeeditor_status") == "") {
		this.dp.setUpdated (rowId, true );
	}
};

// 그리드 포커스 
CommonGrid.prototype.setFocusGrid = function(rowId, colId) {
	var row = this.grid.getRowIndex(rowId);
	var col = this.grid.getColIndexById(colId);
    this.grid.selectCell(row,col);
};

// 그리드 포커스
CommonGrid.prototype.setFocusGrid2 = function(row, col) {
    window.setTimeout(function(){
        this.grid.selectCell(row,col);
	},1);
};

// 셀렉터 포커스
CommonGrid.prototype.setFocusSelector = function(rowId, colId) {
	this.grid.selectRowById(rowId);
	$('#'+colId).focus();
};

// 빈값 체크
CommonGrid.prototype.isNull = function(rowId, colId) {
	var col = this.grid.getColIndexById(colId);
	if(this.grid.cells(rowId, col).getValue() == "") {
		return true;
	}
	return false;
};

// 변경여부 체크
CommonGrid.prototype.isUpdated = function() {
	if(this.dp.updatedRows.length < 1) return false;
	return true;
};

// 삽입여부 체크
CommonGrid.prototype.isInserted = function() {
	var cnt = 0;
	for(var i=0; i<this.dp.updatedRows.length; i++) {
		var rowId = this.dp.updatedRows[i];
		if(this.dp.getState(rowId) == "inserted") cnt++;
	}
	return cnt > 0;
};

// 삭제여부 체크
CommonGrid.prototype.isDeleted = function() {
	var cnt = 0;
	for(var i=0; i<this.dp.updatedRows.length; i++) {
		var rowId = this.dp.updatedRows[i];
		if(this.dp.getState(rowId) == "deleted") cnt++;
	}
	return cnt > 0;
};

/** 
 * string String::cut(int len)
 * 글자를 앞에서부터 원하는 바이트만큼 잘라 리턴합니다.
 * 한글의 경우 2바이트로 계산하며, 글자 중간에서 잘리지 않습니다.
 */
 String.prototype.cut = function(len) {
         var str = this;
         var l = 0;
         for (var i=0; i<str.length; i++) {
                 l += (str.charCodeAt(i) > 128) ? 2 : 1;
                 if (l > len) return str.substring(0,i) + "...";
         }
         return str;
 };

 /** 
 * bool String::bytes(void)
 * 해당스트링의 바이트단위 길이를 리턴합니다. (기존의 length 속성은 2바이트 문자를 한글자로 간주합니다)
 */
 String.prototype.bytes = function() {
         var str = this;
         var l = 0;
         for (var i=0; i<str.length; i++) l += (str.charCodeAt(i) > 128) ? 2 : 1;
         return l;
 };