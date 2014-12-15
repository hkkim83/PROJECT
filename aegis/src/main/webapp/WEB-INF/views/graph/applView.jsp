<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<script type="text/javascript">
<!--
//-->
(function($){
	var $div = null;
	// 차트변경 선택시
	var changeChart = function(obj) {
		var value = $('option:selected', obj).val();
		var $chartContainer = obj.parent().next();
		$chartContainer.updateFusionCharts({"swfUrl": "/resources/FusionCharts/"+value+".swf"});
	};
	
	// XML 만들기
	var makeChartXML = function(title, xAxis, yAxis, data) {	
		var str = "<chart caption='"+title+"' xAxisName='"+xAxis+"' yAxisName='"+yAxis+"' numberSuffix='건'>\n";
		
		for(var i=0; i<data.length; i++) {
			var map = data[i];
			str += "\t<set label='"+map["APPLICANT"]+"' value='"+map["T_GRADE"]+"' link='newchart-xml-"+i+"-detail'/>\n";					
		}
		
		for(var i=0; i<data.length; i++) {
			var map = data[i];
			str += "\t<linkeddata id='"+i+"-detail'>\n";
			str += "\t\t<chart caption='출원인별 등급별 특허현황' subcaption='("+map["APPLICANT"]+")' xAxisName='등급' yAxisName='특허건수'>\n";
			str += "\t\t\t<set label='S' value='"+map["S_GRADE"]+"'/>\n";				
			str += "\t\t\t<set label='A' value='"+map["A_GRADE"]+"'/>\n";				
			str += "\t\t\t<set label='B' value='"+map["B_GRADE"]+"'/>\n";				
			str += "\t\t\t<set label='C' value='"+map["C_GRADE"]+"'/>\n";			
			str += "\t\t\t<set label='미부여' value='"+map["N_GRADE"]+"'/>\n";
			str += "\t\t</chart>\n";
			str += "\t</linkeddata>\n";
		}

		str += "</chart>";
		return str;
	};
	
	// 테이블 만들기
	var makeTable = function(data) {
		var listArr = ["LIST_ALL", "LIST_KR", "LIST_US", "LIST_JP", "LIST_EP", "LIST_CN", "LIST_PCT"];
		var nameArr = ["전체", "한국", "미국", "일본", "유럽", "중국", "PCT"];

		for(var i=0; i<listArr.length; i++) {
			var list = data[listArr[i]];
			
			if(list.length < 1) continue;
			var $divTbl = $div.clone();
			$divTbl.attr("id", "div_list"+i);
			$('#div_bbs').append($divTbl);
			$('h4', $divTbl).html("출원인별 등급별 분석("+nameArr[i]+")");
			for(var j=0; j<list.length; j++) {
				$('table', $divTbl).append('<tr></tr>');
				var map = list[j];
				var $tr = $('table tr', $divTbl).eq(j+2);
				$tr.append("<td>"+map["APPLICANT"]+"</td>");
				$tr.append("<td align='right'>"+map["S_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["A_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["B_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["C_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["N_GRADE"]+"</td>");
				$tr.append("<td align='right'>"+map["T_GRADE"]+"</td>");
			}
			$('div:last-child', $divTbl).attr("id", "chartContainer"+i).insertFusionCharts({
				swfUrl: "/resources/FusionCharts/Column3D.swf", 
				dataSource: makeChartXML("출원인별 등급별 분석("+nameArr[i]+")", "출원인", "특허건수", list), 
				dataFormat: "xml", 
				width: "100%", 
				height: "300", 
				id: "myChartId"+i
			});
			$('select', $divTbl).bind('change', function() {
				changeChart($(this));
			});
		}
	};
	
	// 리스트 조회
	var search = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : "/graph/applList.do",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					//makeChart("국가별 등급별 분석", "국가", "특허건수", data.LIST);
					makeTable(data);
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		$div = $('#div_list').remove();
		search();
		
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
						<div id="div_bbs">
							<div id="div_list" class="tbl_bbs11 mt20">
								<h4>출원인별 등급별 분석(전체)</h4>
								<table class="mt10 w98">
									<colgroup>
										<col width="60%"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
										<col width="50"/>
									</colgroup>
									<thead>
										<tr>
											<th scope="col" rowspan="2">출원인</th>
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
								<div class="mt10">
									선택	
									<select id="chartList">
										<option value="Column3D">Column3D</option>
										<option value="Column2D">Column2D</option>
										<option value="Line">Line</option>
										<option value="Area2D">Area2D</option>
										<option value="Bar2D">Bar2D</option>
										<option value="Pie3D">Pie3D</option>
										<option value="Pie2D">Pie2D</option>
										<option value="Doughnut3D">Doughnut3D</option>
										<option value="Doughnut2D">Doughnut2D</option>
									</select>
								</div>
								<div class="mt10 w98">FusionCharts XT will load here!</div>
							</div>
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