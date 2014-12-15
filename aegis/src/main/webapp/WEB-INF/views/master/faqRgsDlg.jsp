<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top_popup.jsp" %>

<style>
.layerPopup.wid1{
	box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-box-sizing:border-box;
	width:100%;
	background-color: white;
}
</style>

<% 
	String priority = user != null ? user.getPriority() : "";
%>

<script type="text/javascript">

var BoardDlg = function(data, fnOkCallback, fnCloseCallback){
	var priority   = "<%=priority%>";	// 사용자권한
	var status     = data.STATUS;
	// 저장
	var save = function() {
		if(!confirm('저장하시겠습니까?')){
			return;
		}
		data.FLAG    = "F";
		data.TITLE   = $('#title').val();
		data.CONTENT = $('#content').val();
		data.REPLY   = $('#reply').val();
		
		var strParam = "DATA="+Common.stringify(data);
		$.ajax({
			  url: '/board/save2.do'
			, data : strParam
			, type: 'POST'
			, async: false
			, success: function(data){
				alert(data.RESULT_MSG);
				fnOkCallback();
			}
		});	
	};
	
	// 삭제
	var del = function() {
		if(!confirm('삭제하시겠습니까?')){
			return;
		}
		
		data.STATUS  = "DELETE";
		
		var strParam = "DATA="+Common.stringify(data);
		$.ajax({
			  url: '/board/save2.do'
			, data : strParam
			, type: 'POST'
			, async: false
			, success: function(data){
				alert(data.RESULT_MSG);
				fnOkCallback();
			}
		});	
	};
	
	
	$('.pHeader h2').text(status == "INSERT" ? "FAQ 신규" : "FAQ 상세조회");
	$('#title').val(data.TITLE);
	$('#content').val(data.CONTENT);
	$('#reply').val(data.REPLY);
	$('#btnSave').bind('click', save);
	$('#btnDel').bind('click', del);
	$('#btnClose').bind('click', fnCloseCallback);
	
	if(priority != "M" || data['WHERE'] == "INDEX") {
		$('input, textarea').attr("readonly", true);
		$('#btnSave').hide();
		$('#btnDel').hide();
	}
};


(function($){
	$(document).ready(function(){
	});	
	
})(jQuery);
</script>

<!-- layer popup 삽입시작 -->
<div class="layerPopup wid1" id="pop_search1" style="display:block;">
	<!-- header -->
	<div class="pHeader">
		<h2>FAQ</h2>
	</div>
	<!-- //header -->
 
	<!-- contents -->
	<div class="pContents">
		<form>
			<fieldset>
				<div class="tbl_bbs4">
					<table summary="제목,질문,답변">
					<caption>FAQ</caption>
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><label for="title">제목</label></th>
						<td><input type="text" id="title" class="w95" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="content">질문</label></th>
						<td>
							<textarea class="w95" id="content"></textarea>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="reply">답변</label></th>
						<td><textarea class="w95" id="reply"></textarea></td>
					</tr>
					</tbody>
					</table>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<button type="button" id="btnSave" class="btnPoGreen">저장</button>
			<button type="button" id="btnDel" class="btnPoOrang">삭제</button>
			<a href="#" id="btnClose" class="btnPoGray">닫기</a>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->

<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>