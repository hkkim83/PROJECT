<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
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
<script type="text/javascript" src="/resources/js/smartFinder.js" ></script>
<script type="text/javascript">
<!--
//-->
(function($){
	var numPerPage  = '<c:out value="${PARAM.NUM_PER_PAGE}"/>';
	var pageNo      = '<c:out value="${PARAM.PAGE_NO}"/>';
	var writeYn     = '<c:out value="${PARAM.WRITE_YN}"/>';
	
	// 조회조건 직렬화
	var serialize = function(str) {
		var data = "NUM_PER_PAGE="+numPerPage;
		if(str == "T") data += "&PAGE_NO="+pageNo;
		$("input[id^=KEYWORD], select[id^=KEYWORD]").each(function(){
			if($(this).val() != "") {
				data += "&"+$(this).attr("id")+"="+$(this).val();
			}
		});
		return data;
	};
	
	// 검색버튼 클릭시
	var search = function() {
		var data = serialize("F");
		location.href = "/patent/summaryView.do?"+data;
	};
	
	// 상단 버튼 클릭시
	var searchCnt = function(flag) {
		var data = "NUM_PER_PAGE="+numPerPage;
		if(flag == "1")
			data += "&IMPORTANT_YN=1";
		else if(flag == "2")
			data += "&REVIEW_FLAG=0";
		else if(flag == "3")
			data += "&REVIEW_FLAG=2";
		else if(flag == "4")
			data += "&DEL_YN=1";
			
		location.href = "/patent/summaryView.do?"+data;
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
		$('#IMAGE_MAIN_A').attr("href", "/patent/imageView.do?IMAGE="+data.IMAGE_MAIN);
	};
	
	// 파일정보 보여주기
	var uploadPDFCompleted = function(data) {
		$('#btnPDFView').attr("href", "/patent/pdfView.do?PDF="+data.PATENT_FULLTXT).attr("target", "_blank");
	};
	
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
	
	$(document).ready(function(){
		// 검색버튼
		$("#btnItemizedSearch").bind("click", search);
		
		// 전체검색
		$("#btnAbleCnt").bind("click", function() {
			searchCnt("0");
		});
		
		// 중요특허
		$("#btnImptCnt").bind("click", function() {
			searchCnt("1");
		});
		
		// 미검토
		$("#btnIncmplCnt").bind("click", function() {
			searchCnt("2");
		});
		
		// 검토완료
		$("#btnCmplCnt").bind("click", function() {
			searchCnt("3");
		});

		// 삭제건수
		$("#btnDelCnt").bind("click", function() {
			searchCnt("4");
		});
		
		// 중요특허2(하단)
		$("#btnImportCnt").bind("click", function() {
			searchCnt("1");
		});
		
		// 정보저정
		$("#btnSave").bind("click", save);
		
		// 다운로드
		$('#btnDownload').bind("click", function() {
			if('<c:out value = "${PATENT.SEQ_NUM}"/>' == null || '<c:out value = "${PATENT.SEQ_NUM}"/>' == '')
				alert("다운로드 할 대상이 존재하지 않습니다.");
			else
				saveExcel();
				
		});
		
		// 특허검색창에서 엔터키입력시 자동조회되도록 이벤트 설정
		$(":text", $("#divSmartFinder")).keydown(function(event){
			if(event.keyCode == 13) 
				search();
		});
		
		// 콤보값 셋팅하기
		$('#GRADE_OBJ').val('<c:out value="${PATENT.GRADE_OBJ}"/>');
		$('#GRADE_CONST').val('<c:out value="${PATENT.GRADE_CONST}"/>');
		$('#REVIEW_FLAG').val('<c:out value="${PATENT.REVIEW_FLAG}"/>');
		$('#IMPORTANT_YN').val('<c:out value="${PATENT.IMPORTANT_YN}"/>');
		
		// 중요특허일 경우 색상 변경
		setImportantClass('<c:out value="${PATENT.IMPORTANT_YN}"/>');
		
		// 사용자권한이 편집제한이면 readonly
		if(writeYn == "0") {
			$(".finderDetail textarea").attr("readonly", true);	
			$(".finderDetail input").attr("readonly", true);	
			$(".finderDetail select").attr("disabled", true);			
		}
		
		// 도면변경
		$('#file').fileupload({
			url: '/patent/upload.do?PROJECT_ID='+$('#loginProjectList option:selected').val()+'&PATENT_ID=${PATENT.PATENT_ID}',
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
			url: '/patent/uploadPDF.do?PROJECT_ID='+$('#loginProjectList option:selected').val()+'&PATENT_ID=${PATENT.PATENT_ID}',
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
				
	});
})(jQuery);

</script>
	<!-- container -->
    <div id="container"> 
        <!-- contents -->
		<div id="contents">
			<div class="contsMiddle">

				<!-- contents body -->
				<div class="contBody">
					<!-- 검색시작 -->
					<%@ include file="/WEB-INF/views/analysis/smartFinder.jsp" %>
					<!-- //검색 끝 -->
					
					<!-- title/location -->
					<div class="hgroup finder">
						<h3><img src="/resources/images/common/h3_03_1_3.png" alt="요지리스트"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터분석</li>
								<li><strong>특허검색</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<div class="searchResults">
						<div class="expression">
							<p class="left w67"><strong>입력검색식 :</strong><span>${PARAM.INPUT_STRING}</span></p>
							<p class="right">
								<button type="button" id="btnImportCnt" class="btnSmall write">중요특허</button>
								<span>총 <c:out value="${TOTAL.PA_IMPORTANT_CNT}"/>건</span>
								<span>(아래 리스트의  <img src="/resources/images/common/ico_ferretout.gif" alt="" /> 색출)</span>
							</p>
						</div>
						<!-- 검색 상세리스트 -->
						<c:choose>
						<c:when test="${! empty PATENT}"> 
						<div class="finderDetail">
							<dl class="detailTop">
								<dt>
									<a href="/patent/view.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.LIST_PAGE_NO}" class="btntype1"><span>기본리스트</span></a>
									<a href="/patent/abstractView.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.LIST_PAGE_NO}" class="btntype1"><span>초록/대표도</span></a>
									<a href="#" id="btnDownload" class="btntype1"><span>다운로드</span></a>
								</dt>
								<dd class="btn">
									<c:if test="${PARAM.WRITE_YN == 1}">
									<a href="#" id="btnSave" class="btntype1"><span>정보수정</span></a>
									</c:if>
									<c:if test="${PATENT.PATENT_FULLTXT == '/process/error.do'}">
										<a id="btnPDFView" href="javascript:alert('전문이 존재하지 않습니다.');" class="btntype1"><span>전문보기</span></a>
									</c:if>
									<c:if test="${PATENT.PATENT_FULLTXT != '/process/error.do'}">
										<a id="btnPDFView" href="/patent/pdfView.do?PDF=${PATENT.PATENT_FULLTXT}" target="_blank" class="btntype1"><span>전문보기</span></a>
									</c:if>
									<input type="hidden" id="fileName1" readonly/>
									<input type="file" id="file1" name="file1" class="file_input_hidden" title="파일추가" onchange="javascript:document.getElementById('fileName1').value = this.value" />
									<a id="btnAddPDFFile" href="#" class="btntype2"><span>전문변경</span></a>
								</dd>
							</dl>						
							<!-- 리스트 시작 -->
							<form>
							<div class="represent">
								<dl id="detailTop" class="detailTop tye2 ">
									<dt>
										<strong>
										<span id="SEQ_NUM" class="title">${PATENT.SEQ_NUM}</span><span class="title">.&nbsp;</span><span id="TITLE" class="title">${PATENT.TITLE}</span>
										</strong>
										<span class="ico_red">중요특허</span>
									</dt>
								</dl>
								<div id="greenResult" class="greenRepresent">
									<div class="representLeft file_input_div">
										<a id="IMAGE_MAIN_A" href="/patent/imageView.do?IMAGE=${PATENT.IMAGE_MAIN}" target="_blank" ><img id="IMAGE_MAIN" src="${PATENT.IMAGE_MAIN}" alt=""></a>
										<div class="mt08 mdl190">
											<input type="hidden" id="fileName" readonly/>
											<input type="file" id="file" name="file" class="file_input_hidden" title="파일추가" onchange="javascript:document.getElementById('fileName').value = this.value" />
											<a id="btnAddFile" href="#" class="btntype2"><span>도면변경</span></a>
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
												<th scope="row"><em>출원국가</em></th>
												<td id="NATL_CODE" colspan="3">${PATENT.NATL_CODE}</td>
											</tr>
											<tr>
												<th scope="row"><em>권리구분</em></th>
												<td id="KINDS_IP_TYPE">${PATENT.KINDS_IP_TYPE}</td>
												<th scope="row"><label for="re04">중요특허여부</label></th>
												<td>
													<select id="IMPORTANT_YN" class="w50">
														<option value="0">N</option>
														<option value="1">Y</option>
													</select>
												</td>
											</tr>
											<tr>
												<th scope="row"><em>대표 IPC</em></th>
												<td id="IPC_ALL" colspan="3">${PATENT.IPC_ALL}</td>
											</tr>
											<tr>
												<th scope="row"><em>출원번호</em></th>
												<td id="APPL_NUM">${PATENT.APPL_NUM}</td>
												<th scope="row"><em>출원일자</em></th>
												<td id="APPL_DATE">${PATENT.APPL_DATE}</td>
											</tr>
											<tr>
												<th scope="row"><em>공개번호</em></th>
												<td id="LAID_PUBLIC_NUM">${PATENT.LAID_PUBLIC_NUM}</td>
												<th scope="row"><em>공개일자</em></th>
												<td id="LAID_PUBLIC_DATE">${PATENT.LAID_PUBLIC_DATE}</td>
											</tr>
											<tr>
												<th scope="row"><em>등록번호</em></th>
												<td id="REGI_NUM">${PATENT.REGI_NUM}</td>
												<th scope="row"><em>등록일자</em></th>
												<td id="REGI_DATE">${PATENT.REGI_DATE}</td>
											</tr>
											<tr>
												<th scope="row"><em>출원인</em></th>
												<td id="APPLICANT_RENAME" colspan="3">${PATENT.APPLICANT_RENAME}</td>
											</tr>
											<tr>
												<th scope="row"><label for="re01"><em>법적상태</em></label></th>
												<td id="LEGAL_STATUS" colspan="3">${PATENT.LEGAL_STATUS }</td>
											</tr>
											<tr>
												<th scope="row"><label for="re04">목적등급</label></th>
												<td>
													<select id="GRADE_OBJ" class="w50">
														<option value="">미분류</option>
														<option value="S">S</option>
														<option value="A">A</option>
														<option value="B">B</option>
														<option value="C">C</option>
													</select>
												</td>
												<th scope="row"><label for="re05">해결수단등급</label></th>
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
												<th scope="row"><label for="re06">검토자</label></th>
												<td><input type="text" id="REVIEWER" value="${PATENT.REVIEWER}" class="w50"/></td>
												<th scope="row"><label for="re07">검토결과</label></th>
												<td>
													<select id="REVIEW_FLAG" class="w50">
														<option value="0">미검토</option>
														<option value="1">검토중</option>
														<option value="2">검토완료</option>
													</select>												
												</td>
											</tr>
											<tr>
												<th scope="row"><em>Family 정보</em></th>
												<td id="FM_NUM" colspan="3">${PATENT.FM_NUM}</td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="tbl_bbs2">
										<table summary="">
										<caption>선택</caption>
										<colgroup>
											<col width="100%" />
										</colgroup>
										<tbody>
										<tr>								
											<th scope="row"><label for="re02">목적/해결수단 키워드</label></th>
										</tr>
										<tr>
											<td><textarea id="KEYWORD_LIST" class="w96 h1">${PATENT.KEYWORD_LIST}</textarea><input id="PROJECT_ID" type="hidden" value="${PATENT.PROJECT_ID}"/><input id="PATENT_ID" type="hidden" value="${PATENT.PATENT_ID}"/></td>
										</tr>
										<tr>
											<td class="textInfoC"><p>주) 목적 및 해결수단을 입력하세요(최대 6개).   복수개의 목적/해결수단 입력시, 구분자(,)를 사용하세요.   ( 입력 예 : 고강성,안정성 )</p></td>
										</tr>
										<tr>
											<th scope="row"><label for="re02">발명의 요약</label></th>
										</tr>
										<tr>
											<td colspan="3"><textarea id="ABSTRACT" class="w96 h3">${PATENT.ABSTRACT}</textarea></td>
										</tr>
										<tr>
											<th scope="row"><label for="re02">대표청구항</label></th>
										</tr>
										<tr>
											<td colspan="3"><textarea id="CLAIM_MAIN" class="w96 h3">${PATENT.CLAIM_MAIN}</textarea></td>
										</tr>
										<tr>
											<th scope="row"><label for="re02">검토의견1</label></th>
										</tr>
										<tr>
											<td colspan="3"><textarea id="CMT_LAW_FIRMS" class="w96 h2">${PATENT.CMT_LAW_FIRMS}</textarea></td>
										</tr>
										<tr>
											<th scope="row"><label for="re02">검토의견2</label></th>
										</tr>
										<tr>
											<td colspan="3"><textarea id="CMT_CO" class="w96 h2">${PATENT.CMT_CO}</textarea></td>
										</tr>
										</tbody>
										</table>
									</div>
								</div>
							</div>
							</form>
						</div>
						</c:when>
						<c:otherwise>
						<div class="finderDetail">
							<dl class="detailTop">
								<dt>
									<a href="/patent/view.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.LIST_PAGE_NO}" class="btntype1"><span>기본리스트</span></a>
									<a href="/patent/abstractView.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.LIST_PAGE_NO}" class="btntype1"><span>초록/대표도</span></a>
									<a href="#" id="btnDownload" class="btntype1"><span>다운로드</span></a>
								</dt>
								<dd class="btn">
									<a href="javascript:alert('전문이 존재하지 않습니다.');" class="btntype1"><span>전문보기</span></a>
								</dd>
							</dl>
						</div>						
						<div class="detailList">
							<table>
								<tr>
									<td colspan="10">검색된 결과가 없습니다.</td>
								</tr>	
							</table>
						</div>
						</c:otherwise>
						</c:choose>
						<!-- //검색 상세리스트 -->
						<!-- paging center --> 
						<div id="paging" class="paging"> 
							${PAGING_INFO}         
						</div> 
						<!--// paging --> 
					</div>
					<!-- //검색결과 -->
					
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->
	
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>