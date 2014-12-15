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

<script type="text/javascript">
var FindDlg = function(id, fnOkCallback, fnCloseCallback){
	
	var checkVal = function() {
		if($('#PASSWORD').val() == "") {
			alert("비밀번호를 입력해주세요.");	
			$('#PASSWORD').focus();
			return false;
		}
		
		if($('#PASSWORD').val() != $('#RE_PASSWORD').val()) {
			alert("비밀번호가 일치하지 않습니다.  다시 확인해 주시기 바랍니다.");
			$('#PASSWORD').focus();
			return false;
		}
		
		return confirm('비밀번호를 재설정 하시겠습니까?');
	};
	
	var save = function(){
		if(!checkVal()) return;
		
		var data = new Object();
		data.ID = id;
		data.PASSWORD = $('#PASSWORD').val();

		var strParam = 'DATA=' + Common.stringify(data);
		$.ajax({
			  url: '/setPassword.do'
			, data : strParam
			, type: 'POST'
			, async: false
			, success: function(data){
				alert(data.RESULT_MSG);
				fnOkCallback();
			}
		});			
	};
	
	
	{
		$('#btn_save').bind('click', save);
		$('#btn_close').bind('click', fnCloseCallback);
		$('#PASSWORD').focus();
	}
};



(function($){
	$(document).ready(function(){
	});	
	
})(jQuery);
</script>

<!-- layer popup 삽입시작 -->
<div class="layerPopup wid1" id="pop_search1" style="display:block;">
	<input id="db_type_cd" type="hidden">
	<input id="content" type="hidden">
	<!-- header -->
	<div class="pHeader">
		<h2>비밀번호 재설정하기</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<form>
			<fieldset>
				<div class="tbl_bbs4">
					<table summary="관리자PW,PW확인">
					<caption>관리자PW변경</caption>
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>
					<tbody>
					<tr>
						<th><label for="PASSWORD">관리자 PW</label></th>
						<td><input type="password" id="PASSWORD" class="w70" /></td>
					</tr>
					<tr>
						<th><label for="RE_PASSWORD">PW 확인</label></th>
						<td><input type="password" id="RE_PASSWORD" class="w70" /></td>
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
			<button id="btn_save" type="button" class="btnPoGreen">저장</button>
			<button id="btn_close" type="button" class="btnPoGray">닫기</button>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->


<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>