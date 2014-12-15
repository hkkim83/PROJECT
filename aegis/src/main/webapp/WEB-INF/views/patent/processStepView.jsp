<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
.layer_dialog{
	display:none;z-index:50;position:absolute;top:0px;left:0px;width:100%;height:100%;
}
.layer_dialog iframe{
	position:absolute;
	top:50%;
	left:50%;
	text-align:center;
	z-index:10;
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
	
	
	//법적 상태 갱신
	var setLegalStatus = function(natlCode) {
		var strParam = "PROJECT_ID="+projectId+"&NATL_CODE="+natlCode;
		var natlName = natlCode == "KR" ? "한국" : "일본";
		$.ajax({
			url : '/process/setLegalStatus.do',
			data : strParam,
			async : true,
			timeout: 0,
			dataType: 'json',
		    beforeSend: function() {
		    	if(!confirm(natlName+" 법적상태를 갱신하시겠습니까?")) return false;
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,
		    complete: function() {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
	        } , 
			success: function( data ) {
				alert(data.RESULT_MSG);
			}
		});		
	};
		
	// 패밀리 체크
	var setFmSeqNum = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/setFmSeqNum.do',
			data : strParam,
			timeout: 0,
			async : true,
			beforeSend: function() {
		    	if(!confirm("패밀리 필드를 체크하시겠습니까?")) return false;
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,
		    complete: function() {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
	        } , 			
			success: function( data ) {
				alert(data.RESULT_MSG);
			}
		});		
	};

	// 연번 재부여
	var setSeqNum = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/setSeqNum.do',
			data : strParam,
			timeout: 0,
			async : true,
			beforeSend: function() {
		    	if(!confirm("연번을 재부여하시겠습니까?")) return false;
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,
		    complete: function() {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
	        } , 			
			success: function( data ) {
				alert(data.RESULT_MSG);
			}
		});	
	};

	// 중복제거
	var deleteDuplication = function() {
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/process/deleteDuplication.do',
			data : strParam,
			timeout: 0,
			async : true,
			beforeSend: function() {
		    	if(!confirm("중복을 제거하시겠습니까?")) return false;
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,
		    complete: function() {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
	        } , 			
			success: function( data ) {
				alert(data.RESULT_MSG);
			}
		});			
	};
	
	// 파일 다운로드
	var download = function() {
		location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
	};
	
	// 엑셀 파일 만들기
	var saveExcel = function(strParam) {
		$.ajax({
			url : '/omission/saveExcelColName.do',
			data : strParam,
			dataType: 'json',
			success: function( data ) {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
				if(data.RESULT_CD == "SUCC_0001") {
					filePath = data.FILE_PATH;
					fileName = data.FILE_NAME;
					download();
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});		
	};
	
	// 패밀리, Forward, Backward 필드 누락 정리
	var checkFamily = function(colName) {
		var strParam = "PROJECT_ID="+projectId+"&COL_NAME="+colName;
		var comment = colName == "FM_NUM" ? "패밀리" :  colName == "BC_BE_NUM" ? "Backward" : "Forward";
				
		$.ajax({
			url : '/omission/checkFamily.do',
			data : strParam,
			timeout: 0,
			dataType: 'json',
			async : true,
			beforeSend: function() {
		    	if(!confirm(comment+" 누락 DB를 정리하시겠습니까?")) return false;
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,
			success: function( data ) {
				if(data.RESULT_CD == "SUCC_0001") {
					saveExcel(strParam);
				} else {
					alert(data.RESULT_MSG);
			        //통신이 완료된 후 처리
			        $('#dlg_progress_bar').fadeOut();
				}
			}
		});		
	};	
	
	// 화면 로딩시
	$(document).ready(function(){
		$('#btnKorStatus').bind('click', function(event) {
			event.preventDefault();
			setLegalStatus("KR");
		});
		$('#btnJpnStatus').bind('click', function(event) {
			event.preventDefault();
			setLegalStatus("JP");
		});
		$('#btnSeqNum').bind('click'   , function(event) {
			event.preventDefault();
			setSeqNum();
		});
		$('#btnFmSeqNum').bind('click' ,  function(event) {
			event.preventDefault();
			setFmSeqNum();
		});
		$('#btnDeleteDup').bind('click', function(event) {
			event.preventDefault();
			deleteDuplication();
		});
		$('#btnFamily').bind('click'   , function(event) {
			event.preventDefault();
			checkFamily("FM_NUM");
		});
		$('#btnBackward').bind('click' , function(event) {
			event.preventDefault();
			checkFamily("BC_BE_NUM");
		});
		$('#btnForward').bind('click'  , function(event) {
			event.preventDefault();
			checkFamily("FC_FE_NUM");
		});
	});
	
})(jQuery);
</script>
<div id="dlg_progress_bar" class="layer_dialog">
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
						<h3><img src="/resources/images/common/h3_02_5.png" alt="단계별 데이터 처리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터가공</li>
								<li><strong>단계별 데이터 처리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 데이터처리  -->
					<div class="searchResults">
						<p class="dataTxt">특허에 대한 정보 갱신 또는 노이즈 제거를 단계별로 따로 처리할 수 있는 화면입니다.<br />
							원하는 버튼을 클릭하세요. </p>
						
						<div class="daealist">
							<ul>
								<li>
									<a id="btnKorStatus" href="" class="btnData">한국 법적상태 갱신</a>
									<span>한국 특허의 법적 상태를 갱신할 수 있습니다.</span>
								</li>
								<li>
									<a id="btnJpnStatus" href="" class="btnData">일본 법적상태 갱신</a>
									<span>일본 특허의 법적 상태를 갱신할 수 있습니다.</span>
								</li>
								<li>
									<a id="btnFmSeqNum" href="" class="btnData">패밀리 필드 체크</a>
									<span>패밀리 필드 정보를 갱신할 수 있습니다.</span>
								</li>
								<li>
									<a id="btnSeqNum" href="" class="btnData">연번 재부여</a>
									<span>연번을 재부여합니다. (순서 : 국가별(KR>US>JP>EP>CN>WO), 출원일별 오름차순)</span>
								</li>
								<li>
									<a id="btnFamily" href="" class="btnData">패밀리 누락 DB</a>
									<span>패밀리 정보를 추출합니다.</span>
								</li>
								<li>
									<a id="btnBackward" href="" class="btnData">Backward 누락 DB</a>
									<span>인용특허 DB를 추출합니다.</span>
								</li>
								<li>
									<a id="btnForward" href="" class="btnData">Forward 누락 DB</a>
									<span>피인용특허 DB를 추출합니다.</span>
								</li>
							</ul>
						</div>
						
					</div>
					<!-- //데이터처리 -->
					
				</div>
				<!-- //contents body -->

			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->
<div id="viewLoading" class="layer_dialog">
	<p style="text-align:center; padding:16px 0 0 0; left:50%; top:50%; position:absolute;"><img src="/resources/images/common/viewLoading.gif" /></p>
</div>	
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>