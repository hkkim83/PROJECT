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

.layer_dialog2{
	display:none;z-index:50;position:absolute;top:0px;left:0px;width:100%;height:100%;
}
.layer_dialog2 iframe{
	position:absolute;
	top:35%;
	left:50%;
	text-align:center;
	z-index:11;
	border:none;
}
</style>

<script type="text/javascript">
<!--
//-->
(function($){

	var projectId = $('#loginProjectList option:selected').val();
	var filePath = "";
	var fileName = "";
	var download = function() {
		location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
	};
	
	var saveExcel = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/omission/saveExcel.do',
			data : strParam,
			dataType: 'json',
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					filePath = data.FILE_PATH;
					fileName = data.FILE_NAME;
					setPercent(4);
			        //통신이 완료된 후 처리
			        $('#dlg_omission_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					download();
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_omission_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};
	
	// Backward 필드 누락 정리
	var checkBackward = function() {
		var strParam = "PROJECT_ID="+projectId+"&COL_NAME=BC_BE_NUM";
		$.ajax({
			url : '/omission/checkFamily.do',
			data : strParam,
			dataType: 'json',
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(3);
					saveExcel();
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_omission_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// Forward 필드 누락 정리
	var checkForward = function() {
		var strParam = "PROJECT_ID="+projectId+"&COL_NAME=FC_FE_NUM";
		$.ajax({
			url : '/omission/checkFamily.do',
			data : strParam,
			dataType: 'json',
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(2);
					checkBackward();
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_omission_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// 패밀리 필드 누락 정리
	var checkFamily = function() {
		var strParam = "PROJECT_ID="+projectId+"&COL_NAME=FM_NUM";
		$.ajax({
			url : '/omission/checkFamily.do',
			data : strParam,
			dataType: 'json',
			async: true,
		    beforeSend: function() {
		    	//통신을 시작할때 처리
		    	var $dialog = $('#dlg_omission_progress_bar');
		    	var left = ($('body').width()-$dialog.find('iframe').width())/2;
				$dialog.find('iframe').css('left', left);
				$dialog.height($(document).height());
				$dialog.show().fadeIn('fast'); 
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,	
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(1);
					checkForward();
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_omission_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};	
	
	// 팝업창 UI변경하기 
	var setPercent = function(level) {
		var $dialog = $('#dlg_omission_progress_bar');
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		dialogWin.changePercent(level);
	};
	
	
	// 특허문헌 누락처리
	var batch = function() {
		if(!confirm("특허문헌 누락처리를 진행하시겠습니까?")) return;
		checkFamily();
	};
	
	$(document).ready(function(){

		$('#btn_batch').bind('click', function(event){
			event.preventDefault();
			batch();
		});
		
	});
	
})(jQuery);
</script>
<div id="dlg_omission_progress_bar" class="layer_dialog">
  <iframe src="/omission/progressDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>	
<div id="dlg_progress_bar" class="layer_dialog2">
  <iframe src="/process/progressDlg2.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
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
						<h3><img src="/resources/images/common/h3_02_3.png" alt="특허문헌 누락처리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터가공</li>
								<li><strong>특허문헌 누락처리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<p class="infomation">누락된 특허문헌에 대해 일괄처리하는 화면입니다.<br />
						패밀리 필드, Forward, Backward를 한 번에 처리할 수 있습니다.</p>
					<form>
						<fieldset>
						<div class="btnArea2 right">
							<a id="btn_batch" href="#" class="btntype1"><span>특허문헌 누락 처리</span></a>
						</div>
						<div class="searchexpression">
							
						</div>
						</fieldset>
					</form>
					<!-- //검색결과 -->
					
				</div>
				<!-- //contents body -->

			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->


<%@ include file="/WEB-INF/views/common/bottom.jsp" %>