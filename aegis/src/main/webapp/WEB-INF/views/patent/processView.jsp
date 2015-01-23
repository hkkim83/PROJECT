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
.file_input_div{
	position:relative; overflow:hidden; padding:15px 0 5px 0
}
.file_input_hidden{ 
	font-size:20px;
	position:absolute;
	width:70px;
	opacity:0; 
	filter:alpha(opacity=0);
	-ms-filter:"alpha(opacity=0)";
	-khtml-opacity:0;
	-moz-opacity:0;
}

</style>

<script src="/resources/js/jquery.ui.widget.js"></script>	
<script src="/resources/js/jquery.iframe-transport.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>
<script type="text/javascript">
<!--
//-->
(function($){
	
	var projectId = $('#loginProjectList option:selected').val();
	var $baseInfo = null;
	
	// 파일삭제버튼 클릭시
	var deleteFile = function(obj, filePath){
		var strParam = 'filePath='+Common.replace(filePath);
		// DIV 를 화면에서 사라지게 한다.
		$.ajax({
			url: '/process/deleteFile.do',
			data: strParam,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					obj.remove();
				}else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 파일정보 노드를 추가
	var appendRow = function(filePath) {
		var $fileInfo = $baseInfo.clone();
		$('a[title=btn_delete]', $fileInfo).bind('click', function(event){
			event.preventDefault();
			if(!confirm('삭제하시겠습니까?')){
				return;
			}
			deleteFile($fileInfo, filePath);
		});
		$('#fileList').append($fileInfo);
		return $fileInfo;
	};

	// 파일정보 보여주기
	var uploadCompleted = function(data) {
		$fileInfo = appendRow(data.FILE_PATH);
		var name = data.FILE_NAME;
		var size = parseInt(data.FILE_SIZE/1000);
		$fileInfo.find('span').text(name+" ["+size+"KB]");
		$fileInfo.find('input[name=filePath]').val(data.FILE_PATH);
	};
	
	// 포인트 가져오기
	var getPoint = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		var ret = false;
		$.ajax({
			url: '/process/getPoint.do',
			data: strParam,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					if(parseInt(data.USER.POINT) < parseInt(data.USER.COUNT)) {
						alert("포인트가 부족합니다. 충전 후 사용하세요.\n[문의전화 : 070-8891-6347(직통), 02-562-1716(대표전화)] ");
						ret = false;
					} else {
						ret = confirm("차감 예상 포인트 : "+data.USER.COUNT+"p 입니다.\n업로드를 진행하시겠습니까?");
					}
				}else {
					alert(data.RESULT_MSG);
					ret = false;
				}
			}
		});
		return ret;
	};
	

	// 팝업창 UI변경하기 
	var setPercent = function(level) {
		var $dialog = $('#dlg_process_progress_bar');
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		dialogWin.changePercent(level);
	};
	
	// 패밀리 체크
	var setFmSeqNum = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/setFmSeqNum.do',
			data : strParam,
			timeout: 0,
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(6);	
					alert("포인트 "+point+"p가 차감되었습니다.");
					location.href = "/process/view.do";
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();	
			        $('#dlg_progress_bar').fadeOut();
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// 대표명화
	var setApplicantRename = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/setApplicantRename.do',
			data : strParam,
			timeout: 0,
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(5);				
					setFmSeqNum();		
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// 연번부여
	var setSeqNum = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/setSeqNum.do',
			data : strParam,
			timeout: 0,
			async: false,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(4);				
					setApplicantRename();		
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});	
	};
	

	// 서지정보 가져오기
	var getKiprisData = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/getKiprisData.do',
			data : strParam,
			dataType: 'json',
			timeout: 0,
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					point = data.POINT;
					setPercent(3);				
					setSeqNum();		
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// DB 중복제거
	var deleteDuplication = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/deleteDuplication.do',
			data : strParam,
			timeout: 0,
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(2);					
					getKiprisData();			
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});			
	};

	// DB 필드정리
	var processing = function() {
		$.ajax({
			url : '/process/processing.do',
			dataType: 'json',
			timeout: 0,
			async: true,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(2);				
					deleteDuplication();		
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};

	// 원본 불러오기
	var register = function() {
		$.ajax({
			url : '/process/register.do',
			dataType: 'json',
			timeout: 0,
			async: true,
		    beforeSend: function() {
		    	//통신을 시작할때 처리
		    	var $dialog = $('#dlg_process_progress_bar');
		    	var left = ($('body').width()-$dialog.find('iframe').width())/2;
				$dialog.find('iframe').css('left', left);
				$dialog.height($(document).height());
				$dialog.show().fadeIn('fast'); 
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,			
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					setPercent(1);
					deleteDuplication();
					//processing();	
				} else {
			        //통신이 완료된 후 처리
			        $('#dlg_process_progress_bar').fadeOut();
			        $('#dlg_progress_bar').fadeOut();
					alert(data.RESULT_MSG);
				}
			}
		});		
	};
	
	// 일괄등록 버튼 클릭시
	var batch = function(){

		var nodes = $('#fileList').children();	
		if(nodes.length < 1) {
			alert("업로드한 파일이 존재하지 않습니다.");
		} else {
			
			// 포인트 조회하기
			if(!getPoint()) return;

			register();
		}
	};
	
	// 비정상적인 종료일 경우 파일리스트 조회해서 화면에 뿌려준다
	var getFileList = function() {
		$.ajax({
			url: '/process/getFileList.do',
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					if(data.FILE_COUNT > 0) {
						$.each(data.FILE_LIST, function(index) {
							uploadCompleted(data.FILE_LIST[index]);
						});
						alert("화면이 비정상적으로 종료되었습니다.\n기존에 업로드된 정보가 화면에 표시됩니다.");
					}
				}else {
					alert(data.RESULT_MSG);
				}
			}
		});		
	};
	
	// 파일 업로드
	var upload = function() {
		var formData = new FormData();
		formData.append("file", $('#file')[0].files[0]);
		$.ajax({
			url : '/process/upload.do?type=' + $('#db_type').val() + '&name=' + $('#db_type option:selected').text(),
			data : formData,
			processData : false,
			contentType : false,
			beforeSend : function() {
				var fileName = $('#fileName').val();
				var index = fileName.lastIndexOf(".");
				var ext = fileName.substring(index + 1, fileName.length);
				if (!(ext == "xls" || ext == "xlsx" || ext == "xlsm")) {
					alert("엑셀파일만 업로드 가능합니다.");
					return false;
				}
			},
			success : function(data) {
				if (data.RESULT_CD == "SUCC_0001") {
					uploadCompleted(data.FILE_INFO);
					$('#db_type option:eq(0)').attr("selected", "selected");
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};

	$(document).ready(function() {

		$baseInfo = $('li[title=fileInfo]').remove();

		$('#btn_batch').bind('click', function(event) {
			event.preventDefault();
			batch();
		});

		getFileList();

		Common.setCommonCodeCombo('01', $('#db_type'), "선택");
		
		$('#file').bind('click', function() {
			if($('#db_type').val() == null || $('#db_type').val() == "") {
				alert("먼저 업로드할 DB종류를 선택하세요");
				$('#db_type').focus();
				return false;
			}
		});
		
		$('#file').bind('change', upload);
	});
})(jQuery);
</script>
<div id="dlg_process_progress_bar" class="layer_dialog">
  <iframe src="/process/progressDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
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
						<h3><img src="/resources/images/common/h3_02_1.png" alt="일괄자동등록"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터가공</li>
								<li><strong>일괄자동등록</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<p class="infomation">프로젝트에 등록할 특허를 업로드하는 화면입니다. <br />업로드할 파일을 선택한 후 일괄 등록 버튼을 누르면 자동 등록이 진행됩니다.</p>
					<form>
						<fieldset>
						<div class="btnArea2 right">
							<a id="btn_batch" href="#" class="btntype4"><span>일괄 등록</span></a>
						</div>
						<div class="searchexpression">
							<input type="hidden" id="fileName" readonly/>
							<div class="btnArea right file_input_div">
								<table align="right">
									<tr>
									<td>
										<select id="db_type" style="margin-bottom:16px; height:22px;"></select>
										<input type="file" id="file" name="file" class="file_input_hidden" title="파일추가" onchange="javascript:document.getElementById('fileName').value = this.value" />
										<a id="addFile" href="#" class="btntype3"><span>파일추가</span></a>
									</td>
									</tr>
								</table>
							</div>
							<div id="divBox" class="expressionBox">
								<ul id="fileList" class="expressionList">
									<li title="fileInfo">
										<label>파일정보&nbsp;<a title="btn_delete" style="color:red;" href="#">[X]</a></label>
										<span></span>
										<input type="hidden" name="filePath" readonly/>
									</li>
								</ul>
							</div>
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