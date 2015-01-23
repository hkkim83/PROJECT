<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
.layer_dialog{
	display:none;z-index:50;position:absolute;top:0px;left:0px;width:100%;height:100%;background-color:rgba(0, 0, 0, 0.6);
}
.layer_dialog iframe{
	position:absolute;
	top:200px;
	width:980px;
	height:700px;
	z-index:10;
	border:none;
}
</style>

<script type="text/javascript">
<!--
//-->
(function($){
	
	var trCnt = 0;
	var tdCnt = 0;

	// 요지리스트 팝업 호출
	var openDialog = function(patentId) {
		var projectId = $('#loginProjectList option:selected').val();
		
		var $dialog = $('#dlg_summary_dlg');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		
		new dialogWin.SummaryDlg(projectId, patentId, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();
	};
	
	// 중분류 리스트 가져오기
	var makeTable = function(mcate1, mcate2) {
		var colgroup = "<colgroup><col width='10%'/>";
		trCnt = mcate1.length+2;
		tdCnt = mcate2.length+2;
		for(var i=0; i<tdCnt-1; i++) {
			colgroup += "<col width='"+90/(tdCnt-1)+"%'/>";
		}
		colgroup += "</colgroup>";
		$('#tbl_matrix').append(colgroup);
		
		for(var i=0; i<trCnt; i++) {
			if(i == 0)
				$('#tbl_matrix').append('<thead><tr></tr></thead>');
			else 
				$('#tbl_matrix').append('<tr></tr>');
				
			var $tr = $('#tbl_matrix tr').eq(i);
			for(var j=0; j<tdCnt; j++) {
				if(i== 0) {
					if(j == 0) {
						$tr.append('<th scope="col"><p>중분류</p></th>');
					} else if(j == (tdCnt-1)) {
						$tr.append('<th scope="col" name="미분류1"><p>미분류</p></th>');
					} else {
						$tr.append('<th scope="col" name="'+mcate2[j-1].MCATE+'"><p>'+mcate2[j-1].MCATE+'</p></th>');
					} 
				} else if(j == 0) {
					if(i == (trCnt-1)) {
						$tr.append('<th scope="row" name="미분류2"><p>미분류</p></th>');
					} else {
						$tr.append('<th scope="row" name="'+mcate1[i-1].MCATE+'"><p>'+mcate1[i-1].MCATE+'</p></th>');
					}
				} else {
					$tr.append('<td></td>');
				}
			}
		}
		
	};
	
	var lenArr = [0, 0, 0, 0, 28, 20, 10, 6, 4];	// td개수에 따른 출원인 글자수
	var idx = 0;
	// 테이블 데이터 채우기
	var setData = function($tr, index, applNum, applicant, patentId, grade) {
		var $td = $('td:eq('+index+')', $tr);
		// 기존에 데이터가 있다면 건너뜀.
		if($td.text().indexOf(applNum) > -1 ) return;
		++idx;
		
		// 출원인 글자수가 많으면 말줄임한다. 테이블 개수에 따라 사이즈 조절
		if(tdCnt <= 8 && tdCnt > 3)
			applNum = applNum+"("+applicant.cut(lenArr[tdCnt])+")";
		else if(tdCnt <= 3) 
			applNum = applNum+"("+applicant+")";
		
		if(grade == "S")
			applNum = "<font color='red'>"+applNum+"</font>";
			
		var newStr = "<a href='#'><p id='APPL_NUM"+idx+"'>"+applNum+"</p></a>";
		$td.append(newStr);
		$td.find('p[id=APPL_NUM'+idx+']').bind('click', function(event){
			event.preventDefault();
			openDialog(patentId);
		});
	};

	// 테이블 데이터 채우기
	var setContent = function(osmatrix1, osmatrix2) {
		var index = 0;
		// 목적/효과, 기능 기준
		$.each(osmatrix1, function(i){
			$tr = $('th[name="'+osmatrix1[i].MCATE+'"]').parent();
			var cnt = 0;
			$.each(osmatrix2, function(j){
				// 목적/효과, 기준와 그외 중분류 비교
				// 행과 열에 일치하는 데이터가 존재하면 해당 cell에 데이터 채움
				if(osmatrix1[i].PATENT_ID == osmatrix2[j].PATENT_ID) {
					$th = $('th[name="'+osmatrix2[j].MCATE+'"]');
					index = $('#tbl_matrix tr:eq(0) th').index($th);
					setData($tr, index-1, osmatrix1[i].APPL_NUM, osmatrix1[i].APPLICANT, osmatrix1[i].PATENT_ID, osmatrix1[i].GRADE);
					cnt ++;
				}
			});
			// 일치하지 않으면 미분류에 채움
			var index = $('#tbl_matrix tr:eq(0)').children().size()-1;
			if(cnt < 1) setData($tr, index-1, osmatrix1[i].APPL_NUM, osmatrix1[i].APPLICANT, osmatrix1[i].PATENT_ID, osmatrix1[i].GRADE);
		});
		
		// 그외
		$.each(osmatrix2, function(i){
			$th = $('th[name="'+osmatrix2[i].MCATE+'"]');
			var $tr = $('#tbl_matrix tr:last');
			var cnt = 0;
			$.each(osmatrix1, function(j){
				// 행과 열에 일치하는 데이터가 존재하면 건너뜀
				if(osmatrix2[i].PATENT_ID == osmatrix1[j].PATENT_ID) {
					cnt ++;
				}
			});
			// 일치하지 않으면 미분류에 채움
			var index = $('#tbl_matrix tr:eq(0) th').index($th);
			if(cnt < 1) setData($tr, index-1, osmatrix2[i].APPL_NUM, osmatrix2[i].APPLICANT, osmatrix2[i].PATENT_ID, osmatrix2[i].GRADE);
		});
	};
	
	// 리스트 조회
	var search = function() {
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : "/OSMatrix/list.do",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					makeTable(data.MCATE_LIST1, data.MCATE_LIST2);			// 테이블 만들기
					setContent(data.OSMATRIX_LIST1, data.OSMATRIX_LIST2);	// 데이터 채우기
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});
	};
	
	// 엑셀 다운로드
	var download = function(filePath, fileName) {
		location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
	};
	
	// 데이터 직렬화
	var serialize = function() {
		var data = new Array();
		$('#tbl_matrix tr').each(function() {
			var object = new Object();
			var nodes = $(this).children();	
			nodes.each(function(index) {
				var str = "";
				$('p', $(this)).each(function() {
					str += 	$(this).text() + "<br>";
				});
				object[index] = str;
			});
			data.push(object);
		});
		return Common.stringify(data);
	};
	
	// 다운로드버튼 클릭시
	var saveExcel = function(strParam) {
		var strParam = "DATA="+serialize();
		$.ajax({
			url : '/OSMatrix/saveExcel.do',
			data : strParam,
			dataType: 'json',
			success: function( data ) {
		        //통신이 완료된 후 처리
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
		$('#tbl_matrix').html('');
		
		$('#btnDownload').bind('click'   , function(event) {
			event.preventDefault();
			saveExcel();
		});

		search();
		
	});
	
})(jQuery);
</script>
<div id="dlg_summary_dlg" class="layer_dialog">
  <iframe src="/patent/summaryDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
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
						<h3><img src="/resources/images/common/h3_03_2.png" alt="OS Matrix"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터분석</li>
								<li><strong>OS Matrix</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->

					<!-- list -->
					<div class="bbsContes">
						<div class="btnArea right">
							<a id="btnDownload" href="#" class="btntype5"><span>Download</span></a>
							<form name="form" method="POST">
								<input type="hidden" id="excelsource"> 
								<input type="hidden" id="excelfilename">
							</form>
						</div>
						<div id="div_matrix" class="tbl_bbs1">
							<table id="tbl_matrix" summary="출원일자,공개일자,검토결과,검토구분">
							</table>
						</div>
					</div>
					<!-- //list -->

				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>