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

var SearchFormulaLstDlg = function(fnOkCallback, fnCloseCallback){
	
	var $orgTr = null;
	// 리스트 조회
	var list = function(){
		
		var data = new Object();
		data.TITLE = $('#title').val();
		data.DB_TYPE_CD = $('#db_type_cd').val();
		data.CONTENT = $('#content').val();
		
		var data = '';
		$.ajax({
			  url: '/searchFormula/list.do'
			, data : data
			, type: 'POST'
			, async: false
			, success: function(data){
				
				$.each(data.RESULT, function(i){
					var $tr = $orgTr.clone();
					$tr.find('#NO').text((i+1));
					$tr.find('#TITLE').text(this.TITLE);
					$tr.find('#DB_TYPE').text(this.DB_TYPE);
					$tr.find('#CONTENT').text(this.CONTENT);
					$tr.find('#REG_USER').text(this.REG_USER_NM);
					$tr.find('#REG_DATE').text(this.F_REG_DATE);
					$tr.bind('click', {oSearchFormula:this}, function(event){
						$('#table > tbody > tr').css('background', 'white');
						$(this).css('background', 'orange');
						$('#search_formula_content').val(event.data.oSearchFormula.CONTENT);
					});
					$('#table > tbody').append($tr);
				});
				
			}
		});			
	};
	
	
	// OK버튼 클릭시 선택된 데이터 리턴
	{
		$orgTr = $('#table > tbody > tr').remove();
		$('#btn_ok').bind('click', function(){
			var searchFormulaContent = $('#search_formula_content').val();
			fnOkCallback(searchFormulaContent);
		});
		$('#btn_close').bind('click', fnCloseCallback);
		
		list();
	}
};

// 화면로딩시
(function($){
	$(document).ready(function(){
		$('.popTab.tab a').bind('click', function(event){
			event.preventDefault();
			$('.popTab.tab a').removeClass('on');
			$(this).addClass('on');
			
			var idx = $('.popTab.tab a').index(this);
			$('[id^=selist]').removeClass('active');
			$('[id^=selist]').eq(idx).addClass('active');
		});
		
	});	
	
})(jQuery);
</script>



<!-- layer popup 삽입시작 -->
<div class="layerPopup wid1" id="pop_search1" style="display:block;">
	<!-- header -->
	<div class="pHeader">
		<h2>검색식 불러오기</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents" style="height:190px;">
		<form>
			<fieldset>
				<ul class="popTab tab">
					<li><a href="#" class="on"><span>검색식 목록</span></a></li>
					<li><a href="#">검색식 직접입력</a></li>
				</ul>
				<h3 class="blind">검색식 목록</h3>
				<div id="selist01" class="psearchList inb_con active">
						<div class="tbl_bbs3">
							<table id="table" summary="원본 불러오기,DB 필드정리,DB 중복제거,연번부여,대표명화,패밀리 체크">
							<caption>특허문헌 누락처리 진행창</caption>
							<thead>
							<tr>
							  <th style="width:10%;">번호</th>
							  <th style="width:50%;" >제목</th>
							  <th style="display:none;">DB종류</th>
							  <th style="display:none;">검색식</th>
							  <th style="width:20%;" >작성자</th>
							  <th style="width:20%;" >작성일</th>
							</tr>
							</thead>
							<tbody>
							<tr>
							  <td id="NO" style="text-align:center;">번호</td>
							  <td id="TITLE">제목</td>
							  <td id="DB_TYPE" style="display:none;">DB종류</td>
							  <td id="CONTENT" style="display:none;">검색식</td>
							  <td id="REG_USER" style="text-align:center;">작성자</td>
							  <td id="REG_DATE" style="text-align:center;">작성일</td>
							</tr>
							</tbody>
							</table>
						</div>
				</div>
				
				<h3 class="blind">검색식 직접입력</h3>
				<div id="selist02" class="selist inb_con">
					<textarea id="search_formula_content" title="직접입력"></textarea>
				</div>
				

			</fieldset>
		</form>
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<button id="btn_ok" type="button" class="btnPoGreen">확인</button>
			<button id="btn_close" type="button" class="btnPoGray">닫기</button>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->


<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>