<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<script type="text/javascript">
<!--
//-->
(function($){
	var List1 = {};
	var List2 = {};
	// 그리드 초기화
	var initGrid1 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = ["NO"		,"NO"			,"30"	,"center"	,"ro"	,"int"	,"false"];
	    arr[idx++] = [""  		,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["출원인"    ,"APPLICANT"	,"400"	,"left"		,"rotxt","str"	,"false"];
	    arr[idx++] = ["출원인대표명","RE_APPLICANT"	,"*"	,"left"		,"edtxt","str"	,"false"];
	    
		List1 = new CommonGrid('gridList1', arr);
		List1.grid.attachEvent("onKeyPress",function(code,ctrl,shift){ onKeyPressed(code,ctrl,shift, List1); }); 

	};
	
	// 그리드 초기화
	var initGrid2 = function() {
		var idx = 0;
		var arr = new Array();
		arr[idx++] = [""		,"CHK"			,"30"	,"center"	,"ch"	,"str"	,"false"];
	    arr[idx++] = [""  		,"PROJECT_ID"	,"0"	,"left"		,"ro"	,"str"	,"false"];
	    arr[idx++] = ["출원인"    ,"APPLICANT"	,"400"	,"left"		,"rotxt","str"	,"false"];
	    arr[idx++] = ["출원인대표명","RE_APPLICANT"	,"*"	,"left"		,"edtxt","str"	,"false"];
	    
		List2 = new CommonGrid('gridList2', arr);
		List2.grid.attachEvent("onRowDblClicked", function(rId,cInd){ saveAuth(List2, rId, "0");});  
		List2.grid.attachEvent("onKeyPress",function(code,ctrl,shift){ onKeyPressed(code,ctrl,shift, List2); }); 
		List2.dp.setDataColumns([false,false,false,true]);
	};
	
	// 저장 데이터셋 초기화
	var clearData = function() {
		List1.dp.updatedRows=[];
		List1.dp._in_progress={};
		List2.dp.updatedRows=[];
		List2.dp._in_progress={};				
	};
	
	// Ctrl+C 클릭시 클립보드 저장
	function onKeyPressed(code,ctrl,shift, obj){
		if(code==67&&ctrl){
			obj.grid.cellToClipboard();
		}
		return true;
	}
	
	// 리스트 조회
	var searchList = function() {
		List1.grid.clearAll();
		List2.grid.clearAll();
		var projectId = $('#loginProjectList option:selected').val();
		var strParam = "PROJECT_ID="+projectId;
		$.ajax({
			url : '/applicant/list.do',
			data : strParam,
			cache : false,
			success : function(data) {
				List1.parse(data.CMPL_LIST);
				List2.parse(data.INCMPL_LIST);
				$('#txtReName').val("");
			}
		});		
	};
	
	// 정합성 체크
	var checkVal = function(obj) {
		
		if(!obj.isUpdated()) {
			alert("저장할 데이터가 존재하지 않습니다. 다시 확인해보시기 바랍니다.");
			return false;			
		}
		
		return confirm("저장하시겠습니까?");		
	};
	
	// 저장버튼 클릭시
	var save = function(obj, status) {
		if(obj.grid.getSelectedId() != null)
			obj.dp.setUpdated(obj.grid.getSelectedId(), true);
		
		if(!checkVal(obj)) return;
	
		var strParam = "DATA="+obj.serialize(status);
		$.ajax({
			url : '/applicant/save.do',
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
				clearData();
				if(data.RESULT_CD == "SUCC_0001")
					searchList();
			}
		});		
	};
	
	// 입력버튼 클릭시
	var setApplicant = function() {
		for(var i=0; i<List2.grid.getRowsNum(); i++) {
			var rowId = List2.grid.getRowId(i);
			if(List2.grid.cells(rowId, 0).getValue() == "1") {
				List2.grid.cells(rowId, List2.grid.getColIndexById("RE_APPLICANT")).setValue($('#txtReName').val());
				List2.dp.setUpdated(rowId, true);
			}
		} 
	};

	// 화면 로딩시
	$(document).ready(function(){
		$('#btnSetApplicant').bind('click', function(e){
			e.preventDefault();
			setApplicant();
		});

		$('#btnSave1').bind('click', function(e){
			e.preventDefault();
			save(List1, "UPDATE");
		});
		
		$('#btnSave2').bind('click', function(e){
			e.preventDefault();
			save(List2, "INSERT");
		});
		
		initGrid1();
		initGrid2();
		
		// 조회실행
		searchList();
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
						<h3><img src="/resources/images/common/h3_02_2.png" alt="대표명화관리"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li>데이터가공</li>
								<li><strong>대표명화관리</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<div class="searchResults">
						<div class="savebtn1">
							<div class="btnArea left">
								<h4>대표명화 (완료)</h4>
							</div>
							<div class="btnArea right">
								<a href="#" class="btntype4" id="btnSave1"><span>저장</span></a>
						 	</div>
						</div>
						<div id="gridList1" class="mt10 mb20" style="background-color:white; width:100%; height:200px;"></div>
						<div class="savebtn">
							<div class="btnArea left">
								<h4>대표명화 대상</h4>
						  	</div>
						  	<div class="btnArea right">
						  		<a href="#" class="btntype4" id="btnSave2"><span>저장</span></a>
						  	</div>
						</div>						
						<div class="expression">
							<p class="right1">
								<span class="green">선택 출원인 대표명 일괄입력</span>&nbsp;
								<input type="text" id="txtReName" placeholder="대표명 입력 칸" title="대표명 입력 칸" class="w50" autofocus/>
								<a href="#" class="btnSmall gray" id="btnSetApplicant">입력</a>
							</p>
						</div>
						<div id="gridList2" class="mt10" style="background-color:white; width:100%; height:200px;"></div>
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