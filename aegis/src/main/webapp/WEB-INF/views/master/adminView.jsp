<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
.layer_dialog{
	display:none;z-index:50;position:absolute;top:0px;left:0px;width:100%;height:100%;background-color:rgba(0, 0, 0, 0.6);
}
.layer_dialog iframe{
	position:absolute;
	top:200px;
	width:500px;
	height:500px;
	z-index:10;
	border:none;
}
</style>

<script type="text/javascript">
<!--
//-->
(function($){
	var isCheckID = false;
	var List   = {};
	var rowPos = 0;
	var savePK = "";
	// 그리드 초기화
	var initGrid = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = [""			,"NO"			,"30"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"PASSWORD"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"RE_PASSWORD"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""      		,"OLD_PASSWORD"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["회사명"  		,"COMPANY"		,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["아이디"  		,"ID"			,"80"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["관리자이름" 		,"NAME"			,"100"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""  			,"BIZ_NO1"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""  			,"BIZ_NO2"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""  			,"BIZ_NO3"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = [""			,"E_MAIL"		,"0"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""			,"TEL_1"		,"0"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""  			,"TEL_2"		,"0"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""  			,"TEL_3"		,"0"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""			,"POINT"		,"0"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = [""			,"ADD_POINT"	,"0"	,"center"	,"ro"	,"str"	,"false"];
	    
		List = new CommonGrid('gridList', arr);
		List.grid.attachEvent("onRowSelect", function(rId,cInd){onRowSelect(rId);});
		// 조회실행
		searchList();
	};

	// 저장 데이터셋 초기화
	var clearData = function() {
		List.dp.updatedRows=[];
		List.dp._in_progress={};			
	};
	
	// 리스트 조회
	var searchList = function() {
		List.grid.clearAll();		
		var strParam = "";
		$.ajax({
			url : '/admin/list.do',
			data : strParam,
			cache : false,
			success : function(data) {
				List.parse(data.LIST);
				// 저장한 값이 있으면 행을 찾아준다.
				if(savePK != "") {
					var colId = List.grid.getColIndexById("ID");
					rowPos = List.findRow(colId, savePK);
					savePK = "";
				}
				List.grid.selectRow(rowPos);
				var rowId = List.grid.getRowId(rowPos);
				// 등록된 고객이 없을경우 자동으로 row생성
				if(rowId == undefined)
					add();
				else
					onRowSelect(List.grid.getRowId(rowPos));
			}
		});		
	};
	
	// 필수 입력 체크
	var isNullCheck = function(rowId, colIdList) {
		for(var i=0; i<colIdList.length; i++) {
			if(List.isNull(rowId, colIdList[i])) {
				var colName = $('label[for*='+colIdList[i]+']').text();
				alert(colName.replace("*","")+"은 필수입력입니다.");
				List.setFocusSelector(rowId, colIdList[i]);
				return false;
			}
		}
		return true;
	};
	
	// 정합성 체크
	var checkVal = function(str) {
		if(str == "DUP_CHECK") {
			if($('#ID').val() == "") {
				alert("ID를 먼저 입력해주세요.");
				return false;
			}
		} else if(str == "SAVE") {
			if(List.dp.updatedRows.length < 1) {
				alert("저장할 데이터가 존재하지 않습니다. 다시 확인해보시기 바랍니다.");
				return false;
			}
			
			var colIdList = ["COMPANY", "BIZ_NO1", "BIZ_NO2", "BIZ_NO3", "ID", "NAME", "PASSWORD"];
			for(var i=0; i<List.dp.updatedRows.length; i++) {
				var rowId = List.dp.updatedRows[i];
				// 필수값 체크
				if(!isNullCheck(rowId, colIdList)) return false;
				
				var status = List.grid.getUserData(rowId,"!nativeeditor_status");
				if(status == "inserted") {
					if((List.grid.cells(rowId, List.grid.getColIndexById("ID")).getValue()).length < 4) {
						alert("아이디는 4자리 이상 입력하기 바랍니다.");
						List.setFocusSelector(rowId, "ID");
						return false;
					}
					
					if(!isCheckID) {
						alert("아이디 중복체크를 해주시기 바랍니다.");
						List.setFocusSelector(rowId, "ID");
						return false;
					}				
				}

				if(List.grid.cells(rowId, List.grid.getColIndexById("PASSWORD")).getValue() != List.grid.cells(rowId, List.grid.getColIndexById("RE_PASSWORD")).getValue()) {
					alert("비밀번호가 일치하지 않습니다.  다시 확인해 주시기 바랍니다.");
					List.setFocusSelector(rowId, "PASSWORD");
					return false;
				}	
			}
			
			return confirm("저장하시겠습니까?");	
		} else if(str == "DEL") {
			var rowId = List.grid.getSelectedId();
			if(rowId == null) { 
				alert("삭제할 행을 선택해주세요."); 
				return false;
			}
			return confirm("삭제하시겠습니까?");
		}
		return true;
	};
	
	// 저장버튼 클릭시
	var save = function() {
		if(!checkVal("SAVE")) return;
		submit("SAVE");
	};
	
	// 삭제버튼 클릭시
	var del = function() {
		if(!checkVal("DEL")) return;
		
		// 수정된 데이터를 수정 안된 상태로 변경
		// 선택된 데이터만 삭제하기 위해서
		for(var row = 0; row<List.dp.updatedRows.length; row++) {
			var rowId = List.dp.updatedRows[row];
			List.dp.setUpdated(rowId,false);
		}
		List.grid.deleteSelectedItem();
		submit("SAVE");
	};
	
	// 저장, 삭제 처리
	var submit = function(flag) {
		var strParam = "DATA="+List.serialize();
		$.ajax({
			url : '/admin/save.do',
			data : strParam,
			cache : false,
			
			success : function(data) {
				alert(data.RESULT_MSG);
				clearData();
				if(data.RESULT_CD == "SUCC_0001") {
					// 저장시 행의 키값 저장
					if(flag == "SAVE") {
						var rowId = List.grid.getSelectedId();
						var colId = List.grid.getColIndexById("ID");
						savePK = List.grid.cells(rowId,colId).getValue();
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
		var rowId = List.grid.getRowsNum()+1;
		List.grid.addRow(rowId,"",-1);
		List.grid.cells(rowId, List.grid.getColIndexById("NO")).setValue(rowId);
		List.grid.cells(rowId, List.grid.getColIndexById("POINT")).setValue(0);
		List.grid.selectRowById(rowId);
		onRowSelect(rowId);
		$('#ID').attr("readonly", false);
		$('#COMPANY').focus();
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
					if(data.CHECK_MAP.DUP_CHECK == "F") {
						alert("사용하실 수 있는 아이디 입니다.");
						isCheckID = true;
						$('#NAME').focus();
					} else {
						alert("이미 등록된 아이디가 있습니다.");
						isCheckID = false;
						$('#ID').focus();
					}
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});			
	};
	
	// 포인트 추가 버튼 클릭시
	var addPoint = function(obj) {
		var oldPoint = 0;
		if(obj.val() != 0) 
			oldPoint = $('#ADD_POINT').val();
		
		$('#ADD_POINT').val(parseInt(oldPoint == "" ? 0 : oldPoint)+parseInt(obj.val()));		
		List.setData('ADD_POINT');
	};
	
	// 아이디 값 입력시 중복체크여부 변경
	var onKeyUp = function(obj) {
		var colid = obj.attr("id");
		if(colid == "ID") {
			isCheckID = false;
		}
		List.setData(colid);
	};
	
	// 그리스 선택시 
	var onRowSelect = function(rowId) {
		List.bindData(rowId);
		$('#ID').attr("readonly", true);
	};
	
	// 승인요청 버튼 클릭시
	var openDialog = function() {
		
		var $dialog = $('#dlg_approval');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		
		var fnOkCallback = function() {
			$dialog.hide();
			dialogWin.location.reload();
			// 조회실행
			searchList();
		};

		new dialogWin.ApprovalDlg(fnOkCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();		
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		$('#btnSave').bind('click', save);
		$('#btnDel').bind('click', del);
		$('#btnAdd').bind('click', add);
		$('#btnAppl').bind('click', openDialog);
		$('#btnDupCheck').bind('click', dupCheck);
		$('button[name=btnPoint]').bind('click', function() {
			addPoint($(this));
		});
		
		$('input').bind('keyup', function() {
			onKeyUp($(this));
		});
		
		$(document).on("keyup", "input:text[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );});
		$(document).on("keyup", "input:text[alphaOnly]", function() {$(this).val( $(this).val().replace(/[^0-9a-zA-Z]/gi,"") );});
		
		initGrid();
	});
	
	
})(jQuery);
</script>
<div id="dlg_approval" class="layer_dialog">
  <iframe src="/admin/approvalDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
	<!-- container -->
    <div id="container"> 
        <!-- contents -->
		<div id="contents">
			<div class="contsMiddle">

				<!-- contents body -->
				<div class="contBody">

					<!-- title/location -->
					<div class="hgroup">
						<h3><img src="/resources/images/common/h3_master_0.png" alt="고객관리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li><strong>고객관리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					<!-- 아이디  -->
					<div class="searchResults">
						<div class="leftConts">
							<h4>회사 목록</h4>
							<div id="gridList" class="mt10" style="background-color:white; width:100%; height:495px;"></div>
							<!-- 버튼 -->
							<div class="btnArea right">
								<a href="#" id="btnAppl" class="btntype4"><span>승인요청</span></a>
								<a href="#" id="btnAdd" class="btntype1"><span>추가</span></a>
								<a href="#" id="btnSave" class="btntype4"><span>저장</span></a>
								<a href="#" id="btnDel" class="btntype1"><span>삭제</span></a>
							</div>
							<!-- 버튼 -->							
						</div>
						<div class="rightConts">
							<h4>상세 정보</h4>
							<form name="" method="post">
								<fieldset>
								<div class="tbl_bbs6">
									<table summary="">
									<caption>회사 목록</caption>
									<colgroup>
										<col width="30%" />
										<col width="70%" />
									</colgroup>
									<tbody>
									<tr>
										<th scope="row"><label for="COMPANY">*회사명</label></th>
										<td><input type="text" id="COMPANY" class="w90"/></td>
									</tr>
									<tr>
										<th scope="row"><label for="BIZ_NO1BIZ_NO2BIZ_NO3">*사업자등록번호</label></th>
										<td>
											<input type="text" id="BIZ_NO1" class="w15" maxlength="3" numberOnly=true/> -
											<input type="text" id="BIZ_NO2" class="w10" maxlength="2" numberOnly=true/> -
											<input type="text" id="BIZ_NO3" class="w20" maxlength="5" numberOnly=true/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="ID">*관리자 ID</label></th>
										<td>
											<input type="text" id="ID" class="w65" alphaOnly=true/>
											<button type="button" id="btnDupCheck" class="btnSmall gray">중복체크</button>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="NAME">*관리자 이름</label></th>
										<td><input type="text" id="NAME" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="PASSWORD">*관리자 PWD</label></th>
										<td><input type="password" id="PASSWORD" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="RE_PASSWORD">PWD 확인</label></th>
										<td><input type="password" id="RE_PASSWORD" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="E_MAIL">E-mail</label></th>
										<td><input type="text" id="E_MAIL" class="w90" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="TEL_1TEL_2TEL_3">전화번호</label></th>
										<td>
											<input type="text" id="TEL_1" class="w15" maxlength="3" numberOnly=true/> -
											<input type="text" id="TEL_2" class="w15" maxlength="4" numberOnly=true/> -
											<input type="text" id="TEL_3" class="w15" maxlength="4" numberOnly=true/>
										</td>
									</tr>
									
									</tbody>
									</table>
								</div>
								<h4 class="mt15">포인트 관리</h4>
								<div class="idpBox">
									<ul>
										<li>
											<label for="POINT">잔여포인트</label>
											<input type="text" id="POINT" class="w60" readonly style="text-align: right;"/>
										</li>
										<li>
											<label for="ADD_POINT">포인트추가</label>
											<input type="text" id="ADD_POINT" class="w60" style="text-align: right;" numberOnly=true/>
										</li>
										<li>
											<span class="mdl125">
												<button type="button" name="btnPoint" value="1000000" class="btnSmall green">100만</button>
												<button type="button" name="btnPoint" value="500000" class="btnSmall green">50만</button>
												<button type="button" name="btnPoint" value="100000" class="btnSmall green">10만</button>
												<button type="button" name="btnPoint" value="50000" class="btnSmall green">5만</button>
												<button type="button" name="btnPoint" value="0" class="btnSmall green">정정</button>
											</span>
										</li>
									</ul>
								</div>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- //아이디/비밀번호 재설정 -->
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>