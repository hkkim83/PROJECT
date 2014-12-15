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
		var start = new Date().getYear()+1900 - 21;
		var $nodes = $('#tbl_list tr').children();
		$nodes.each(function(index) {
			if(index != 0) {
				var str = start+index;
				if(index == 1) 
					str = "~" + str;
				else if(index == $nodes.size()-1)
					str = "계";
				$(this).text(str);
			}
			
		});
		
		for(var i=0; i<data.length; i++) {
			$('#tbl_list').append('<tr></tr>');
			var map = data[i];
			var $tr = $('#tbl_list tr').eq(i+1);
			if(map["NATL_NAME"] == "계")
				$tr.addClass("totalcolor");
			else 
				$tr.addClass("normalcolor");
			
			$tr.append("<td>"+map["NATL_NAME"]+"</td>");
			var size = 0;
			$.each(map, function(index) {
				size++;
			});
			
			for(var j=0; j<size-1; j++) {
				$tr.append("<td align='right'>"+map["CUR_"+(j+1)]+"</td>");					
			}
		}
	};
	
	// XML 만들기
	var makeChartXML = function(title, xAxis, yAxis, data) {	
		var str = "<chart caption='"+title+"' xAxisName='"+xAxis+"' yAxisName='"+yAxis+"' numberSuffix='건'>\n";
		
		for(var i=0; i<data.length-1; i++) {
			var map = data[i];
			var size = 0;	
			$.each(map, function(index) {
				size++;
			});
			
			// 카테고리를 만든다.
			if(i == 0) {
				str += "\t<categories>\n";
				var start = new Date().getYear()+1900 - 21;
				for(var j=1; j<size-1; j++) {
					var year = start+j;
					str += "\t\t<category Label='"+(year+"").substring(2)+"'/>\n";			
				}	
				str += "\t</categories>\n";
			}
			
			str += "\t<dataset seriesName='"+map["NATL_NAME"]+"'>\n";

			
			for(var j=0; j<size-2; j++) {	
				str += "\t\t<set value='"+map["CUR_"+(j+1)]+"'/>\n";					
			}			
			str += "\t</dataset>\n";			
		}
		str += "</chart>";
		return str;
	};
	
	// 차트 만들기
	var makeChart = function(title, xAxis, yAxis, data) {
		 $("#chartContainer").insertFusionCharts({
             swfUrl: "/resources/FusionCharts/MSLine.swf", 
             dataSource: makeChartXML(title, xAxis, yAxis, data), 
             dataFormat: "xml", 
             width: "100%", 
             height: "400", 
             id: "myChartId"
       });
	};
	
	// 리스트 조회
	var search = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : "/graph/yearList.do",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					makeChart("국가별 연도별 분석", "연도", "특허건수", data.LIST);
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
							<h4>국가별 연도별 분석</h4>
							<table id="tbl_list" class="mt10 w98">
								<colgroup>
									<col width="8%" />
									<col span="22" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col">국가/연도</th>
										<th scope="col">2001</th>
										<th scope="col">2002</th>
										<th scope="col">2003</th>
										<th scope="col">2004</th>
										<th scope="col">2005</th>
										<th scope="col">2006</th>
										<th scope="col">2007</th>
										<th scope="col">2008</th>
										<th scope="col">2009</th>
										<th scope="col">2010</th>
										<th scope="col">2011</th>
										<th scope="col">2012</th>
										<th scope="col">2013</th>
										<th scope="col">2014</th>
										<th scope="col">2015</th>
										<th scope="col">2016</th>
										<th scope="col">2017</th>
										<th scope="col">2018</th>
										<th scope="col">2019</th>
										<th scope="col">2020</th>
										<th scope="col">2021</th>
										<th scope="col">계</th>
									</tr>
								</thead>
								<tbody>
								</tbody>							
							</table>
						</div>
						<div class="mt10">
							선택
							<select id="chartList">
								<option value="MSLine">MSLine</option>
								<option value="MSColumn3D">MSColumn3D</option>
								<option value="MSColumn2D">MSColumn2D</option>
								<option value="MSBar3D">MSBar3D</option>
								<option value="MSBar2D">MSBar2D</option>
								<option value="MSArea">MSArea</option>
							</select>
						</div>
						<div class="mt10 w98" id="chartContainer">FusionCharts XT will load here!</div>    
					</div>
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->	      

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>