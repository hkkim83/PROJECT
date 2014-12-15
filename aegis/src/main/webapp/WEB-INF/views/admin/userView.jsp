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
		arr[idx++] = ["NO"		,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
		arr[idx++] = ["아이디"    ,"ID"			,"150"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["이름" 		,"NAME"			,"150"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["소속" 		,"COMPANY"		,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 		,"PASSWORD"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 		,"CHECK_ID"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    
		List1 = new CommonGrid('gridList1', arr);
		List1.grid.attachEvent("onRowSelect", function(rId,cInd){
			detailList(rId);
		});
	};
	
	// 그리드 초기화
	var initGrid2 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
	    arr[idx++] = ["" 			,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["프로젝트명" 		,"PROJECT_NAME"	,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"ID"			,"0"	,"left"		,"ro"	,"str"	,"false"];
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
	    arr[idx++] = ["프로젝트명" 		,"PROJECT_NAME"	,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"ID"			,"0"	,"left"		,"ro"	,"str"	,"false"];
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
	    arr[idx++] = ["프로젝트명" 		,"PROJECT_NAME"	,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"ID"			,"0"	,"left"		,"ro"	,"str"	,"false"];
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
		List1.grid.clearAll();
		$('input').val("");
		
		var strParam = "";
		$.ajax({
			url : '/user/list.do',
			data : strParam,
			cache : false,
			success : function(data) {
				List1.parse(data.LIST);
				// 저장한 값이 있으면 행을 찾아준다.
				if(savePK != "") {
					var colId = List1.grid.getColIndexById("ID");
					rowPos = List1.findRow(colId, savePK);
					savePK = "";
				}				
				List1.grid.selectRow(rowPos);
				var rowId = List1.grid.getRowId(rowPos);

				// 등록된 사용자가 없을경우 자동으로 row생성
				if(rowId == undefined)
					add();
				else
					detailList(rowId);
			}
		});		
	};
	
	// 상세조회
	var detailList = function(rowId) {
		List1.bindData(rowId);
		List2.grid.clearAll();
		List3.grid.clearAll();
		List4.grid.clearAll();
		if(List1.dp.getState(rowId) == "inserted") {
			$('#ID').attr("readonly", false);
		} else {
			$('#ID').attr("readonly", true);
			var id = List1.grid.cells(rowId, List1.grid.getColIndexById("ID")).getValue();
			var strParam = "ID="+id;
			$.ajax({
				url : '/user/detail.do',
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
	
	// 필수 입력 체크
	var isNullCheck = function(rowId, colIdList) {
		for(var i=0; i<colIdList.length; i++) {
			if(List1.isNull(rowId, colIdList[i])) {
				var colName = $('label[for*='+colIdList[i]+']').text();
				alert(colName.replace("*","")+"은 필수입력입니다.");
				List1.setFocusSelector(rowId, colIdList[i]);
				return false;
			}
		}
		return true;
	};
	
	// 정합성 체크
	var checkVal = function(str, obj) {
		if(str == "SAVE") {
			if(!List1.isUpdated()) {
				alert("저장할 데이터가 존재하지 않습니다.\n다시 확인해보시기 바랍니다.");
				return false;
			}
			
			var colIdList = ["ID", "NAME", "PASSWORD"];
			for(var i=0; i<List1.dp.updatedRows.length; i++) {
				var rowId = List1.dp.updatedRows[i];
				// 필수값 체크
				if(!isNullCheck(rowId, colIdList)) return false;
				
				var status = List1.dp.getState(rowId);

				if(status == "inserted" && List1.grid.cells(rowId, List1.grid.getColIndexById("CHECK_ID")).getValue() == "F") {
					alert("아이디 중복체크를 해주시기 바랍니다.");
					List1.setFocusSelector(rowId, "ID");
					return false;
				}
				
				if(status == "inserted" && (List1.grid.cells(rowId, List1.grid.getColIndexById("ID")).getValue()).length < 4) {
					alert("아이디는 4자리 이상 입력하기 바랍니다.");
					List1.setFocusSelector(rowId, "ID");
					return false;
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
				alert("사용자 저장 후 추가해 주시기 바랍니다.");
				return false;
			}
		} else if(str == "SAVE_AUTH") {
			if(obj.grid.getSelectedId() == null) {
				alert("권한을 변경할 프로젝트를 먼저 선택해 주시기 바랍니다.");
				return false;
			}
		} else if(str == "DUP_CHECK") {
			if($('#ID').val() == "") {
				alert("ID를 먼저 입력해주세요.");
				return false;
			}
		}
		return true;		
	};
	
	// 저장버튼 클릭시
	var save = function() {
		if(!checkVal("SAVE")) return
		submit("SAVE");
	};
	
	// 삭제버튼 클릭시
	var del = function() {
		if(!checkVal("DEL")) return;
		
		// 수정된 데이터를 수정 안된 상태로 변경
		// 선택된 데이터만 삭제하기 위해서
		for(var row = 0; row<List1.dp.updatedRows.length; row++) {
			var rowId = List1.dp.updatedRows[row];
			List1.dp.setUpdated(rowId,false);
		}
		List1.grid.deleteSelectedItem();
		submit("DEL");
	};
	
	// 저장,삭제 처리
	var submit = function(flag) {
		var strParam = "DATA="+List1.serialize();
		$.ajax({
			url : '/user/save.do',
			data : strParam,
			cache : false,
			success : function(data) {
				alert(data.RESULT_MSG);
				clearData();
				if(data.RESULT_CD == "SUCC_0001") {
					if(flag == "SAVE") {
						var rowId = List1.grid.getSelectedId();
						var colId = List1.grid.getColIndexById("ID");
						savePK = List1.grid.cells(rowId,colId).getValue();
					} else {
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
		$('#ID').attr("readonly", false);
		$('#ID').focus();
	};
	
	// 프로젝트 권한 저장
	var saveAuth = function(obj, rowId, val) {
		
		if(!checkVal("SAVE_AUTH", obj)) return;
		
		obj.grid.cells(rowId, obj.grid.getColIndexById("WRITE_YN")).setValue(val);
		
		obj.dp.setUpdated(rowId, true);
		
		var strParam = "DATA="+obj.serialize();
		$.ajax({
			url : '/user/saveAuth.do',
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

	// 중복체크 버튼 클릭시
	var dupCheck = function() {
		var strParam = "TYPE=ID&ID="+$('#ID').val();
		if($('#ID').attr("readonly") == "readonly") return;
		if(($('#ID').val()).length < 4) {
			alert("아이디는 4자리 이상 입력하기 바랍니다.");
			$('#ID').focus();
			return;
		}
		
		$.ajax({
			url: '/admin/dupCheck.do',
			data : strParam,
			type: 'POST',
			beforeSubmit : function() {
				checkVal("DUP_CHECK");
			},
			success: function(data){
				if(data.RESULT_CD == "SUCC_0001") {
					var rowId = List1.grid.getSelectedId();
					if(data.CHECK_MAP.DUP_CHECK == "F") {
						alert("사용하실 수 있는 아이디 입니다.");
						List1.grid.cells(rowId, List1.grid.getColIndexById("CHECK_ID")).setValue("T");
						$('#NAME').focus();
					} else {
						alert("이미 등록된 아이디가 있습니다.");
						List1.grid.cells(rowId, List1.grid.getColIndexById("CHECK_ID")).setValue("F");
						$('#ID').focus();
					}
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});			
	};

	// 아이디 값 입력시 중복체크여부 변경
	var onKeyUp = function(obj) {
		var colid = obj.attr("id");
		if(colid == "ID") {
			var rowId = List1.grid.getSelectedId();
			List1.grid.cells(rowId, List1.grid.getColIndexById("CHECK_ID")).setValue("F");
		}
		List1.setData(colid);
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		$('#btnSave').bind('click', save);
		$('#btnDel').bind('click', del);
		$('#btnAdd').bind('click', add);
		$('#btnDupCheck').bind('click', dupCheck);
		
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
		
		$('input').bind('keyup', function() {
			onKeyUp($(this));
		});
		
		$(document).on("keyup", "input:text[alphaOnly]", function() {$(this).val( $(this).val().replace(/[^0-9a-zA-Z]/gi,"") );});
		
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
						<h3><img src="/resources/images/common/h3_admin_2.png" alt="사용자관리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>관리자 화면</li>
								<li><strong>사용자관리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 사용자관리 -->
					<div class="searchResults">
						<div class="leftConts">
							<h4>사용자 목록</h4>
							<div id="gridList1" class="mt10" style="background-color:white; width:100%; height:310px;"></div>
							<form name="" method="post">
								<fieldset>
								<div class="tbl_bbs6">
									<table summary="아이디,비밀번호,이름,소속" style="width:100%;">
									<caption>회사 목록</caption>
									<colgroup>
										<col width="30%" />
										<col width="70%" />
									</colgroup>
									<tbody>
									<tr>
										<th scope="row"><label for="ID">*아이디</label></th>
										<td>
											<input type="text" id="ID" class="w70" alphaOnly=true/>
											<button type="button" id="btnDupCheck" class="btnSmall gray">중복체크</button>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="NAME">*이름</label></th>
										<td><input type="text" id="NAME" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="PASSWORD">*비밀번호</label></th>
										<td><input type="password" id="PASSWORD" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="COMPANY">소속</label></th>
										<td><input type="text" id="COMPANY" class="w90" /></td>
									</tr>
									</tbody>
									</table>
								</div>
								</fieldset>
							</form>
							<!-- 버튼 -->
							<div class="btnArea">
								<a href="#" id="btnAdd" class="btntype1"><span>추가</span></a>
								<a href="#" id="btnSave" class="btntype1"><span>저장</span></a>
								<a href="#" id="btnDel" class="btntype1"><span>삭제</span></a>
							</div>
							<!-- 버튼 -->
						</div>
						<div class="rightConts">
							<h4>편집가능 프로젝트그룹</h4>
							<div id="gridList2" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
							<div class="btnArea">
								<button type="button" id="btnAddWrite" class="btnSmall green">▲</button>
								<button type="button" id="btnDelWrite" class="btnSmall green">▼</button>
							</div>
							<h4>프로젝트그룹</h4>
							<div id="gridList3" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
							<div class="btnArea">
								<button type="button" id="btnDelRead" class="btnSmall green">▲</button>
								<button type="button" id="btnAddRead" class="btnSmall green">▼</button>
							</div>
							<h4>편집제한 프로젝트그룹</h4>
							<div id="gridList4" class="mt10" style="background-color:white; width:100%; height:120px;"></div>
						</div>
					</div>
					<!-- //사용자관리 -->

				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->
	
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>