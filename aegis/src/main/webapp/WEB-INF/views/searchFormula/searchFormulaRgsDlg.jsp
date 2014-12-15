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
var SearchFormulaRgsDlg = function(data, fnOkCallback, fnCloseCallback){
	// 저장
	var save = function(){
		
		if(!confirm('저장하시겠습니까?')){
			return;
		}
		
		var data = new Object();
		data.TITLE = $('#title').val();
		data.DB_TYPE_CD = $('#db_type_cd').val();
		data.CONTENT = $('#content').val();

		var data = 'DATA=' + Common.stringify(data);
		$.ajax({
			  url: '/searchFormula/save.do'
			, data : data
			, type: 'POST'
			, async: false
			, success: function(data){
				alert('처리되었습니다.');
				fnOkCallback();
			}
		});			
	};
	
	
	{
		$('#db_type_cd').val(data.DB_TYPE_CD);
		$('#content').val(data.CONTENT);
		
		$('#btn_save').bind('click', save);
		$('#btn_close').bind('click', fnCloseCallback);
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
		<h2>검색식 신규저장하기</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<form>
			<table style="width:100%;margin-top:6px;">
			  <tr>
			    <td style="background: #f2f2f2;font-weight: bold;text-align: center;">제목</td>
			    <td style="padding:0px 12px 0px 6px;"><input id="title" type="text" style="width:100%;"></td>
			  </tr>
			</table>
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