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
.psechForm dd span.percent0{
	height:23px;display:inline-block;width:0%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent1{
	height:23px;display:inline-block;width:16%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent2{
	height:23px;display:inline-block;width:33%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent3{
	height:23px;display:inline-block;width:50%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent4{
	height:23px;display:inline-block;width:66%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent5{
	height:23px;display:inline-block;width:83%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent6{
	height:23px;display:inline-block;width:100%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
</style>

<script>

var ProgressDlg = function(fnCloseCallback){

};

var changePercent = function(level) {
	var persent = parseInt(level == 6 ? 100 : level*16.6);
	$('.psechForm dd span').removeClass();
	$('.psechForm dd span').addClass("percent"+level);
	$('.psechForm dd em').text(persent);
	$('table td:eq('+(level-1)+')').text("완료");
	$('table td:eq('+level+')').text("진행중");
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
		<h2>검색식 DB반영 진행</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<div class="tbl_bbs2">
			<table summary="검색식 불러오기,DB 중복제거,서지정보 가져오기,연번부여,대표명화,패밀리 체크">
			<caption>검색식 DB반영 진행창</caption>
			<colgroup>
				<col width="80%"/>
				<col width="20%" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row">STEP 1:  검색식 불러오기</th>
				<td>진행중</td>
			</tr>
			<tr>
				<th scope="row">STEP 2:  DB 필드정리</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 3:  서지정보 가져오기</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 4:  연번부여</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 5:  대표명화</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 6:  패밀리 체크</th>
				<td>대기</td>
			</tr>
			</tbody>
			</table>
		</div>
		<dl class="psechForm mt10">
			<dt>진행중</dt>
			<dd><span class="percent0"><em>0%</em></span></dd>
		</dl>
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<!-- 
	<div class="pFooter">
		<div class="pbtn">
			<button id="btn_close" type="button" class="btnPoGray">닫기</button>
		</div>
	</div>
	 -->
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->


<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>