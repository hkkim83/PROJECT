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

<link rel="stylesheet" type="text/css" href="/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script src="/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
<script src="/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
<script src="/resources/js/dhtmlxGrid/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script src="/resources/js/dhtmlxGrid/dhtmlxDataProcessor/codebase/dhtmlxdataprocessor.js"></script>

<script type="text/javascript">
<!--
//-->
(function($){
	(function($){
		var List = {};
		var columnList = ["1", "BOARD_ID", "TITLE", "CONTENT", "REPLY", "REG_USER", "REG_USER_NM", "F_REG_DATE", "UPD_USER", "UPD_USER_NM", "F_UPD_DATE"];
		
		// 리스트 조회
		var searchList = function() {
			var strParam = "FLAG=Q";
			$.ajax({
				url : '/board/list.do',
				data : strParam,
				cache : false,
				success : function(data) {
					List.parse(data.LIST  , columnList);
				}
			});		
		};
		
		// 상세팝업 호출
		var openDialog = function(data, status) {
			
			if(status == "INSERT" && !Common.checkLogin()){
				showLoginPop(function(){
					location.reload();
				});
				return;
			}
			
			var $dialog = $('#dlg_qna_rgs');
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

			new dialogWin.BoardDlg(data, fnOkCallback, fnCloseCallback);
			$dialog.find('iframe').css('left', left);
			$dialog.height($(document).height());
			$dialog.show();		
		};
		
		// 선택된 행의 정보 가져오기
		var getRowData = function(obj, rowId, status) {
			var data = new Object();
			data['STATUS'] = status;
			data['WHERE']  = "VIEW";
			for(var col=0; col<obj.grid.getColumnsNum(); col++) {
				data[obj.grid.getColumnId(col)] = status == "INSERT" ? "" : obj.grid.cells(rowId, col).getValue();
			}
			return data;
		};
		
		// 행 선택시
		var onRowSelect = function(rowId, col, status) {
			var data = getRowData(List, rowId, status);

			openDialog(data, status);
		};
		
		// 그리드 초기화
		var initGrid = function() {
			var idx = 0;
			var arr = new Array();
			arr[idx++] = ["NO"			,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
		    arr[idx++] = [""  			,"BOARD_ID"		,"0"	,"left"		,"ro"	,"str"	,"false"];
		    arr[idx++] = ["제목"      	,"TITLE"		,"*"	,"left"		,"ro"	,"str"	,"false"];
		    arr[idx++] = [""  			,"CONTENT"		,"0"	,"left"		,"ro"	,"str"	,"false"];
		    arr[idx++] = [""  			,"REPLY"		,"0"	,"left"		,"ro"	,"str"	,"false"];
		    arr[idx++] = [""  			,"REG_USER"		,"0"	,"left"		,"ro"	,"str"	,"false"];
		    arr[idx++] = ["작성자"		,"REG_USER_NM"	,"100"	,"center"	,"ro"	,"str"	,"false"];
		    arr[idx++] = ["작성일"		,"F_REG_DATE"	,"100"	,"center"	,"ro"	,"str"	,"false"];
		    arr[idx++] = [""  			,"UPD_USER"		,"0"	,"center"	,"ro"	,"str"	,"false"];
		    arr[idx++] = ["답변자"  		,"UPD_USER_NM"	,"100"	,"center"	,"ro"	,"str"	,"false"];
		    arr[idx++] = ["답변일"		,"F_UPD_DATE"	,"100"	,"center"	,"ro"	,"str"	,"false"];
		    
			List = new CommonGrid('gridList', arr);
			List.grid.attachEvent("onRowDblClicked", function(rId,cInd){onRowSelect(rId,cInd, "UPDATE");});
		};
		
		// 화면 로딩시
		$(document).ready(function(){
			$('#btnCreate').bind('click', function() {
				onRowSelect(-1, -1, "INSERT");
			});
			
			initGrid();
			
			// 조회실행
			searchList();
		});
		
	})(jQuery);
	
})(jQuery);
</script>
<div id="dlg_qna_rgs" class="layer_dialog">
  <iframe src="/board/qnaRgsDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
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
						<h3><img src="/resources/images/common/h3_master_2.png" alt="Q&amp;A"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>게시판관리</li>
								<li><strong>Q&amp;A</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 아이디  -->
					<div class="searchResults">
						<div class="master">
							<ul class="masterTab">
								<li><a href="/board/view.do">공지사항</a></li>
								<li><a href="/board/qnaView.do" class="on">Q&amp;A</a></li>
								<li><a href="/board/faqView.do">FAQ</a></li>
							</ul>
							<div id="gridList" class="mt20" style="background-color:white; width:100%; height:400px;"></div>
<% 
	if(user != null) {
%>							
							<div class="btnMore">
								<a href="#" id="btnCreate" class="btntype2"><span>신규</span></a>
							</div>
<% } %>
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