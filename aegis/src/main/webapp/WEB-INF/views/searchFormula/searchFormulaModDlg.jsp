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
var SearchFormulaModDlg = function(fnCloseCallback){
	
	var $orgTr = null;
	
	var g_oSearchFormula = null;
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
				g_oSearchFormula = null;
				$('#title').val('');
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
						g_oSearchFormula = event.data.oSearchFormula;
						$('#title').val(g_oSearchFormula.TITLE);
					});
					$('#table > tbody').append($tr);
				});
				
			}
		});			
	};
	
	// 저장
	var modify = function(){
		
		if(g_oSearchFormula == null){
			alert('목록을 선택하세요.');
			return;
		}
		if(!confirm('저장하시겠습니까?')){
			return;
		}
		g_oSearchFormula.TITLE = $('#title').val();
		var data = 'DATA=' + Common.stringify(g_oSearchFormula);
		$.ajax({
			  url: '/searchFormula/modify.do'
			, data : data
			, type: 'POST'
			, async: false
			, success: function(data){
				alert('처리되었습니다.');
				$('#table > tbody > tr').remove();
				list();
			}
		});			
	};
	
	// 삭제
	var remove = function(){
		
		if(g_oSearchFormula == null){
			alert('목록을 선택하세요.');
			return;
		}
		if(!confirm('삭제하시겠습니까?')){
			return;
		}
		
		var data = 'DATA=' + Common.stringify(g_oSearchFormula);
		$.ajax({
			  url: '/searchFormula/remove.do'
			, data : data
			, type: 'POST'
			, async: false
			, success: function(data){
				alert('처리되었습니다.');
				$('#table > tbody > tr').remove();
				list();
			}
		});			
	};
	
	
	{
		$orgTr = $('#table > tbody > tr').remove();
		$('#btn_modify').bind('click', modify);
		$('#btn_remove').bind('click', remove);
		$('#btn_close').bind('click', fnCloseCallback);
		
		list();
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
		<h2>검색식 수정하기</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<form>
			<fieldset>
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
			</fieldset>
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
			<button id="btn_modify" type="button" class="btnPoGreen">확인</button>
			<button id="btn_remove" type="button" class="btnPoGray">삭제</button>
			<button id="btn_close" type="button" class="btnPoGray">닫기</button>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->


<!-- 
<div id="div_title">
	<span class="title_txt01">검색식 저장</span>
</div>
<div>
<table id="table" border="1">
  <thead>
	<tr>
	  <td>번호</td>
	  <td>제목</td>
	  <td style="display:none;">DB종류</td>
	  <td style="display:none;">검색식</td>
	  <td>작성일</td>
	  <td>작성자</td>
	</tr>
  </thead>
  <tbody>
	<tr>
	  <td id="NO">번호</td>
	  <td id="TITLE">제목</td>
	  <td id="DB_TYPE" style="display:none;">DB종류</td>
	  <td id="CONTENT" style="display:none;">검색식</td>
	  <td id="REG_USER">작성자</td>
	  <td id="REG_DATE">작성일</td>
	</tr>
  </tbody>
</table>
</div>
<div>
<table>
  <tr>
    <td>제목</td>
    <td><input id="title" type="text"></td>
  </tr>
</table>
</div>
<div>
	<button id="btn_modify">저장</button>
	<button id="btn_remove">삭제</button>
	<button id="btn_close">닫기</button>
</div>
 -->
 
 
<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>