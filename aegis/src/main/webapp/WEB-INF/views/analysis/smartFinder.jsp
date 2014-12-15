<%@ page session="true" contentType="text/html; charset=UTF-8"%>
					<section id="smart_finder">	
						<form id="searchForm" name="SearchItemForm" method="post" onsubmit="return false;" >
						<fieldset>
							<legend>스마트검색</legend>
							<div id="divSmartFinderWrap" class="detail_smart" style="top: 0px; z-index: 100; display: block; position: relative;">
								<div id="divSmartFinder">
									<div class="directSearch">
										<p class="left">
											<a id="btnAbleCnt" href="#" class="btnSmall write">전체검색</a><em>${TOTAL.ABLE_CNT}건[총 ${TOTAL.TOTAL_CNT}건]</em>
											<a id="btnImptCnt" href="#" class="btnSmall write">중요특허</a><em>총 ${TOTAL.IMPORTANT_CNT}건</em>
											<a id="btnIncmplCnt" href="#" class="btnSmall write">미검토</a><em>총 ${TOTAL.INCMPL_CNT}건</em>
											<a id="btnCmplCnt" href="#" class="btnSmall write">검토완료</a><em>총 ${TOTAL.CMPL_CNT}건</em>
											<a id="btnDelCnt" href="#" class="btnSmall write">삭제건수</a><em>총 ${TOTAL.DEL_CNT}건</em>
										</p>
									</div>
									<div class="searchCondition">
										<h4>키워드 검색</h4>
										<div class="searchBox">
											<table summary="발명의 명칭,요약,청구범위">
											<caption>키워드 검색</caption>
											<colgroup>
												<col width="12%" />
												<col width="38%" />
												<col width="12%" />
												<col width="38%" />
											</colgroup>
											<tbody>
											<tr>
												<th scope="row"><label for="KEYWORD_MAIN">통합검색</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_MAIN" value="${PARAM.KEYWORD_MAIN}" />
												</td>
												<td rowspan="4"></td>
												<td rowspan="4">
													<span><strong>주)</strong> 각 통합검색은 발명의 명칭, 요약, 대표청구항<br />
														 항목에 대한 검색을 한 번에 할 수 있습니다.
													</span><br /><br />
													<span><strong>주)</strong> 키워드 저장은 통합검색, 발명의 명칭, 요약, <br />
														 대표청구항으로 검색한 항목에 대해서만 키워드를<br />
														 저장할 수 있습니다.
													</span>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_TITLE">발명의 명칭</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_TITLE" value="${PARAM.KEYWORD_TITLE}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_ABSTRACT">요약</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_ABSTRACT" value="${PARAM.KEYWORD_ABSTRACT}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_CLAIM_MAIN">대표청구항</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_CLAIM_MAIN" value="${PARAM.KEYWORD_CLAIM_MAIN}"/>
												</td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="searchCondition">
										<h4>국가, 출원인, 발명자 검색</h4>
										<div class="searchBox">
											<table summary="출원인,발명자" class="w50">
											<caption>키워드 검색</caption>
											<colgroup>
												<col width="24%" />
												<col width="76%" />
											</colgroup>
											<tbody>
											<tr>
												<th scope="row"><label for="KEYWORD_APPLICANT">출원인</label></th>
												<td>
													<input type="text"  class="w90" id="KEYWORD_APPLICANT" value="${PARAM.KEYWORD_APPLICANT}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_INVENTOR">발명자</label></th>
												<td>
													<input type="text"  class="w90" id="KEYWORD_INVENTOR" value="${PARAM.KEYWORD_INVENTOR}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_NATL_CODE">출원국가</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_NATL_CODE" value="${PARAM.KEYWORD_NATL_CODE}"/>
												</td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="searchCondition">
										<h4>출원번호, 공개번호, 등록번호, 연번 검색</h4>
										<div class="searchBox">
											<table summary="출원번호,공개번호,등록번호,연번">
											<caption>출원번호, 공개번호, 등록번호, 연번 검색</caption>
											<colgroup>
												<col width="12%" />
												<col width="38%" />
												<col width="12%" />
												<col width="38%" />
											</colgroup>
											<tbody>
											<tr>
												<th scope="row"><label for="KEYWORD_APPL_NUM">출원번호</label></th>
												<td>
													<input type="text"  class="w50" id="KEYWORD_APPL_NUM" value="${PARAM.KEYWORD_APPL_NUM}"/>
												</td>
												<th scope="row"><label for="KEYWORD_LAID_PUBLIC_NUM">공개번호</label></th>
												<td>
													<input type="text"  class="w50" id="KEYWORD_LAID_PUBLIC_NUM" value="${PARAM.KEYWORD_LAID_PUBLIC_NUM}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_REGI_NUM">등록번호</label></th>
												<td>
													<input type="text"  class="w50" id="KEYWORD_REGI_NUM" value="${PARAM.KEYWORD_REGI_NUM}"/>
												</td>
												<th scope="row"><label for="KEYWORD_SEQ_NUM_FR">연번</label></th>
												<td>
													<input type="text"  class="w20" id="KEYWORD_SEQ_NUM_FR" value="${PARAM.KEYWORD_SEQ_NUM_FR}"/>&nbsp;-&nbsp; 
													<input type="text"  class="w20" id="KEYWORD_SEQ_NUM_TO" value="${PARAM.KEYWORD_SEQ_NUM_TO}"/>
												</td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="searchCondition">
										<h4>기술분류 선택</h4>
										<div class="searchBox">
											<table summary="대분류,중분류,출원국가,목적등급,목적,해결수단등급,해결수단">
											<caption>기술분류 선택</caption>
											<colgroup>
												<col width="12%" />
												<col width="38%" />
												<col width="12%" />
												<col width="38%" />
											</colgroup>
											<tbody>
											<tr>
												<th scope="row"><label for="KEYWORD_KINDS_LCATE">대분류</label></th>
												<td>
													<select class="w50" id="KEYWORD_KINDS_LCATE">
														<option value=""  <c:if test="${PARAM.KEYWORD_KINDS_LCATE == ''}">selected="selected"</c:if>>선택</option>
														<option value="01" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '01'}">selected="selected"</c:if>>목적/효과</option>
														<option value="02" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '02'}">selected="selected"</c:if>>기능</option>
														<option value="03" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '03'}">selected="selected"</c:if>>구성</option>
														<option value="04" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '04'}">selected="selected"</c:if>>재료/성분</option>
														<option value="05" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '05'}">selected="selected"</c:if>>공정/제어</option>
														<option value="06" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '06'}">selected="selected"</c:if>>동력/원리</option>
														<option value="07" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '07'}">selected="selected"</c:if>>응용분야</option>
														<option value="08" <c:if test="${PARAM.KEYWORD_KINDS_LCATE == '08'}">selected="selected"</c:if>>기타</option>
													</select>												
												</td>
												<th scope="row"><label for="KEYWORD_KINDS_MCATE">중분류</label></th>
												<td>
													<input type="text" class="w50" id="KEYWORD_KINDS_MCATE" value="${PARAM.KEYWORD_KINDS_MCATE}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_GRADE_OBJ"><em>목적등급</em></label></th>
												<td>
													<select class="w50" id="KEYWORD_GRADE_OBJ">
														<option value=""  <c:if test="${PARAM.KEYWORD_GRADE_OBJ == ''}">selected="selected"</c:if>>선택</option>
														<option value="N" <c:if test="${PARAM.KEYWORD_GRADE_OBJ == 'N'}">selected="selected"</c:if>>미부여</option>
														<option value="S" <c:if test="${PARAM.KEYWORD_GRADE_OBJ == 'S'}">selected="selected"</c:if>>S</option>
														<option value="A" <c:if test="${PARAM.KEYWORD_GRADE_OBJ == 'A'}">selected="selected"</c:if>>A</option>
														<option value="B" <c:if test="${PARAM.KEYWORD_GRADE_OBJ == 'B'}">selected="selected"</c:if>>B</option>
														<option value="C" <c:if test="${PARAM.KEYWORD_GRADE_OBJ == 'C'}">selected="selected"</c:if>>C</option>
													</select>
												</td>
												<th scope="row"><label for="KEYWORD_GRADE_CONST"><em>해결수단등급</em></label></th>
												<td>
													<select class="w50" id="KEYWORD_GRADE_CONST">
														<option value=""  <c:if test="${PARAM.KEYWORD_GRADE_CONST == ''}">selected="selected"</c:if>>선택</option>
														<option value="N" <c:if test="${PARAM.KEYWORD_GRADE_CONST == 'N'}">selected="selected"</c:if>>미부여</option>
														<option value="S" <c:if test="${PARAM.KEYWORD_GRADE_CONST == 'S'}">selected="selected"</c:if>>S</option>
														<option value="A" <c:if test="${PARAM.KEYWORD_GRADE_CONST == 'A'}">selected="selected"</c:if>>A</option>
														<option value="B" <c:if test="${PARAM.KEYWORD_GRADE_CONST == 'B'}">selected="selected"</c:if>>B</option>
														<option value="C" <c:if test="${PARAM.KEYWORD_GRADE_CONST == 'C'}">selected="selected"</c:if>>C</option>
													</select>
												</td>	
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_KEYWORD"><em>목적/해결수단</em></label></th>
												<td>
													<input type="text" class="w90" id="KEYWORD_KEYWORD" value="${PARAM.KEYWORD_KEYWORD}"/>
												</td>
												<td></td>
												<td></td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="searchCondition">
										<h4>검색구간 지정(출원일,공개일,등록일)</h4>
										<div class="searchBox">
											<table summary="출원일자,공개일자,검토결과,검토구분">
											<caption>검색구간 지정(출원일,공개일,등록일)</caption>
											<colgroup>
												<col width="12%" />
												<col width="38%" />
												<col width="12%" />
												<col width="38%" />
											</colgroup>
											<tbody>
											<tr>
												<th scope="row"><label for="KEYWORD_APPL_DATE_FR">출원일자</label></th>
												<td>
													<input type="text" class="w20" title="시작일" id="KEYWORD_APPL_DATE_FR" value="${PARAM.KEYWORD_APPL_DATE_FR}"/>&nbsp;-&nbsp;  
													<input type="text" class="w20" title="종료일" id="KEYWORD_APPL_DATE_TO" value="${PARAM.KEYWORD_APPL_DATE_TO}"/>
												</td>
												<td colspan="2">
													<span><strong>예)</strong>
														20140101 - 20141231
													</span>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_LAID_PUBLIC_DATE_FR">공개일자</label></th>
												<td>
													<input type="text" class="w20" title="시작일" id="KEYWORD_LAID_PUBLIC_DATE_FR" value="${PARAM.KEYWORD_LAID_PUBLIC_DATE_FR}"/>&nbsp;-&nbsp; 
													<input type="text" class="w20" title="종료일" id="KEYWORD_LAID_PUBLIC_DATE_TO" value="${PARAM.KEYWORD_LAID_PUBLIC_DATE_TO}"/>
												</td>
												<th scope="row"><label for="KEYWORD_REGI_DATE_FR">등록일자</label></th>
												<td>
													<input type="text" class="w20" title="시작일" id="KEYWORD_REGI_DATE_FR" value="${PARAM.KEYWORD_REGI_DATE_FR}"/>&nbsp;-&nbsp; 
													<input type="text" class="w20" title="종료일" id="KEYWORD_REGI_DATE_TO" value="${PARAM.KEYWORD_REGI_DATE_TO}"/>
												</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_REVIEWER"><em>검토자</em></label></th>
												<td>
													<input type="text" class="w60" id="KEYWORD_REVIEWER"  value="${PARAM.KEYWORD_REVIEWER}"/>
												</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<th scope="row"><label for="KEYWORD_REVIEW_FLAG"><em>검토구분</em></label></th>
												<td>
													<select class="w65" id="KEYWORD_REVIEW_FLAG">
														<option value="" <c:if test="${PARAM.KEYWORD_REVIEW_FLAG  == ''}">selected="selected"</c:if>>선택</option>
														<option value="0" <c:if test="${PARAM.KEYWORD_REVIEW_FLAG == '0'}">selected="selected"</c:if>>미검토</option>
														<option value="1" <c:if test="${PARAM.KEYWORD_REVIEW_FLAG == '1'}">selected="selected"</c:if>>검토중</option>
														<option value="2" <c:if test="${PARAM.KEYWORD_REVIEW_FLAG == '2'}">selected="selected"</c:if>>검토완료</option>
													</select>
												</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
											</tr>
											</tbody>
											</table>
										</div>
									</div>
									<div class="btn_area">
										<a id="btnClearSmartFinder" href="#" onclick="return false;"><img src="/resources/images/common/btn_clear.gif" alt="초기화"></a>
										<span class="btn_search"><button id="btnItemizedSearch" type="button">검색하기</button></span>
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
