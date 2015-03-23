<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top_popup.jsp" %>


<style>
.layerPopup.wid2{
	box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-box-sizing:border-box;
	width:100%;
	background-color: white;
}
input[type="password"] {
	border: 1px solid #bebebe;
	background: #fff;
	vertical-align: middle;
	padding: 2px 5px 3px;
	text-align: left;
}
</style>

<script type="text/javascript">
var LoginDlg = function(data, fnOkCallback, fnCloseCallback){
	
	var login = function() {
		
		if($('#user_id').val().trim() == "") {
			alert("사용자 아이디를 입력하여 주세요.");
			$('#user_id').focus();
			return;
		}
		
		if($('#password').val().trim() == "") {
			alert("사용자 비밀번호를 입력하여 주세요.");
			$('#password').focus();
			return;
		}
		
		var oJson = new Object();
		oJson.ID = $('#user_id').val();
		oJson.PASSWORD = $('#password').val();
		oJson.DATA = data;
		var strParam = "JSON="+Common.stringify(oJson);
		$.ajax({
			url : "/login.do",
			type : "POST",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					fnOkCallback();
				} else {
					if(data.RESULT_CD == "ERR_0011") {
						alert(data.RESULT_MSG);
						$('#user_id').focus();
					}
				} 
			}
		});
	};
	
	{
		$('#btn_login').bind('click', function(){
			event.preventDefault();
			login();
		});
		$('#btn_close').bind('click', function(event){
			event.preventDefault();
			fnCloseCallback();
		});
		$('#password').bind('keyup', function(event){
			if(event.keyCode == 13){
				login();
			}
		});
		
		$('#user_id').focus();
	}
};



(function($){
	$(document).ready(function(){
	});	
	
})(jQuery);
</script>

<!-- layer popup 삽입시작 -->
<div class="layerPopup wid2" id="pop_search1" style="display:block;">
	<!-- header -->
	<div class="pHeader">
		<h2>로그인</h2>
	</div>
	<!-- //header -->
 
	<!-- contents -->
	<div class="pContents">
		<form>
			<fieldset>
				<p class="logtxt">로그인이 필요한 서비스 입니다.<br />
					로그인 하신 후 이용해 주세요.</p>
				<div class="popLogin">
					<ul>
						<li>
							<label for="user_id">아이디</label>
							<input type="text" id="user_id" placeholder="아이디" />
						</li>
						<li>
							<label for="password">비밀번호</label>
							<input type="password" id="password" placeholder="비밀번호" />
						</li>
					</ul>
					<span><a href="#" class="btnLogin1" id="btn_login" ><img src="/resources/images/main/btn_login.gif" alt="로그인" /></a></span>
					<div class="loinmm" style="display:none;">
						<span class="left"><a href="">회원가입</a></span>
						<span class="right"><a href="">아이디/비밀번호찾기</a></span>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<a href="#" id="btn_close" class="btnPoGray">닫기</a>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->

<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>