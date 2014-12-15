<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>
<style>
<!--
.totalcolor {background-color:#b0e0e6;}
.normalcolor {background-color:#ffffff;}
-->
</style>
<script type="text/javascript">
<!--
//-->
(function($){
	
	// 테이블 만들기
	var makeTable = function(data) {
		for(var i=0; i<data.length; i++) {
			$('#tbl_list').append('<tr></tr>');
			var map = data[i];
			var $tr = $('#tbl_list tr').eq(i+2);
			if(map["NATL_NAME"] == "계")
				$tr.addClass("totalcolor");
			else 
				$tr.addClass("normalcolor");
			
			$tr.append("<td>"+map["NATL_NAME"]+"</td>");
			$tr.append("<td align='right'>"+map["S_GRADE"]+"</td>");
			$tr.append("<td align='right'>"+map["A_GRADE"]+"</td>");
			$tr.append("<td align='right'>"+map["B_GRADE"]+"</td>");
			$tr.append("<td align='right'>"+map["C_GRADE"]+"</td>");
			$tr.append("<td align='right'>"+map["N_GRADE"]+"</td>");
			$tr.append("<td align='right'>"+map["T_GRADE"]+"</td>");
		}
	};
	
	// XML 만들기
	var makeChartXML = function(title, xAxis, yAxis, data) {	
		var str = "<chart caption='"+title+"' xAxisName='"+xAxis+"' yAxisName='"+yAxis+"' numberSuffix='건'>\n";
		
		for(var i=0; i<data.length-1; i++) {
			var map = data[i];
			str += "\t<set label='"+map["NATL_NAME"]+"' value='"+map["T_GRADE"]+"' link='newchart-xml-"+i+"-detail'/>\n";					
		}
		
		for(var i=0; i<data.length-1; i++) {
			var map = data[i];
			str += "\t<linkeddata id='"+i+"-detail'>\n";
			str += "\t\t<chart caption='해결수단 등급별 특허현황' subcaption='("+map["NATL_NAME"]+")' xAxisName='등급' yAxisName='특허건수' numberSuffix='건'>\n";
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

	// 차트 만들기
	var makeChart = function(title, xAxis, yAxis, data) {
		 $("#chartContainer").insertFusionCharts({
            swfUrl: "/resources/FusionCharts/Pie3D.swf", 
            dataSource: makeChartXML(title, xAxis, yAxis, data), 
            dataFormat: "xml", 
            width: "100%", 
            height: "300", 
            id: "myChartId"
      });
	};
	
	// 리스트 조회
	var search = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : "/graph/gradeList.do",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					makeChart("국가별 등급별 분석", "국가", "특허건수", data.LIST);
					makeTable(data.LIST);
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 차트 변경 선택시
	var changeChart = function() {
		var value = $('#chartList option:selected').val();
		$("#chartContainer").updateFusionCharts({"swfUrl": "/resources/FusionCharts/"+value+".swf"});
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		
		search();
		
		$('#chartList').on('change', function() {
			changeChart();
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
						<div class="tbl_bbs11">
							<h4>국가별 등급별 분석</h4>
							<table id="tbl_list" class="mt10 w55">
								<colgroup>
									<col width="60"/>
									<col width="50"/>
									<col width="50"/>
									<col width="50"/>
									<col width="50"/>
									<col width="50"/>
									<col width="50"/>
								</colgroup>
								<thead>
									<tr>
										<th scope="col" rowspan="2">국가</th>
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
							<select id="chartList">
								<option value="Pie3D">Pie3D</option>
								<option value="Pie2D">Pie2D</option>
								<option value="Doughnut3D">Doughnut3D</option>
								<option value="Doughnut2D">Doughnut2D</option>
								<option value="Column3D">Column3D</option>
								<option value="Column2D">Column2D</option>
								<option value="Line">Line</option>
								<option value="Area2D">Area2D</option>
								<option value="Bar2D">Bar2D</option>
							</select>
						</div>
						<div class="mt10 w55" id="chartContainer">FusionCharts XT will load here!</div>
					</div>
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>