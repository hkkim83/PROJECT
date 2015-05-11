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

<script type="text/javascript" src="/resources/js/smartFinder.js" ></script>
<script type="text/javascript">
<!--
//-->
(function($){
	var pageNo = '<c:out value="${PARAM.PAGE_NO}"/>';
	
	// 조회조건 직렬화
	var serialize = function(str) {
		var data = "NUM_PER_PAGE="+$('#numPerPage option:selected').val();
		if(str == "T") data += "&PAGE_NO="+pageNo;
		// KEYWORD로 시작하는 셀렉터
		$("input[id^=KEYWORD], select[id^=KEYWORD]").each(function(){
			if($(this).val() != "") {
				data += "&"+$(this).attr("id")+"="+$(this).val();
			}
		});
		return data;
	};

	// 리스트 조회
	var search = function() {
		var data = serialize("F");
		location.href = "/patent/view.do?"+data;
	};

	// 상단 버튼 클릭시
	var searchCnt = function(flag) {
		var data = "NUM_PER_PAGE="+$('#numPerPage option:selected').val();
		if(flag == "1")
			data += "&IMPORTANT_YN=1";
		else if(flag == "2")
			data += "&REVIEW_FLAG=0";
		else if(flag == "3")
			data += "&REVIEW_FLAG=2";
		else if(flag == "4")
			data += "&DEL_YN=1";
			
		location.href = "/patent/view.do?"+data;
	};

	// 정합성 체크
	var checkValue = function(flag) {
		
		if(flag == "0" || flag =="1" || flag == "2" || flag == "4") {
			var chkLen = $('input[name=chk]:checkbox:checked').length;
			if(chkLen < 1) {
				alert("선택된 특허정보가 없습니다.");
				return false;
			}
		}
		// 중요특허 제외일 경우
		if(flag == "0") {
			var cnt = 0;
			$('input[name=chk]:checkbox:checked').each(function(index){
				var $td = $(this).parent();
				if($('input[name=IMPORTANT_YN]', $td).val() == "0") cnt++;
			});
			
			if(cnt > 0) {
				alert("중요특허가 아닌 특허가 선택되었습니다. 다시 확인하시기 바랍니다.");
				return false;	
			}
			
			return confirm("선택문헌 중요특허 제외를 하시겠습니까?");
		} 
		// 중요특허 추가일 경우
		else if(flag == "1") {
			var cnt = 0;
			$('input[name=chk]:checkbox:checked').each(function(index){
				var $td = $(this).parent();
				if($('input[name=IMPORTANT_YN]', $td).val() == "1") cnt++;
			});
			
			if(cnt > 0) {
				alert("이미 중요특허인 특허가 선택되었습니다. 다시 확인하시기 바랍니다.");
				return false;	
			}
			
			return confirm("선택문헌 중요특허 추가를 하시겠습니까?");
		}
		// 특허 삭제
		else if(flag == "2") {
			var cnt = 0;
			$('input[name=chk]:checkbox:checked').each(function(index){
				var $td = $(this).parent();
				if($('input[name=DEL_YN]', $td).val() == "1") cnt++;
			});
			
			if(cnt > 0) {
				alert("이미 삭제된 데이터입니다.\n삭제할 데이터를 선택하세요.");
				return false;	
			}
			
			return confirm("선택문헌을 삭제하시겠습니까?");			
		}
		// 특허 복구
		else if(flag == "4") {
			var cnt = 0;
			$('input[name=chk]:checkbox:checked').each(function(index){
				var $td = $(this).parent();
				if($('input[name=DEL_YN]', $td).val() == "0") cnt++;
			});
			
			if(cnt > 0) {
				alert("삭제되지 않은 데이터입니다.\n복구할 데이터를 선택하세요.");
				return false;	
			}
			
			return confirm("선택문헌을 복구하시겠습니까?");
		}
		// 특허 다운
		else if(flag == "3") {
			
			if($('input[name=chk]').length == 0) {
				alert("검색된 결과가 없습니다.");
				return false;
			}
			
			var chkLen = $('input[name=chk]:checkbox:checked').length;
			if(chkLen == 0) {
				return confirm("특허를 선택하지 않으면 검색조건에 맞는 전체 리스트가 다운로드 됩니다.\n전체 다운로드 하시겠습니까?");		
			} else {
				return confirm("선택한 리스트를 다운로드 하시겠습니까?");	
			}
		}
		// 전체 특허 다운
		else if(flag == "5") {
			if($('input[name=chk]').length == 0) {
				alert("검색된 결과가 없습니다.");
				return false;
			}
			
			return confirm("삭제되지 않은 프로젝트 전체 리스트가 다운로드 됩니다.\n전체 다운로드 하시겠습니까?");		
		}
		// 키워드 저장일 경우
		else if(flag == "9") {
			var cnt = 0;
			if($('#KEYWORD_MAIN').val()       != "") cnt++;
			if($('#KEYWORD_TITLE').val()      != "") cnt++;
			if($('#KEYWORD_ABSTRACT').val()   != "") cnt++;
			if($('#KEYWORD_CLAIM_MAIN').val() != "") cnt++;
			
			if(cnt < 1) {
				alert("저장할 키워드가 존재하지 않습니다. 키워드 저장은 통합검색, 제목, 요약, 대표청구항 항목만 해당됩니다. 다시 확인하시기 바랍니다.");
				return false;	
			}
			
			return confirm("키워드 저장을 하시겠습니까? \n단, 키워드는 발명의 명칭, 요약, 대표청구항만 해당됩니다.");
		}
		return true;
	};

	// 데이터 직렬화
	var serializePatent = function(colName, flag) {
		var array = new Array();
		$('input[name=chk]:checkbox:checked').each(function(index){
			var data = new Object();
			data[colName] 		 = flag == 0 || flag == 4 ? 0 : 1;
			data["PATENT_ID"]    = $(this).next().val();
			data["PROJECT_ID"]   = $('#loginProjectList option:selected').val();
			array.push(data);
		});
		return Common.stringify(array);		
	};
	
	// 중요특허 추가/제외
	var setImportantYn = function(flag) {
		if(!checkValue(flag)) return;
		var data = serializePatent("IMPORTANT_YN", flag);
		var strParam = "DATA=" + data;
		
		$.ajax({
			url : "/patent/setImportantYn.do",
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
				if(data.RESULT_CD == "SUCC_0001")
					location.href = "/patent/view.do?"+serialize("T");
			}
		});
	};
	
	// 특허 삭제/복구
	var setDelYn = function(flag) {
		if(!checkValue(flag)) return;
		var data = serializePatent("DEL_YN", flag);
		var strParam = "DATA=" + data;
		
		$.ajax({
			url : "/patent/setDelYn.do",
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
				if(data.RESULT_CD == "SUCC_0001")
					location.href = "/patent/view.do?"+serialize("T");
			}
		});
	};
	
	// 키워드 저장
	var saveKeyword = function() {
		
		if(!checkValue("9")) return;
		var strParam = serialize("T");

		$.ajax({
			url : "/patent/saveKeyword.do",
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
			}
		});
	};

	// 파일 다운로드
	var download = function(filePath, fileName) {
		location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
	};

	// 다운로드 하기 위한 데이터 직렬화
	var serializeDownload = function() {
		var array = new Array();
		$('input[name=chk]:checkbox:checked').each(function(index){
			var $td = $(this).parent();
			var data = new Object();
			var $nodes = $td.children();
			$nodes.each(function(){
				if($(this).attr('name') != undefined && $(this).attr('name') != 'chk') {
					data[$(this).attr('name')] = $(this).val();
				}
			});
			array.push(data);
		});
		return Common.stringify(array);		
	};

	// 다운로드 버튼 클릭시
	var saveFile = function(docType, flag) {
		if(!checkValue(flag)) return;
		var chkLen = $('input[name=chk]:checkbox:checked').length;
		var strParam = "";
		if(chkLen == 0) {
			strParam= serialize("F") + "&DOC_TYPE=" + docType;
		} else {
			strParam = "DATA=" + serializeDownload() + "&DOC_TYPE="+docType;
		}
		
		$.ajax({
			url : "/patent/saveExcel.do",
			data : strParam,
			timeout: 0,
			async : true,
			beforeSend: function() {
		        //통신을 시작할때 처리
		        $('#dlg_progress_bar').show().fadeIn('fast'); 
		    } ,			
			success : function(data) {
		        //통신이 완료된 후 처리
		        $('#dlg_progress_bar').fadeOut();
		        if(data.RESULT_CD == "SUCC_0001") {
					download(data.FILE_PATH, data.FILE_NAME);
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	

	// 화면 로딩시
	$(document).ready(function(){
		$('#numPerPage').val('<c:out value="${PARAM.NUM_PER_PAGE}"/>');
		
		$("#btnItemizedSearch").bind("click", search);
		
		$("#btnAbleCnt").bind("click", function() {
			searchCnt("0");
		});
		
		$("#btnImptCnt").bind("click", function() {
			searchCnt("1");
		});
		
		$("#btnIncmplCnt").bind("click", function() {
			searchCnt("2");
		});
		
		$("#btnCmplCnt").bind("click", function() {
			searchCnt("3");
		});
		
		$("#btnDelCnt").bind("click", function() {
			searchCnt("4");
		});
		
		$('#numPerPage').bind("change", search);
		
		$('#chkAll').bind("change", function() {
			$('input[name=chk]').prop('checked', $('#chkAll').is(":checked"));
		});

		$("#btnAddImportant").bind("click", function() {
			setImportantYn("1");
		});
		
		$("#btnDelImportant").bind("click", function() {
			setImportantYn("0");
		});
		
		$("#btnDelPatent").bind("click", function(){
			setDelYn("2");
		});
		
		$("#btnRePatent").bind("click", function(){
			setDelYn("4");
		});
		
		$('#btnSaveKeyword').bind("click", function(){
			saveKeyword();
		});

		$("#btnAbleCnt2").bind("click", function() {
			searchCnt("0");
		});
		
		$("#btnImportCnt").bind("click", function() {
			searchCnt('1');	
		});

		$('#btnDownload0').bind("click", function() {
			saveFile("excelAll", "5");
		});
		
		$('#btnDownload1').bind("click", function() {
			saveFile("excel", "3");
		});

		$('#btnDownload2').bind("click", function() {
			saveFile("pdf", "3");
		});
		
		$(":text", $("#divSmartFinder")).keydown(function(event){
			if(event.keyCode == 13) 
				search();
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
					<!-- 검색시작 -->
					<%@ include file="/WEB-INF/views/analysis/smartFinder.jsp" %>
					<!-- //검색 끝 -->
					<!-- title/location -->
					<div class="hgroup finder">
						<h3><img src="/resources/images/common/h3_03_1.png" alt="특허검색"></h3>
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
					<div class="searchResults1">
						<span class="searchtitleicon"><h6><i class="fa fa-chevron-right"></i></h6></span>
						<h4>검색결과</h4>
						<div class="expression">
							<p class="left">
								<span class="searchtitle">입력검색식 : </span>
								<span class="searchbody"><c:out value="${PARAM.INPUT_STRING}"/></span>
							</p>
							<p class="right">
								<button type="button" id="btnSaveKeyword" class="btnSmall green">키워드 저장</button>
								<button type="button" id="btnAbleCnt2" class="btnSmall write">전체특허</button>
								<button type="button" id="btnImportCnt" class="btnSmall write">중요특허</button>
								<span>총 <c:out value="${TOTAL.PA_IMPORTANT_CNT}"/>건</span>
								<span>(아래 리스트의  <img src="/resources/images/common/ico_ferretout.gif" alt="" /> 색줄)</span>
							</p>								
						</div>
						<!-- 검색 상세리스트 -->
						<div class="finderDetail">
							<dl class="detailTop">
								<dt class="detailMenu">
									<a href="/patent/view.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.PAGE_NO}"><div class="basiclist">기본리스트</div></a>
									<a href="/patent/abstractView.do?${PARAM.QUERY_STRING}&PAGE_NO=${PARAM.PAGE_NO}"><div class="sub_btn">초록/대표도</div></a>
									<a href="#" id="btnDownload0"><div class="download_btn">전체다운</div></a>
									<a href="#" id="btnDownload1"><div class="download_btn">엑셀다운</div></a>
									<a href="#" id="btnDownload2"><div class="download_btn">PDF다운</div></a>
									<a href="/patent/wordView.do" id="btnDownload3"><div class="download_btn">워드다운</div></a>
									<a href="/patent/hwpView.do" id="btnDownload4"><div class="download_btn">한글다운</div></a>
								</dt>
								<dd>
									<span>총 <c:out value="${TOTAL.PA_TOTAL_CNT}"/>건 검색</span>
									<select id="numPerPage" title="검색결과 수량">
										<option value="50">50개씩 보기</option>
										<option value="100">100개씩 보기</option>
										<option value="150">150개씩 보기</option>
									</select>
								</dd>
							</dl>
							<div class="detailList">
								<table summary="연번,국가,구분,출원번호,출원일자,발명의 명칭,등급,전문,출원인">
								<colgroup>
									<col width="2%" />
									<col width="5%" />
									<col width="4%" />
									<col width="4%" />
									<col width="12%" />
									<col width="9%" />
									<col width="*" />
									<col width="4%" />
									<col width="4%" />
									<col width="16%" />
								</colgroup>
								<thead>
								<tr>
									<th scope="col"><input type="checkbox" id="chkAll" title="전체선택" /></th>
									<th scope="col">연번</th>
									<th scope="col">국가</th>
									<th scope="col">구분</th>
									<th scope="col">출원번호</th>
									<th scope="col">출원일자</th>
									<th scope="col">발명의 명칭</th>
									<th scope="col">등급</th>
									<th scope="col">전문</th>
									<th scope="col">출원인</th>
								</tr>
								</thead>
								<tbody>
								<c:choose>
								<c:when test="${! empty PATENT_LIST}"> 
								<c:forEach items="${PATENT_LIST}" var="PATENT">
								<c:if test="${PATENT.IMPORTANT_YN == 1}">
								<tr style="background-color:#f5feea">
								</c:if>
								<c:if test="${PATENT.IMPORTANT_YN == 0}">
								<tr>
								</c:if>
									<td>
										<input type="checkbox" name="chk" title="선택" />
										<input type="hidden" name="PATENT_ID" value="<c:out value="${PATENT.PATENT_ID}"/>"/>
										<input type="hidden" name="PROJECT_ID" value="<c:out value="${PATENT.PROJECT_ID}"/>"/>
										<input type="hidden" name="IMPORTANT_YN" value="<c:out value="${PATENT.IMPORTANT_YN}"/>"/>
										<input type="hidden" name="SEQ_NUM" value="<c:out value="${PATENT.SEQ_NUM}"/>"/>
										<input type="hidden" name="NATL_CODE" value="<c:out value="${PATENT.NATL_CODE}"/>"/>
										<input type="hidden" name="APPL_NUM" value="<c:out value="${PATENT.APPL_NUM}"/>"/>
										<input type="hidden" name="TITLE" value="<c:out value="${PATENT.TITLE}"/>"/>
										<input type="hidden" name="GRADE_OBJ" value="<c:out value="${PATENT.GRADE_OBJ}"/>"/>
										<input type="hidden" name="GRADE_CONST" value="<c:out value="${PATENT.GRADE_CONST}"/>"/>
										<input type="hidden" name="APPLICANT_RENAME" value="<c:out value="${PATENT.APPLICANT_RENAME}"/>"/>
										<input type="hidden" name="REVIEWER" value="<c:out value="${PATENT.REVIEWER}"/>"/>
										<input type="hidden" name="CMT_LAW_FIRMS" value="<c:out value="${PATENT.CMT_LAW_FIRMS}"/>"/>
										<input type="hidden" name="CMT_CO" value="<c:out value="${PATENT.CMT_CO}"/>"/>
										<input type="hidden" name="DEL_YN" value="<c:out value="${PATENT.DEL_YN}"/>"/>
									</td>
									<td>${PATENT.SEQ_NUM}</td>
									<td class="cout">${PATENT.NATL_CODE}</td>
									<td class="pate">${PATENT.KINDS_IP_TYPE}</td>
									<td class="num">${PATENT.APPL_NUM}</td>
									<td class="date">${PATENT.APPL_DATE}</td>
									<td class="name"><a href="/patent/summaryView.do?${PARAM.QUERY_STRING}&PATENT_ID=${PATENT.PATENT_ID}&PAGE_NO=${PATENT.ROW_PAGE_NO}">${PATENT.TITLE}</a></td>
									<td>${PATENT.GRADE_OBJ}|${PATENT.GRADE_CONST}</td>
									<td>
										<c:if test="${PATENT.PATENT_FULLTXT == '/process/error.do'}">
											<a href="javascript:alert('전문이 존재하지 않습니다.');"><img src="/resources/images/common/ico_file.gif" alt="파일" /></a>
										</c:if>
										<c:if test="${PATENT.PATENT_FULLTXT != '/process/error.do'}">
											<a href="/patent/pdfView.do?PDF=${PATENT.PATENT_FULLTXT}" target="_blank"><img src="/resources/images/common/ico_file.gif" alt="파일" /></a>
										</c:if>
									</td>
									<td class="app">${PATENT.APPLICANT_RENAME}</td>
								</tr>
								</c:forEach>
								</c:when>
								<c:otherwise>
								<tr>
									<td colspan="10">검색된 결과가 없습니다.</td>
								</tr>								
								</c:otherwise>
								</c:choose>
								</tbody>
								</table>
							</div>
						</div>
						<!-- //검색 상세리스트 -->
						
						<!-- 버튼 -->
						<div class="btnArea left">
							<a id="btnAddImportant" href="#" class="btntype3"><span>선택문헌 중요특허 추가</span></a>
							<a id="btnDelImportant" href="#" class="btntype3"><span>선택문헌 중요특허 제외</span></a>
							<a id="btnDelPatent" href="#" class="btntype3"><span>선택문헌 삭제</span></a>
							<a id="btnRePatent" href="#" class="btntype3"><span>선택문헌 복구</span></a>
						</div>
						<!-- 버튼 -->

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