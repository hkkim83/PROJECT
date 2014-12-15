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
	height:23px;display:inline-block;width:25%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent2{
	height:23px;display:inline-block;width:50%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent3{
	height:23px;display:inline-block;width:75%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
.psechForm dd span.percent4{
	height:23px;display:inline-block;width:100%;background:#f64911;line-height:23px;color:#fff; vertical-align:top;
}
</style>

<script>

var changePercent = function(level) {
	$('.psechForm dd span').removeClass();
	$('.psechForm dd span').addClass("percent"+level);
	$('.psechForm dd em').text(level*25);
	$('table td:eq('+(level-1)+')').text("완료");
	$('table td:eq('+level+')').text("진행중");
};

var ProgressDlg = function(fnCloseCallback){

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
		<h2>특허문헌 누락처리 진행</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<div class="tbl_bbs2">
			<table summary="패밀리,Backward Citation,Forward Citation,중복제거,데이터 추출">
			<caption>특허문헌 누락처리 진행창</caption>
			<colgroup>
				<col width="80%"/>
				<col width="20%" />
			</colgroup>
			<tbody>
			<tr>
				<th scope="row">STEP 1:  패밀리 필드 Parsing</th>
				<td>진행중</td>
			</tr>
			<tr>
				<th scope="row">STEP 2:  Backward Citation 필드 Parsing</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 3:  Forward Citation 필드 Parsing</th>
				<td>대기</td>
			</tr>
			<tr>
				<th scope="row">STEP 4:  데이터 추출</th>
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
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->


<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>