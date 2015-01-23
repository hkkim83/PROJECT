<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<script type="text/javascript">
<!--
//-->
(function($){
	var List1 = {};
	var List2 = {};
	var List3 = {};
	var List4 = {};
	var rowPos = 0;
	var savePK = "";
	// 그리드 초기화
	var initGrid1 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
	    arr[idx++] = [""      		,"ADMIN_ID"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["프로젝트명" 		,"PROJECT_NAME"	,"*"	,"left"		,"edtxt","str"	,"false"];
	    
		List1 = new CommonGrid('gridList1', arr);
		List1.grid.attachEvent("onRowSelect", function(rId,cInd){detailList(rId);});

	};

	// 그리드 초기화
	var initGrid2 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
		arr[idx++] = ["" 			,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["아이디"      	,"ID"			,"150"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["이름" 			,"NAME"			,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"WRITE_YN"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    
		List2 = new CommonGrid('gridList2', arr);
		List2.grid.attachEvent("onRowDblClicked", function(rId,cInd){ saveAuth(List2, rId, "X");});  
	};

	// 그리드 초기화
	var initGrid3 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
		arr[idx++] = ["" 			,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["아이디"      	,"ID"			,"150"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["이름" 			,"NAME"			,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"WRITE_YN"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    
		List3 = new CommonGrid('gridList3', arr);
		List3.grid.attachEvent("onRowDblClicked", function(rId,cInd){ saveAuth(List3, rId, "1");});
	};

	// 그리드 초기화
	var initGrid4 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"str"	,"false"];
		arr[idx++] = ["" 			,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["아이디"      	,"ID"			,"150"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["이름" 			,"NAME"			,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"WRITE_YN"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    
		List4 = new CommonGrid('gridList4', arr);
		List4.grid.attachEvent("onRowDblClicked", function(rId,cInd){ saveAuth(List4, rId, "X");});
	};
	
	// 저장 데이터셋 초기화
	var clearData = function() {
		List1.dp.updatedRows=[];
		List1.dp._in_progress={};
		List2.dp.updatedRows = [];
		List2.dp._in_progress = {};
		List3.dp.updatedRows = [];
		List3.dp._in_progress = {};
		List4.dp.updatedRows = [];
		List4.dp._in_progress = {};		
	};
	
	// 리스트 조회
	var searchList = function() {
		List2.grid.clearAll();
		var strParam = "";
		$.ajax({
			url : '/project/list.do',
			data : strParam,
			cache : false,
			success : function(data) {
				List1.parse(data.LIST);
				// 저장한 값이 있으면 행을 찾아준다.
				if(savePK != "") {
					var colId = List1.grid.getColIndexById("PROJECT_NAME");
					rowPos = List1.findRow(colId, savePK);
					savePK = "";
				}
				List1.grid.selectRow(rowPos);
				detailList(List1.grid.getRowId(rowPos));
			}
		});		
	};
	
	// 상세 조회
	var detailList = function(rowId) {
		List2.grid.clearAll();
		List3.grid.clearAll();
		List4.grid.clearAll();
		if(List1.dp.getState(rowId) != "inserted") {
			var projectId = List1.grid.cells(rowId, List1.grid.getColIndexById("PROJECT_ID")).getValue();
			var strParam = "PROJECT_ID="+projectId;
			$.ajax({
				url : '/project/detail.do',
				data : strParam,
				cache : false,
				success : function(data) {
					List2.parse(data.WRITE_LIST);
					List3.parse(data.USER_LIST);
					List4.parse(data.READ_LIST);
				}
			});				
		}	
	};
	
	// 정합성 체크
	var checkVal = function(str, obj) {
		if(str == "SAVE") {
			if(!List1.isUpdated()) {
				alert("저장할 데이터가 존재하지 않습니다. 다시 확인해보시기 바랍니다.");
				return false;
			}
			
			for(var i=0; i<List1.dp.updatedRows.length; i++) {
				var rowId = List1.dp.updatedRows[i];
				// 필수값 체크
				if(List1.isNull(rowId, "PROJECT_NAME")) {
					alert("프로젝트명은 필수입력입니다.");
					List1.setFocusGrid(rowId, "PROJECT_NAME");
				}
			}
			
			return confirm("저장하시겠습니까?");	
		} else if(str == "DEL") {
			var rowId = List1.grid.getSelectedId();
			if(rowId == null) { 
				alert("삭제할 행을 선택해주세요."); 
				return false;
			}
			return confirm("삭제하시겠습니까?");
		} else if(str == "ADD") {
			if(List1.isInserted()) {
				alert("프로젝트 저장 후 추가해 주시기 바랍니다.");
				return false;
			}
		} else if(str == "SAVE_AUTH") {
			if(obj.grid.getSelectedId() == null) {
				alert("권한을 변경할 사용자를 먼저 선택해 주시기 바랍니다.");
				return false;
			}
		}
		return true;		
	};
	
	// 저장버튼 클릭시
	var save = function() {
		if(List1.grid.getSelectedId() != null)
			List1.dp.setUpdated(List1.grid.getSelectedId(), true);
		
		if(!checkVal("SAVE")) return;
		submit("SAVE");
	};
	
	// 삭제버튼 클릭시
	var del = function() {
		if(!checkVal("DEL")) return;
		
		for(var row = 0; row<List1.dp.updatedRows.length; row++) {
			var rowId = List1.dp.updatedRows[row];
			List1.dp.setUpdated(rowId,false);
		}
		List1.grid.deleteSelectedItem();
		submit("DEL");
	};
	
	// 저장, 삭제처리
	var submit = function(flag) {
		var strParam = "DATA="+List1.serialize();
		$.ajax({
			url : '/project/save.do',
			data : strParam,
			cache : false,
			success : function(data) {
				alert(data.RESULT_MSG);
				clearData();
				if(data.RESULT_CD == "SUCC_0001") {
					// 저장시 행의 키값 저장
					if(flag == "SAVE") {
						var rowId = List1.grid.getSelectedId();
						var colId = List1.grid.getColIndexById("PROJECT_NAME");
						savePK = List1.grid.cells(rowId,colId).getValue();
					} else {
						// 삭제인 경우 행은 0으로 셋팅
						rowPos = 0;
					}
					searchList();
				}
			} 
		});		
	};
	
	// 추가버튼 클릭시
	var add = function() {
		if(!checkVal("ADD")) return;
		var rowId = List1.grid.getRowsNum()+1;
		List1.grid.addRow(rowId,"",-1);
		List1.grid.cells(rowId, List1.grid.getColIndexById("NO")).setValue(rowId);
		List1.grid.selectRowById(rowId);
		detailList(rowId);
		List1.setFocusGrid(rowId, "PROJECT_NAME");
	};
	
	// 프로젝트 권한 저장
	var saveAuth = function(obj, rowId, val) {
		
		if(!checkVal("SAVE_AUTH", obj)) return;
		
		obj.grid.cells(rowId, obj.grid.getColIndexById("WRITE_YN")).setValue(val);
		
		obj.dp.setUpdated(rowId, true);
		
		var strParam = "DATA="+obj.serialize();
		$.ajax({
			url : '/project/saveAuth.do',
			data : strParam,
			cache : false,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001")
					detailList(List1.grid.getSelectedId());
				else
					alert(data.RESULT_MSG);
			}
		});			
	};

	// 화면 로딩시
	$(document).ready(function(){
		$('#btnSave').bind('click', save);
		$('#btnDel').bind('click', del);
		$('#btnAdd').bind('click', add);
		
		$('#btnAddWrite').on('click', function() {
			saveAuth(List3, List3.grid.getSelectedId(), "1");
		});
		$('#btnDelWrite').on('click', function() {
			saveAuth(List2, List2.grid.getSelectedId(), "X");
		});
		$('#btnAddRead').on('click', function() {
			saveAuth(List3, List3.grid.getSelectedId(), "0");
		});
		$('#btnDelRead').on('click', function() {
			saveAuth(List4, List4.grid.getSelectedId(), "X");
		});
		
		initGrid1();
		initGrid2();
		initGrid3();
		initGrid4();
		
		searchList();
	});
	
})(jQuery);
</script>
	<!-- container -->
    <div id="container"> 
        <!-- contents -->
		<div id="contents">
			<div class="contsMiddle">

				<!-- contents body -->
				<div class="contBody">

					<!-- title/location -->
					<div class="hgroup">
						<h3><img src="/resources/images/common/h3_admin_1.png" alt="프로젝트관리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>관리자 화면</li>
								<li><strong>프로젝트관리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 프로젝트 관리  -->
					<div class="searchResults">
						<div class="leftConts">
							<h4>프로젝트 목록</h4>
							<div id="gridList1" class="mt10" style="background-color:white; width:100%; height:475px;"></div>
							<!-- 버튼 -->
							<div class="btnArea right">
								<a href="#" id="btnAdd" class="btntype1"><span>추가</span></a>
								<a href="#" id="btnSave" class="btntype4"><span>저장</span></a>
								<a href="#" id="btnDel" class="btntype1"><span>삭제</span></a>
							</div>
							<!-- 버튼 -->
						</div>
						<div class="rightConts">
							<h4>편집가능 사용자그룹</h4>
							<div id="gridList2" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
							<div class="btnArea">
								<button type="button" id="btnAddWrite" class="btnSmall green">▲</button>
								<button type="button" id="btnDelWrite" class="btnSmall green">▼</button>
							</div>
							<h4>사용자그룹</h4>
							<div id="gridList3" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
							<div class="btnArea">
								<button type="button" id="btnDelRead" class="btnSmall green">▲</button>
								<button type="button" id="btnAddRead" class="btnSmall green">▼</button>
							</div>
							<h4>편집제한 사용자그룹</h4>
							<div id="gridList4" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
						</div>
					</div>
					<!-- //프로젝트 관리 -->

				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>