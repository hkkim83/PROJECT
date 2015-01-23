<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>


<script type="text/javascript" src="/resources/js/smartFinder.js" ></script>
<script type="text/javascript">
<!--
//-->
(function($){
	var projectId = $('#loginProjectList option:selected').val();
	var writeYn   = "<%=user.getProjectAuth()%>";
	var List = {};
	
	// 그리드 초기화
	var initGrid = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = [""			,"CHK"				,"30"	,"center"	,"ra"	,"str"	,"false"];
		arr[idx++] = ["연번"      	,"SEQ_NUM"			,"50"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = ["출원번호" 		,"APPL_NUM"			,"80"	,"center"	,"ro"	,"str"	,"false"];
	    arr[idx++] = ["발명의명칭" 		,"TITLE"			,"*"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"PROJECT_ID"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"PATENT_ID"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["" 			,"GRADE_CONST"		,"0"	,"left"		,"ro"	,"str"	,"false"];
	    
		List = new CommonGrid('gridList', arr);
		List.grid.attachEvent("onRowSelect", function(rId,cInd){
			if(cInd != 0) detailList(rId, cInd, "R");
		});
		List.grid.attachEvent("onCheck"   , function(rId,cInd,state){detailList(rId, cInd, "L");});
		List.dp.setDataColumns([false,false,false,false,false,false]);
	};
	
	// 조회조건 직렬화
	var serialize = function() {
		var data = new Object();
		$('.searchBox select').each(function() {
			data[$(this).attr('id')] = $('option:selected', $(this)).val();
		});
		return Common.stringify(data);
	};
	
	// 리스트 조회
	var searchList = function() {
		var data = serialize();
		var strParam = "PROJECT_ID="+projectId+"&DATA="+data;
		$.ajax({
			url : '/keyPatent/list.do',
			data : strParam,
			cache : false,
			success : function(data) {
				List.parse(data.LIST);
				for(var row = 0; row < List.grid.getRowsNum(); row++) {
					var rowId = List.grid.getRowId(row);
					var col = List.grid.getColIndexById("GRADE_CONST");
					// 핵심특허일 경우 색상을 빨간색으로 변경
					if(List.grid.cells(rowId, col).getValue() == "S") {
						List.grid.setRowTextStyle(rowId, "color: red;");
					}
				}
			}
		});
	};
	
	// 그리드 클릭시 화면에 셋팅하기
	var setDetailData = function(data, str) {
		$.each(data, function(key, value) {
			if($('#'+str+key) != undefined) {
				if(key != "IMAGE_MAIN" && key != "PATENT_FULLTXT") {
					$('#'+str+"_"+key).text(value);
				}
			}
		});
		
		$('#'+str+"_APPL_NUM").text(data["APPL_NUM"]+" ( "+data["APPL_DATE"]+" )");
		$('#'+str+"_LAID_PUBLIC_NUM").text(data["LAID_PUBLIC_NUM"]+" ( "+data["LAID_PUBLIC_DATE"]+" )");
		$('#'+str+"_REGI_NUM").text(data["REGI_NUM"]+" ( "+data["REGI_DATE"]+" )");
		$('#'+str+"_IMAGE_MAIN").attr("src", data["IMAGE_MAIN"]);
		$('#'+str+"_IMAGE_VIEW").attr("href", "/patent/imageView.do?IMAGE="+data["IMAGE_MAIN"]).attr("target", "_blank");
		if(data["PATENT_FULLTXT"] == "/process/error.do")
			$('#'+str+"_PATENT_FULLTXT").attr("href", "javascript:alert('전문이 존재하지 않습니다.');");
		else 
			$('#'+str+"_PATENT_FULLTXT").attr("href", "/patent/pdfView.do?PDF="+data["PATENT_FULLTXT"]).attr("target", "_blank");
	};

	// 그리드 클릭시 특허정보 조회
	var detailList = function(rowId, col, str) {
		var projectId = List.grid.cells(rowId, List.grid.getColIndexById("PROJECT_ID")).getValue();
		var patentId  = List.grid.cells(rowId, List.grid.getColIndexById("PATENT_ID")).getValue();
		var strParam = "PROJECT_ID="+projectId+"&PATENT_ID="+patentId;
		$.ajax({
			url : '/keyPatent/detail.do',
			data : strParam,
			cache : false,
			success : function(data) {
				setDetailData(data.LIST, str);
			}
		});		
	};

	// 정합성 체크
	var checkVal = function(str) {
		if(List.grid.getRowsNum() < 1) {
			alert("저장할 데이터가 존재하지 않습니다. 먼저 검색해 주세요.");
			return false;
		}	
		if($('#'+str+"_SEQ_NUM").text() == "") {
			alert("저장할 데이터가 존재하지 않습니다. 다시 확인하시기 바랍니다.");
			return false;
		}
		
		return confirm("저장하시겠습니까?");
	};
	
	// 데이터 직렬화
	var serializePatent = function(str) {
		var data = new Object();
		$('#'+str+'Results textarea').each(function(){
			var id = $(this).attr('id');
			data[id.substring(2)] = $(this).val();
		});
		$('#'+str+'Results input').each(function(){
			var id = $(this).attr('id');
			data[id.substring(2)] = $(this).text();
		});
		return Common.stringify(data);
	};
	
	// 저장버튼 클릭시
	var save = function(str) {
		if(!checkVal(str)) return;
		
		var data = serializePatent(str);
		var strParam = "DATA="+data;
		$.ajax({
			url : '/keyPatent/save.do',
			data : strParam,
			cache : false,
			success : function(data) {
				alert(data.RESULT_MSG);
			}
		});			
	};
	
	// 화면로딩시
	$(document).ready(function(){
		
		$("#btnItemizedSearch").bind("click", searchList);
		
		$('#btnClearSmartFinder').bind("click", function() {
			$('.searchBox select').val("");	
		});
		
		$("#btnSave1").bind("click", function() {
			save("L");
		});
		$("#btnSave2").bind("click", function() {
			save("R");
		});	
		
		// 프로젝트 권한이 편집제한인 경우
		if(writeYn == "0") {
			$("textarea").attr("readonly", true);
			$("#btnSave1").hide();
			$("#btnSave2").hide();
		}
		
		// 중분류 조회
		for(var i=1; i<=8; i++)
			Common.setCategoryCombo(projectId, 'M', '0'+i,  $('#MCATE0'+i));
		
		initGrid();
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
					<section id="smart_finder">	
						<form name="SearchItemForm" method="post" onsubmit="return false;">
						<fieldset>
							<legend>스마트검색</legend>
							<div id="divSmartFinderWrap" class="detail_smart" style="top: 0px; z-index: 100; display: block; position: relative;">
								<div id="divSmartFinder">
									<div class="directSearch">
										<p class="mid">아래의 조건들을 선택하셔서 검색하시면 오른쪽에 검색결과가 보여집니다.</p>
									</div>
									<div class="searchCondition type2">
										<h4>키워드 검색</h4>
										<div class="searchBox">
											<div class="analysis">
												<table summary="목적/효과,기능,구성,재료/성분,응용분야,공정/제어,동력/원리">
												<caption>선택</caption>
												<colgroup>
													<col width="13%" />
													<col width="20%" />
													<col width="13%" />
													<col width="20%" />
													<col width="13%" />
													<col width="20%" />
												</colgroup>
												<tbody>
												<tr>
													<th><label for="MCATE01">목적/효과</label></th>
													<td>
														<select class="w95" id="MCATE01">
															<option>크기 감소</option>
														</select>
													</td>
													<th><label for="MCATE02">기능</label></th>
													<td>
														<select class="w95" id="MCATE02">
															<option>일체형</option>
														</select>
													</td>
													<th><label for="MCATE03">구성</label></th>
													<td>
														<select class="w95" id="MCATE03">
															<option>일체형</option>
														</select>
													</td>
												</tr>
												<tr>
													
													<th><label for="MCATE04">재료/성분</label></th>
													<td>
														<select class="w95" id="MCATE04">
															<option>선택</option>
														</select>
													</td>
													<th><label for="MCATE05">응용분야</label></th>
													<td>
														<select class="w95" id="MCATE05">
															<option>선택</option>
														</select>
													</td>
													<th><label for="MCATE06">공정/제어</label></th>
													<td>
														<select class="w95" id="MCATE06">
															<option>선택</option>
														</select>
													</td>
												</tr>
												<tr>
													<th><label for="MCATE07">동력/원리</label></th>
													<td>
														<select class="w95" id="MCATE07">
															<option>선택</option>
														</select>
													</td>
													<th><label for="MCATE08">기타</label></th>
													<td>
														<select class="w95" id="MCATE08">
															<option>선택</option>
														</select>
													<th class="last">&nbsp;</th>
													<td>&nbsp;</td>
												</tr>
												</tbody>
												</table>
												<div class="btn_area">
													<button id="btnClearSmartFinder" type="button" class="reset">초기화</button>
													<button id="btnItemizedSearch" type="button" class="btn_search">검색하기
													<i class="fa fa-chevron-right"></i><i class="fa fa-chevron-right"></i>
													</button>												
												</div>
											</div>
											<div class="searchInfo w38">
												<h5>검색결과</h5>
												<div id="gridList" style="background-color:white; width:100%; height:150px;"></div>
											</div>
										</div>
									</div>
									
								</div>
								<div id="divDummySmartFinderBtn" class="sfinder_open" style="display: none; top: 5px;">
									<span class="sfinder_txt"><a href="#" onclick="return false;">
									<img id="DummySmartFinder" src="/resources/images/common/btn_smartfinder_close.gif" alt="스마트검색 닫기"></a></span> 
								</div>
							</div>
							<div id="divSmartFinderBtn" class="sfinder_open" style="position: relative; opacity: 1; top: 0px; left: 0px; z-index: 99; display: block;">
								<span class="sfinder_txt">
									<a id="btnToggleSmartFinder" href="#" onclick="return false;">
										<img id="ToggleSmartFinder" src="/resources/images/common/btn_smartfinder_open_m.gif" alt="스마트검색 열기">
									</a>
								</span> 
							</div>
						</fieldset>
						</form>
					</section>
					<!-- //검색 끝 -->
					
					<!-- title/location -->
					<div class="hgroup finder">
						<h3><img src="/resources/images/common/h3_03_3.png" alt="핵심특허분석"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터분석</li>
								<li><strong>핵심특허분석</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<div class="searchResults">
						<!-- 검색 상세리스트 -->
						<div class="resultDetail">
							<div id="LResults" class="resultBox">
								<ul class="resultDetailList">
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;연번</h4><span id="L_SEQ_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;발명의명칭</h4><span id="L_TITLE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원국가</h4><span id="L_NATL_CODE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;권리구분</h4><span id="L_KINDS_IP_TYPE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;대표 IPC</h4><span id="L_IPC_ALL"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원번호/일자</h4><span id="L_APPL_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;공개번호/일자</h4><span id="L_LAID_PUBLIC_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;등록번호/일자</h4><span id="L_REGI_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원인</h4><span id="L_APPLICANT"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;Family 정보</h4><span id="L_FM_NUM"></span></li>
								</ul>
								<p class="resultImg">
									<a id="L_IMAGE_VIEW" href=""><img id="L_IMAGE_MAIN" src="/resources/images/patent/default.jpg" alt="" width="135" height="174"></a>
									<span><a id="L_PATENT_FULLTXT" href=""><img src="/resources/images/common/btn_bogi_1.gif" alt="전문보기"></a></span>
								</p>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;발명의요약</h4>
									</div>
									<p class="executive">
										<textarea id="L_ABSTRACT" title="발명의요약" class="h3"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;대표청구항</h4>
									</div>
									<p class="executive">
										<textarea id="L_CLAIM_MAIN" title="대표청구항" class="h3"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;검토의견1</h4>
									</div>
									<p class="executive">
										<textarea id="L_CMT_LAW_FIRMS" title="검토의견1" class="h2"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;검토의견2</h4>
									</div>
									<p class="executive">
										<textarea id="L_CMT_CO" title="검토의견2" class="h2"></textarea>
										<input type="hidden" id="L_PROJECT_ID"/>
										<input type="hidden" id="L_PATENT_ID"/>
									</p>
								</div>						
							</div>
							<div id="RResults" class="resultBox">
								<ul class="resultDetailList">
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;연번</h4><span id="R_SEQ_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;발명의명칭</h4><span id="R_TITLE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원국가</h4><span id="R_NATL_CODE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;권리구분</h4><span id="R_KINDS_IP_TYPE"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;대표 IPC</h4><span id="R_IPC_ALL"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원번호/일자</h4><span id="R_APPL_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;공개번호/일자</h4><span id="R_LAID_PUBLIC_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;등록번호/일자</h4><span id="R_REGI_NUM"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;출원인</h4><span id="R_APPLICANT"></span></li>
									<li><h4><i class="fa fa-caret-right"></i>&nbsp;Family 정보</h4><span id="R_FM_NUM"></span></li>
								</ul>
								<p class="resultImg">
									<a id="R_IMAGE_VIEW" href="" target="_blank"><img id="R_IMAGE_MAIN" src="/resources/images/patent/default.jpg" alt="" width="135" height="174"></a>
									<span><a id="R_PATENT_FULLTXT" href="" target="_blank"><img src="/resources/images/common/btn_bogi_1.gif" alt="전문보기"></a></span>
								</p>
								
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;발명의요약</h4>
									</div>
									<p class="executive">
										<textarea id="R_ABSTRACT" title="발명의요약" class="h3"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;대표청구항</h4>
									</div>
									<p class="executive">
										<textarea id="R_CLAIM_MAIN" title="대표청구항" class="h3"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
									    <h4><i class="fa fa-caret-right"></i>&nbsp;검토의견1</h4>
									</div>
									<p class="executive">
										<textarea id="R_CMT_LAW_FIRMS" title="검토의견1" class="h2"></textarea>
									</p>
								</div>
								<div class="resultInfo">
									<div class="point">
										<h4><i class="fa fa-caret-right"></i>&nbsp;검토의견2</h4>
									</div>
									<p class="executive">
										<textarea id="R_CMT_CO" title="검토의견2" class="h2"></textarea>
										<input type="hidden" id="R_PROJECT_ID"/>
										<input type="hidden" id="R_PATENT_ID"/>
									</p>
								</div>
							</div>
						</div>
						<!-- //검색 상세리스트 -->
					</div>
					<!-- //검색결과 -->
					<!-- 버튼 -->
					<div class="btnAreatop">
						<div class="btnArea1 right">
							<a href="#" id="btnSave1" class="btntype4"><span>저장</span></a>
						</div>
						<div class="btnArea1 right">
							<a href="#" id="btnSave2" class="btntype4"><span>저장</span></a>
						</div>
					</div>
					<!-- 버튼 -->	
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->
	
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>