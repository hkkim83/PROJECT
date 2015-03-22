<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top_popup.jsp" %>

<style>
.file_input_div{
	position:relative; overflow:hidden; padding:15px 0 5px 0
}
.file_input_hidden{ 
	font-size:20px;
	position:absolute;
	width:50px;
	opacity:0; 
	filter:alpha(opacity=0);
	-ms-filter:"alpha(opacity=0)";
	-khtml-opacity:0;
	-moz-opacity:0;
}
.layerPopup.wid1{
	box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-box-sizing:border-box;
	width:100%;
	background-color: white;
}
</style>

<script src="/resources/js/jquery.ui.widget.js"></script>	
<script src="/resources/js/jquery.iframe-transport.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>
<script type="text/javascript">
<!--
//-->

var SummaryDlg = function(projectId, patentId, fnCloseCallback){
	var writeYn   = "<%=user.getProjectAuth()%>";
	
	// 중요특허일 경우 배경색, 중요특구 문구 추가
	var setImportantClass = function(importantYn) {
		if(importantYn == "1") {
			$('#detailTop').addClass('imprt');
			$('.ico_red').show();
		} else {
			$('#detailTop').removeClass('imprt');
			$('.ico_red').hide();
		}
	};
	
	// 데이터 셋팅
	var setDetailData = function(data) {
		$.each(data, function(key, value) {
			if($('#'+key) != undefined && key != "PATENT_FULLTXT") {
				var objectType = $('#'+key)[0]+"";
				if(objectType.indexOf('Select') > -1 || objectType.indexOf('Input') > -1 )
					$('#'+key).val(value);
				else if(objectType.indexOf('Image') > -1)
					$('#'+key).attr("src", value);
				else 
					$('#'+key).text(value);
			}
		});
		
		$('#IMAGE_VIEW').attr("href", "/patent/imageView.do?IMAGE="+data["IMAGE_MAIN"]);
		if(data["PATENT_FULLTXT"] == "/process/error.do")
			$('#PATENT_FULLTXT').attr("href", "javascript:alert('전문이 존재하지 않습니다.');");
		else 
			$('#PATENT_FULLTXT').attr("href", "/patent/pdfView.do?PDF="+data["PATENT_FULLTXT"]);	
		// 중요특허 표시
		setImportantClass(data["IMPORTANT_YN"]);
		
	};
	
	// 리스트 조회
	var searchList = function() {
		var strParam = "PROJECT_ID="+projectId+"&PATENT_ID="+patentId;
		$.ajax({
			url : '/keyPatent/detail.do',
			data : strParam,
			cache : false,
			success : function(data) {
				setDetailData(data.LIST);
			}
		});
	};
	
	// 특허정보 직렬화
	var serializePatent = function() {
		var array = new Array();
		var data = new Object();
		data["STATUS"]    = "UPDATE";

		$(".finderDetail input").each(function(){
			data[$(this).attr("id")] = $(this).val();
		});

		$(".finderDetail select").each(function(){
			data[$(this).attr("id")] = $(this).val();
		});

		$(".finderDetail textarea").each(function(){
			data[$(this).attr("id")] = $(this).val();
		});
		
		array.push(data);
		return Common.stringify(array);
	};
	
	// 특허 수정
	var save = function() {
		
		if(!confirm("수정하시겠습니까?")) return;
		
		var data = serializePatent();
		var strParam = "DATA=" + data;
		
		$.ajax({
			url : "/patent/save.do",
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
				setImportantClass($('#IMPORTANT_YN option:selected').val());
			}
		});
	};
	
	// 파일 다운로드
	var download = function(filePath, fileName) {
		location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
	};
	
	// 다운로드버튼 클릭시 
	var saveExcel = function() {
		var data = serializePatent();
		var strParam = "DATA=" + data;
		
		$.ajax({
			url : "/patent/saveExcelDtl.do",
			data : strParam,
			success : function(data) {
		        //통신이 완료된 후 처리
		        if(data.RESULT_CD == "SUCC_0001") {
		    		download(data.FILE_PATH, data.FILE_NAME);
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 파일정보 보여주기
	var uploadCompleted = function(data) {
		//alert(data.FILE_PATH);
		$('#IMAGE_MAIN').attr("src", data.IMAGE_MAIN);
		$('#IMAGE_VIEW').attr("href", "/patent/imageView.do?IMAGE="+data.IMAGE_MAIN);
	};

	// 파일정보 보여주기
	var uploadPDFCompleted = function(data) {
		$('#btnPDFView').attr("href", "/patent/pdfView.do?PDF="+data.PATENT_FULLTXT).attr("target", "_blank");
	};
	
	$('#btnClose').bind('click', fnCloseCallback);
	// 정보저장
	$("#btnSave").bind("click", save);
	
	// 다운로드
	$('#btnDownload').bind("click", saveExcel);
	
	searchList();
	
	// 사용자권한이 편집제한이면 readonly
	if(writeYn == "0") {
		$(".finderDetail textarea").attr("readonly", true);	
		$(".finderDetail input").attr("readonly", true);	
		$(".finderDetail select").attr("disabled", true);		
		$("#btnSave").hide();
	}
	
	// 도면변경
	$('#file').fileupload({
		url: '/patent/upload.do?PROJECT_ID='+projectId+"&PATENT_ID="+patentId,
		dataType: 'json',
		beforeSend:function() {
			var fileName = $('#fileName').val();
			var index = fileName.lastIndexOf(".");
			var ext = fileName.substring(index+1, fileName.length);
				if(!(ext == "jpg" || ext == "jpeg" || ext == "gif" || ext == "png")) {
				alert("이미지만 업로드 가능합니다.\n(지원포맷 : jpg, jpeg, gif, png)");
				return false;
			}
		},
		success: function( data ) {
			if(data.RESULT_CD == "SUCC_0001") {
				uploadCompleted(data.FILE_INFO);
			} else {
				alert(data.RESULT_MSG);
			}
		}
	});
	
	// 전문변경
	$('#file1').fileupload({
		url: '/patent/uploadPDF.do?PROJECT_ID='+projectId+"&PATENT_ID="+patentId,
		dataType: 'json',
		beforeSend:function() {
			var fileName = $('#fileName1').val();
			var index = fileName.lastIndexOf(".");
			var ext = fileName.substring(index+1, fileName.length);
				if(!(ext == "pdf" || ext == "PDF")) {
				alert("PDF파일만 업로드 가능합니다.");
				return false;
			}
		},
		success: function( data ) {
			if(data.RESULT_CD == "SUCC_0001") {
				uploadPDFCompleted(data.FILE_INFO);
			} else {
				alert(data.RESULT_MSG);
			}
		}
	});	
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
		<h2>요지리스트</h2>
	</div>
	<!-- //header -->

	<!-- container -->
	<!-- contents -->
	<div class="pContents">
		<!-- contents body -->
		<div class="contBody">
			<!-- 검색 결과  -->
				<div class="finderDetail">
					<!-- 리스트 시작 -->
					<div class="top_right_btn">
						<dd class="btn">
							<a href="#" class="btntype3"><span>한글다운</span></a>
							<a href="#" class="btntype3"><span>워드다운</span></a>
							<a href="#" id="btnDownload" class="btntype3"><span>엑셀다운</span></a>
							<a href="#" id="PATENT_FULLTXT" class="btntype6"><span>전문보기</span></a>
							<input type="hidden" id="fileName1" readonly/>
							<input type="file" id="file1" name="file1" class="file_input_hidden" title="파일추가" onchange="javascript:document.getElementById('fileName1').value = this.value" />
							<a id="btnAddPDFFile" href="#" class="btntype4"><span>전문변경</span></a>
						</dd>
					</div>					
					<form>
					<div class="represent">					
						<dl id="detailTop" class="detailTop tye2 ">
							<dt>
								<span id="SEQ_NUM" class="title"></span><span class="title">.&nbsp;</span><span id="TITLE" class="title"></span>
								<span class="ico_red">중요특허</span>
							</dt>
						</dl>
						<div id="greenResult" class="greenRepresent">
							<div class="representLeft">
								<div>
								<a id="IMAGE_VIEW" href="#" target="_blank" ><img id="IMAGE_MAIN" width="258" height="362"></a>
								</div>
								<div>
									<input type="file" id="file" name="file" class="file_input_hidden mt05" title="파일추가" onchange="javascript:document.getElementById('fileName').value = this.value" />
									<a id="btnAddImageFile" href="#" class="btntype5 mt05"><span>도면변경</span></a>
									<input type="hidden" id="fileName"/>
								</div>						
							</div>
							<div class="representRight">
								<div class="tbl_bbs2">
									<table summary="">
									<caption>선택</caption>
									<colgroup>
										<col width="23%" />
										<col width="27%" />
										<col width="23%" />
										<col width="27%" />
									</colgroup>
									<tbody>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;출원국가</h4></th>
										<td id="NATL_CODE"></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;권리구분</h4></th>
										<td id="KINDS_IP_TYPE"></td>
										<th scope="row"><label for="re04"><h4><i class="fa fa-caret-right"></i>&nbsp;중요특허여부</h4></label></th>
										<td>
											<select id="IMPORTANT_YN" class="w50">
												<option value="0">N</option>
												<option value="1">Y</option>
											</select>
										</td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;대표 IPC</h4></th>
										<td id="IPC_ALL" colspan="3"></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;출원번호</h4></th>
										<td id="APPL_NUM"></td>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;출원일자</h4></th>
										<td id="APPL_DATE"></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;공개번호</h4></th>
										<td id="OPEN_NUM"></td>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;공개일자</h4></th>
										<td id="OPEN_DATE"></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;등록번호</h4></th>
										<td id="REGI_NUM"></td>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;등록일자</h4></th>
										<td id="REGI_DATE"></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;출원인</h4></th>
										<td id="APPLICANT_RENAME" colspan="3"></td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;법적상태</h4></th>
										<td id="LEGAL_STATUS" colspan="3"></td>
									</tr>
									<tr>
										<th scope="row"><label for="re04"><h4><i class="fa fa-caret-right"></i>&nbsp;목적등급</h4></label></th>
										<td>
											<select id="GRADE_OBJ" class="w50">
												<option value="">미분류</option>
												<option value="S">S</option>
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="C">C</option>
											</select>
										</td>
										<th scope="row"><label for="re05"><h4><i class="fa fa-caret-right"></i>&nbsp;해결수단등급</h4></label></th>
										<td>
											<select id="GRADE_CONST" class="w50">
												<option value="">미분류</option>
												<option value="S">S</option>
												<option value="A">A</option>
												<option value="B">B</option>
												<option value="C">C</option>
											</select>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="re06"><h4><i class="fa fa-caret-right"></i>&nbsp;검토자</h4></label></th>
										<td><input type="text" id="REVIEWER" value="" class="w50"/></td>
										<th scope="row"><label for="re07"><h4><i class="fa fa-caret-right"></i>&nbsp;검토결과</h4></label></th>
										<td>
											<select id="REVIEW_FLAG" class="w50">
												<option value="0">미검토</option>
												<option value="1">검토중</option>
												<option value="2">검토완료</option>
											</select>												
										</td>
									</tr>
									<tr>
										<th scope="row"><h4><i class="fa fa-caret-right"></i>&nbsp;Family 정보</h4></th>
										<td id="FM_NUM" colspan="3"></td>
									</tr>
									</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<div class="greenRepresent">		
						<dl class="txtInfoLom">
							<dt><h4><i class="fa fa-caret-right"></i>&nbsp;목적/해결수단요약</h4></dt>
							<dd>
								<textarea id="KEYWORD_LIST" class="w96 h1"></textarea><input id="PROJECT_ID" type="hidden" value=""/><input id="PATENT_ID" type="hidden" value=""/>
							</dd>
						</dl>
					    <div class="txtInfoC">
							<p>주) 목적 및 해결수단을 입력하세요(최대 6개).   복수개의 목적, 해결수단 입력시, 구분자를 사용하세요.   입력 예 :  고강성/안정성</p>
						</div>
						<dl class="txtInfoLom">
							<dt><h4><i class="fa fa-caret-right"></i>&nbsp;발명의 요약</h4></dt>
							<dd>
								<textarea id="ABSTRACT" class="w96 h2"></textarea>
							</dd>
							<dt><h4><i class="fa fa-caret-right"></i>&nbsp;대표청구항</h4></dt>
							<dd>
								<textarea id="CLAIM_MAIN" class="w96 h2"></textarea>
							</dd>
							<dt><h4><i class="fa fa-caret-right"></i>&nbsp;검토의견1</h4></dt>
							<dd>
								<textarea id="CMT_LAW_FIRMS" class="w96 h1"></textarea>
							</dd>
							<dt><h4><i class="fa fa-caret-right"></i>&nbsp;검토의견2</h4></dt>
							<dd>
								<textarea id="CMT_CO" class="w96 h1"></textarea>
							</dd>
						</dl>
					</div>
					</form>
				</div>
			<!-- //검색결과 -->				
		</div>
		<!-- //contents body -->
	</div>
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<button type="button" id="btnSave" class="btnPoGreen">저장</button>
			<button type="button" id="btnClose" class="btnPoGray">닫기</button>
		</div>
	</div>
	<!-- //footer -->
</div>	
<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>