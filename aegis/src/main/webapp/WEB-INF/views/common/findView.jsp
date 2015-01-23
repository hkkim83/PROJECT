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
	width:500px;
	height:500px;
	z-index:10;
	border:none;
}

</style>

<script type="text/javascript">
<!--
//-->
(function($){
	
	var checkVal = function(str) {
		var ret = true;
		
		$('input[id^='+str+']').each(function(){
			if($(this).val() == "") {
				var colName = $('label[for*='+$(this).attr('id')+']').eq(0).text();
				alert(colName+"은 필수 입력입니다.");
				$(this).focus();
				ret = false;
				return false;
			}
		});
		return ret;
	};
	
	var openFindPW = function(data) {
		var $dialog = $('#dlg_find');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		var fnOkCallback = function(){
			$dialog.hide();
			location.href = "/index.do";
		};
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		new dialogWin.FindDlg(data, fnOkCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();				
	};
	
	var serialize = function(str) {
		var data = new Object();
		$('input[id^='+str+']').each(function(){
			var id = $(this).attr('id');
			data[id.substring(3)] = $(this).val();
		});
		return Common.stringify(data);
	};
	
	var findID = function(str) {
		if(!checkVal(str)) return;
		var strParam = "DATA="+serialize(str);
		$.ajax({
			url : '/findID.do',
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					if(str == "ID")
						alert("관리자 ID는 "+data.ID+"입니다.");
					else 
						openFindPW(data.ID);
				}
				else 
					alert(data.RESULT_MSG);
			}
		});		
	};
	
	$(document).ready(function(){
		$('#btnFindID').bind('click', function() {
			findID("ID");
		});
		$('#btnFindPW').bind('click', function() {
			findID("PW");
		});
		
	});
	
})(jQuery);
</script>
<div id="dlg_find" class="layer_dialog">
  <iframe src="/findDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
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
						<h3><img src="/resources/images/common/h3_login_2.png" alt="아이디/비밀번호찾기"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li><strong>아이디/비밀번호찾기</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 아이디  -->
					<div class="searchResults">
						<div class="leftConts">
							<div class="savebtn1">
								<div class="btnArea left">
									<h4>아이디 찾기</h4>
								</div>
								<div class="btnArea right">
									<button type="button" class="btnSmall green" id="btnFindID">찾기</button>
							 	</div>
							</div>							
							<form name="" method="post">
								<fieldset>
								<div class="idpBox">
									<ul>
										<li>
											<label for="ID_COMPANY">회사명</label>
											<input type="text" id="ID_COMPANY" class="w60" autofocus/>
										</li>
										<li>
											<label for="ID_BIZ_NO1ID_BIZ_NO2ID_BIZ_NO3">사업자등록번호</label>
											<input type="text" id="ID_BIZ_NO1" class="w15" /> -
											<input type="text" id="ID_BIZ_NO2" class="w10" /> -
											<input type="text" id="ID_BIZ_NO3" class="w20" />
										</li>
										<li>
											<label for="ID_NAME">관리자 이름</label>
											<input type="text" id="ID_NAME" class="w60" />
										</li>
										<li><br><br></li>
									</ul>
								</div>
								</fieldset>
							</form>
							<p class="logTxt">가입정보로 아이디를 찾을수 있습니다.</p>
						</div>
						<div class="rightConts">
							<div class="savebtn1">
								<div class="btnArea left">
									<h4>비밀번호 재설정</h4>
								</div>
								<div class="btnArea right">
									<button type="button" class="btnSmall green" id="btnFindPW">재설정</button>
							 	</div>
							</div>						
							<form name="" method="post">
								<fieldset>
								<div class="idpBox">
									<ul>
										<li>
											<label for="PW_COMPANY">회사명</label>
											<input type="text" id="PW_COMPANY" class="w60" />
										</li>
										<li>
											<label for="PW_BIZ_NO1PW_BIZ_NO2PW_BIZ_NO3">사업자등록번호</label>
											<input type="text" id="PW_BIZ_NO1" class="w15" /> -
											<input type="text" id="PW_BIZ_NO2" class="w10" /> -
											<input type="text" id="PW_BIZ_NO3" class="w20" />
										</li>
										<li>
											<label for="PW_ID">관리자 ID</label>
											<input type="text" id="PW_ID" class="w60" />
										</li>
										<li>
											<label for="PW_NAME">관리자이름</label>
											<input type="text" id="PW_NAME" class="w60" />
										</li>
									</ul>
								</div>
								</fieldset>
							</form>
							<p class="logTxt">가입정보로 비밀번호를 재설정할 수 있습니다.</p>
						</div>
					</div>
					<!-- //아이디/비밀번호 재설정 -->

					<div class="join_info">
						<p class="clrBlue">AEGIS 시스템의 각 회사 관리자 아이디찾기/비밀번호 재설정 화면입니다.<br />
							회사 관리자가 설정한 사용자 정보를 찾기 원하시는 분은 사내 담당자에게 문의하세요.</p>
						<p>문의전화 : 070-8891-6347(직통), 02-562-1716(대표전화) [ 전화상담 운영시간 (평일) 09:00 ~ 18:00 ],  이메일 : chyim@airsgroup.com</p>
					</div>

				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>