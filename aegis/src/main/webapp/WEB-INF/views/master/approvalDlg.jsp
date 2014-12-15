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
var ApprovalDlg = function(fnOkCallback, fnCloseCallback){
	var $orgTr = null;
	
	// 리스트 조회
	var list = function(){
		$.ajax({
			  url: '/admin/appvList.do'
			, type: 'POST'
			, async: false
			, success: function(data){
				$.each(data.LIST, function(i){
					var $tr = $orgTr.clone();
					$tr.find('#TD_COMPANY').text(this.COMPANY);
					$tr.find('#ID').val(this.ID);
					$tr.find('#TD_ID').text(this.ID);
					$tr.find('#TD_NAME').text(this.NAME);
					$tr.find('#TD_TEL').text(this.TEL);
					$tr.find('#TD_E_MAIL').text(this.E_MAIL);
					$('#table > tbody').append($tr);
				});
			}
		});			
	};
	
	// 데이터 직렬화
	var serialize = function() {
		var array = new Array();
		$('input[name=chk]:checkbox:checked').each(function(index){
			var $td = $(this).parent();
			var data = new Object();
			var $nodes = $td.children();
			$nodes.each(function(){
				if($(this).attr('name') != 'chk') {
					data[$(this).attr('id')] = $(this).val();
				}
			});
			array.push(data);
		});
		return Common.stringify(array);		
	};
	
	// 저장
	var save = function() {
		var chkLen = $('input[name=chk]:checkbox:checked').length;
		if(chkLen < 1) {
			alert("먼저 선택해 주시기 바랍니다.");
			return false;
		}
		var strParam = "DATA=" + serialize();
		
		$.ajax({
			url : "/admin/saveAppv.do",
			data : strParam,
			timeout: 0,
			async : true,		
			success : function(data) {
				alert(data.RESULT_MSG);
				$('#table > tbody > tr').remove();
				fnOkCallback();
			}
		});
	};
	
	$orgTr = $('#table > tbody > tr').remove();
	$('#btnSave').bind('click', save);
	$('#btnClose').bind('click', fnCloseCallback);
	$('#chkAll').bind("change", function() {
		$('input[name=chk]').prop('checked', $('#chkAll').is(":checked"));
	});
	
	list();
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
		<h2>승인요청 확인</h2>
	</div>
	<!-- //header -->

	<!-- contents -->
	<div class="pContents">
		<form>
			<fieldset>
				<h3 class="blind">승인요청 목록</h3>
				<div id="selist01" class="psearchList inb_con active">
						<div class="tbl_bbs3">
							<table id="table">
							<thead>
							<tr>
							  <th style="width:30;"><input type="checkbox" id="chkAll"/></th>
							  <th style="width:90;" >회사</th>
							  <th style="width:70;">ID</th>
							  <th style="width:60;">이름</th>
							  <th style="width:80;">연락처</th>
							  <th style="width:*;" >e-mail</th>
							</tr>
							</thead>
							<tbody>
							<tr>
							  <td><input type="checkbox" name="chk"/><input type="hidden" id="ID"/></td>
							  <td id="TD_COMPANY"></td>
							  <td id="TD_ID">DB종류</td>
							  <td id="TD_NAME">DB종류</td>
							  <td id="TD_TEL">검색식</td>
							  <td id="TD_E_MAIL">작성자</td>
							</tr>
							</tbody>
							</table>
						</div>
				</div>
			</fieldset>
		</form>
		
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<button id="btnSave" type="button" class="btnPoGreen">확인</button>
			<button id="btnClose" type="button" class="btnPoGray">닫기</button>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->

<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>