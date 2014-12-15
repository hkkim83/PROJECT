<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>
<style>
<!--
.totalcolor {background-color:#b0e0e6;}
.subtotalcolor {background-color:#fffacd;}
.normalcolor {background-color:#ffffff;}
-->
</style>
<script type="text/javascript">
<!--
//-->
(function($){

	var listArr = ["LIST1", "LIST2", "LIST3", "LIST4", "LIST5", "LIST6"];
	// 테이블 만들기
	var makeTable = function(data) {
		for(var j=0; j<2; j++) {
			var list = data[listArr[j*3]];
			var tbl_name = '#tbl_list'+(j*3+1);
			for(var i=0; i<list.length; i++) {
				$(tbl_name).append('<tr></tr>');
				var map = list[i];
				var $tr = $(tbl_name+' tr').eq(i+2);
				if(map["CATE"] == "계")
					$tr.addClass("totalcolor");
				else 
					$tr.addClass("normalcolor");
				$tr.append("<td>"+map["CATE"]+"</td>");
				$tr.append("<td align='right'>"+map["S_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["A_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["B_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["C_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["N_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["T_GRADE"]+"</td>");
			}
			
			list = data[listArr[j*3+1]];
			tbl_name = '#tbl_list'+(j*3+2);
			
			for(var i=0; i<list.length; i++) {
				$(tbl_name).append('<tr></tr>');
				var map = list[i];
				var $tr = $(tbl_name+' tr').eq(i+2);
				if(map["CATE"] == "계")
					$tr.addClass("totalcolor");
				else 
					$tr.addClass("normalcolor");
				
				$tr.append("<td>"+map["CATE"]+"</td>");
				$tr.append("<td align='right'>"+map["KR_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["JP_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["US_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["EP_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["CN_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["PCT_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["TOT_GRADE"]+"</td>");
			}

			list = data[listArr[j*3+2]];
			tbl_name = '#tbl_list'+(j*3+3);
			var start = new Date().getYear()+1900 - 26;
			var $nodes = $(tbl_name+' tr').eq(1).children();
			$nodes.each(function(index) {
				var str = (index+1)+"구간<br>";
				if(index == 0)
					str += '~'+(parseInt(start)+4);
				else 
					str += start+'~'+(parseInt(start)+4+"");
				$(this).html(str);
				start = parseInt(start)+5;
			});
			
			for(var i=0; i<list.length; i++) {
				$(tbl_name).append('<tr></tr>');
				var map = list[i];
				var $tr = $(tbl_name+' tr').eq(i+2);
				if(map["CATE"] == "계")
					$tr.addClass("totalcolor");
				else 
					$tr.addClass("normalcolor");
				
				$tr.append("<td>"+map["CATE"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_1"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_2"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_3"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_4"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_5"]+"</td>");
				$tr.append("<td align='right'>"+map["SUM_6"]+"</td>");
			}
		}
	};
	
	// XML 만들기
	var makeChartXML = function(idx, title, xAxis, yAxis, data) {
		var str = "<chart caption='"+title+"' xAxisName='"+xAxis+"' yAxisName='"+yAxis+"' numberSuffix='건'>\n";	
		str += "\t<categories>\n";
		if(idx == 1 || idx == 4) {
			str += "\t\t<category label='S'/>\n";	
			str += "\t\t<category label='A'/>\n";
			str += "\t\t<category label='B'/>\n";
			str += "\t\t<category label='C'/>\n";
			str += "\t\t<category label='미부여'/>\n";
			str += "\t</categories>\n";
			for(var i=0; i<data.length-1; i++) {
				var map = data[i];
				str += "\t<dataset seriesName='"+map["CATE"]+"'>\n";
				str += "\t\t<set value='"+map["S_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["A_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["B_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["C_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["N_GRADE"]+"'/>\n";
				str += "\t</dataset>\n";
			}			
		} else if(idx == 2 || idx == 5) {
			str += "\t\t<category label='한국'/>\n";	
			str += "\t\t<category label='미국'/>\n";
			str += "\t\t<category label='일본'/>\n";
			str += "\t\t<category label='유럽'/>\n";
			str += "\t\t<category label='중국'/>\n";
			str += "\t\t<category label='PCT'/>\n";
			str += "\t</categories>\n";
			for(var i=0; i<data.length-1; i++) {
				var map = data[i];
				str += "\t<dataset seriesName='"+map["CATE"]+"'>\n";
				str += "\t\t<set value='"+map["KR_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["US_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["JP_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["EP_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["CN_GRADE"]+"'/>\n";
				str += "\t\t<set value='"+map["PCT_GRADE"]+"'/>\n";
				str += "\t</dataset>\n";
			}
		} else {
			for(var i=0; i<5; i++) {
				str += "\t\t<category label='"+(i+1)+"구간'/>\n";	
			}
			str += "\t</categories>\n";
			for(var i=0; i<data.length-1; i++) {
				var map = data[i];
				str += "\t<dataset seriesName='"+map["CATE"]+"'>\n";	
				for(var j=0; j<5; j++) {
					str += "\t\t<set value='"+map["SUM_"+(j+1)]+"'/>\n";	
				}
				str += "\t</dataset>\n";
			}			
		}
		str += "</chart>";
		return str;
	};
	
	// 차트 만들기
	var makeChart = function(idx, title, xAxis, yAxis, data) {
		$("#chartContainer"+idx).insertFusionCharts({
           swfUrl: "/resources/FusionCharts/MSColumn3D.swf", 
           dataSource: makeChartXML(idx, title, xAxis, yAxis, data), 
           dataFormat: "xml", 
           width: "100%", 
           height: "300", 
           id: "myChartId"+idx
     	});
	};
	
	// 리스트 조회
	var search = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : "/graph/cateList.do",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					makeTable(data);
					for(var i=0; i<6; i++) {
						var gb = i%3 == 0 ? "등급별" : i%3 == 1 ? "국가별" : "연도별";
						var cate = i < 3 ? "중분류" : "소분류";
						makeChart(i+1, "기술분류별 "+gb+" 분석 ("+cate+")", cate, "특허건수", data[listArr[i]]);
					}
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 차트변경 선택시
	var changeChart = function(obj) {
		var value = $('option:selected', obj).val();
		var $chartContainer = obj.parent().next();
		$chartContainer.updateFusionCharts({"swfUrl": "/resources/FusionCharts/"+value+".swf"});
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		search();
		
		$('#chartList1, #chartList2, #chartList3, #chartList4, #chartList5, #chartList6').on('change', function() {
			changeChart($(this));
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

					<!-- title/location -->
					<div class="hgroup">
						<h3><img src="/resources/images/common/h3_04.png" alt="그래프분석"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li><strong>그래프분석</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<div class="bbsContes">
						<div id="div_bbs" class="tbl_bbs11">
							<div id="div_list1">
								<h4>기술분류별 등급별 분석 (중분류)</h4>
								<table id=tbl_list1 class="mt10 w98">
									<colgroup>
										<col width="150"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">중분류</th>
											<th scope="col" colspan="5">기술등급</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">S</th>
											<th scope="col">A</th>
											<th scope="col">B</th>
											<th scope="col">C</th>
											<th scope="col">미부여</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList1">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer1">FusionCharts XT will load here!</div>
							<div id="div_list4">
								<h4>기술분류별 등급별 분석 (소분류)</h4>
								<table id=tbl_list4 class="mt10 w98">
									<colgroup>
										<col width="150"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">소분류</th>
											<th scope="col" colspan="5">기술등급</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">S</th>
											<th scope="col">A</th>
											<th scope="col">B</th>
											<th scope="col">C</th>
											<th scope="col">미부여</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList4">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer4">FusionCharts XT will load here!</div>
							<div id="div_list2" class="mt20">
								<h4>기술분류별 국가별 분석 (중분류)</h4>
								<table id=tbl_list2 class="mt10 w98">
									<colgroup>
										<col width="150"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">중분류</th>
											<th scope="col" colspan="6">국가</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">한국</th>
											<th scope="col">미국</th>
											<th scope="col">일본</th>
											<th scope="col">유럽</th>
											<th scope="col">중국</th>
											<th scope="col">PCT</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList2">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer2">FusionCharts XT will load here!</div><div id="div_list2" class="mt20">
							<div id="div_list5" class="mt20">
								<h4>기술분류별 국가별 분석 (소분류)</h4>
								<table id=tbl_list5 class="mt10 w98">
									<colgroup>
										<col width="150"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">소분류</th>
											<th scope="col" colspan="6">국가</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">한국</th>
											<th scope="col">미국</th>
											<th scope="col">일본</th>
											<th scope="col">유럽</th>
											<th scope="col">중국</th>
											<th scope="col">PCT</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList5">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer5">FusionCharts XT will load here!</div>
							<div id="div_list3" class="mt20">
								<h4>기술분류별 연도별 분석 (중분류)</h4>
								<table id=tbl_list3 class="mt10 w98">
									<colgroup>
										<col width="120"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">중분류</th>
											<th scope="col" colspan="5">연도</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">1</th>
											<th scope="col">2</th>
											<th scope="col">3</th>
											<th scope="col">4</th>
											<th scope="col">5</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList3">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer3">FusionCharts XT will load here!</div>
							<div id="div_list6" class="mt20">
								<h4>기술분류별 연도별 분석 (소분류)</h4>
								<table id=tbl_list6 class="mt10 w98">
									<colgroup>
										<col width="120"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
										<col width="60"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">소분류</th>
											<th scope="col" colspan="5">연도</th>
											<th scope="col" rowspan="2">계</th>
										</tr>
										<tr>
											<th scope="col">1</th>
											<th scope="col">2</th>
											<th scope="col">3</th>
											<th scope="col">4</th>
											<th scope="col">5</th>
										</tr>
									</thead>
									<tbody>
									</tbody>							
								</table>
							</div>
							<div class="mt10">
								선택
								<select id="chartList6">
									<option value="MSColumn3D">MSColumn3D</option>
									<option value="MSColumn2D">MSColumn2D</option>
									<option value="MSLine">MSLine</option>
									<option value="MSBar3D">MSBar3D</option>
									<option value="MSBar2D">MSBar2D</option>
									<option value="MSArea">MSArea</option>
								</select>
							</div>
							<div class="mt10 w98" id="chartContainer6">FusionCharts XT will load here!</div>
						</div>
					</div>
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>