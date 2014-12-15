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

<script>
(function($){
	$(document).ready(function(){
	});	
})(jQuery);
</script>

<!-- layer popup 삽입시작 -->
<div class="layerPopup wid1" id="pop_search1" style="display:block;">
	<img src="/resources/images/common/viewLoading.gif" />
</div>
<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>
<!-- //layer popup 삽입 끝 -->