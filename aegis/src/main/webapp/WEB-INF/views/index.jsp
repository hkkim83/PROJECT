<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.co.aegis.dto.User, java.util.Map, java.util.List"%>
<%@ page import="kr.co.aegis.controller.BoardController"%>
<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
.swipe {
	overflow: hidden;
	visibility: hidden;
	position: relative;
}
.swipe-wrap {
	overflow: hidden;
	position: relative;
}
.swipe-wrap > div {
	float:left;
	width:100%;
	position: relative;
}
input[type="password"] {
	border: 1px solid #bebebe;
	background: #fff;
	vertical-align: middle;
	padding: 2px 5px 3px;
	text-align: left;
}
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

<script type="text/javascript" src="/resources/js/swipe.js"></script>
<script>
// 파일 다운로드
var downloadFile = function(filePath) {
	var pos = filePath.lastIndexOf("/");
	var fileName = filePath.substring(pos+1);
	location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
};

(function($){
	
	// 로그인 처러
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
		var strParam = "JSON="+Common.stringify(oJson);
		$.ajax({
			url : "/login.do",
			type : "POST",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					location.href = "/index.do";
				} else {
					if(data.RESULT_CD == "ERR_0011") {
						alert(data.RESULT_MSG);
						$('#user_id').focus();
					}
				} 
			}
		});
	};
	
	// 보드 상세팝업
	var openDialog = function(dlg, data) {
		var $dialog = $(dlg);
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		
		// 팝업 위치 오픈 위치 추가
		data["STATUS"] = "UPDATE";
		data["WHERE"]  = "INDEX";
		
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		
		var fnOkCallback = function() {
			$dialog.hide();
			dialogWin.location.reload();
		};

		new dialogWin.BoardDlg(data, fnOkCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();		
	};
	
	// 보드리스트 조회
	var boardList = function() {
		var strParam = "";
		$.ajax({
			url : "/board/boardList.do",
			type : "POST",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD == "SUCC_0001") {
					$.each(data.NLIST, function(index) {	
						var map = this;
						var innerHTML = '<a href="#">'+this['TITLE']+'</a>';
						var filePath = this['FILE_PATH'];
						if(filePath != '' && filePath != null) {
							innerHTML += '&nbsp;<a href="javascript:downloadFile(\''+filePath+'\')"><img src="/resources/images/common/ico_file.gif"></a>';
						}
						$('#nList>li:eq('+index+')').html(innerHTML).bind('click', function() {
							openDialog('#dlg_notice_rgs', map);
						});
					});
					$.each(data.QLIST, function(index) {
						var map = this;
						var innerHTML = '<a href="#">'+this['TITLE']+'</a>';
						$('#qList>li:eq('+index+')').html(innerHTML).bind('click', function() {
							openDialog('#dlg_qna_rgs', map);
						});
					});						
					$.each(data.FLIST, function(index) {
						var map = this;
						var innerHTML = '<a href="#">'+this['TITLE']+'</a>';
						$('#fList>li:eq('+index+')').html(innerHTML).bind('click', function() {
							openDialog('#dlg_faq_rgs', map);
						});
					});						
				} 
			}
		});		
	};
	
	$(document).ready(function(){
		
		$('#user_id').watermark('아이디');
		$('#password').watermark('비밀번호');
		
		// 보드탭 클릭시
		$('.notice .mainTab a').bind('click', function(event){
			event.preventDefault();
			$('.notice .mainTab a').removeClass('on');
			$(this).addClass('on');
			var idx = $('.notice .mainTab a').index(this);
			$('.notice > div').hide();
			$('.notice > div').eq(idx).show();
		});
		
		// 서비스 리스트  보여주기
		window.serviceSwipe = $('#serviceSwipe').Swipe().data('Swipe');
		var elem = document.getElementById('serviceSwipe');
		window.serviceSwipe = Swipe(elem, {
			callback: function(index, element) {
				$('#serviceSpot img').attr('src', '/resources/images/main/bul_won_off.gif');
				$('#serviceSpot img').eq(index).attr('src', '/resources/images/main/bul_won_on.gif');
			}
		});
		$('#serviceSpot a').bind('click', function(event){
			event.preventDefault();
			var idx = $('#serviceSpot a').index(this);
			serviceSwipe.slide(idx);
		});
		var rollServiceSwipe = function(){
			serviceSwipe.next();
		};
		setInterval(rollServiceSwipe, 5000);

		boardList();
		
		$('#password').bind('keyup', function(event){
			if(event.keyCode == 13){
				login();
			}
		});
		
		$(".btnLogin").on('click', function(event){
			event.preventDefault();
			login();
		});
		
		$("#btnJoin").on('click', function(event){
			location.href = '/join.do';
		});
		
		$("#btnFind").on('click', function(event){
			location.href = '/find.do';
		});
		
		$("#btnNotice").on('click', function(event){
			location.href = '/board/view.do';
		});
		
		$("#btnFaq").on('click', function(event){
			location.href = '/board/faqView.do';
		});
		
		$("#btnQna").on('click', function(event){
			location.href = '/board/qnaView.do';
		});
	});
	
})(jQuery);
</script>
<div id="dlg_notice_rgs" class="layer_dialog">
  <iframe src="/board/noticeRgsDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
<div id="dlg_qna_rgs" class="layer_dialog">
  <iframe src="/board/qnaRgsDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
<div id="dlg_faq_rgs" class="layer_dialog">
  <iframe src="/board/faqRgsDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
    <!-- container -->
    <div id="container"> 
        <!-- contents -->
		<div class="mainContants">
			<div class="contTop">
				<h2><img src="/resources/images/main/img_main.png" alt="AEGIS 특허분석시스템" /></h2>
			</div>
			<div class="contsMid">
			
			
<% if(user == null){ %>
				<!-- 로그인 -->
				<div class="mainLogin">
					<form action="">
						<fieldset>
							<ul>
								<li>
									<label for="user_id">아이디</label>
									<input id="user_id" type="text" autofocus/>
								</li>
								<li>
									<label for="password">비밀번호</label>
									<input id="password" type="password" />
								</li>
							</ul>
							<button id="btnLogin" type="button" class="btnLogin">로그인</button>
						</fieldset>
					</form>
					<div class="loinmm">
						<span class="left"><a href="#" id="btnJoin">회원가입</a></span>
						<span class="right"><a href="#" id="btnFind">아이디/비밀번호찾기</a></span>
					</div>
				</div>
				<!-- //로그인 -->
<% } %>				
				
				
				
				
				
				<!-- 공지사항 -->
				<div class="notice" style="height:auto;">
					<ul class="mainTab tab">
						<li>
						    <a href="#notice01"><img src="/resources/images/main/h3_notice.gif" width="58" height="16" alt="공지사항" /></a>
                        </li>
					</ul>

					<div>
						<h3 class="blind">공지사항</h3>
						<div id="notice01" class="noticeList inb_con active">
							<ul id="nList">
								<li></li>
								<li></li>
								<li></li>
								<li></li>
							</ul>
						</div>
						<span class="btnMore"><a href="#" id="btnNotice"><img src="/resources/images/main/btn_more.gif" alt="공지사항 더보기" /></a></span>
					</div>
				</div>
				<!-- //공지사항 -->




				<!-- 서비스 안내 -->
				<div class="mainServie">
					<h3><img src="/resources/images/main/h3_service.gif" width="71" height="16" alt="서비스안내" /></h3>
					<div id='serviceSwipe' class='swipe'>
					  <div class='swipe-wrap'>
							<div class="service-wrap">
								<ul class="servList">
									<li>
										<dl>
											<dt><img src="/resources/images/main/img_sevice.gif" alt="안내 이미지" /></dt>
											<dd>
												<p>
													<strong>서비스</strong>
													<span><a href=""><img src="/resources/images/main/btn_detail.gif" alt="자세히보기" /></a></span>
												</p>
												<p>특허출원후 등록까지의 전과정 
												및 각종 법률상담 문헌정보인 
												포대에 관한</p>
											</dd>
										</dl>
									</li>
								</ul>
							</div>
							
							<div class="service-wrap">
								<ul class="servList">
									<li>
										<dl>
											<dt><img src="/resources/images/main/img_sevice.gif" alt="안내 이미지" /></dt>
											<dd>
												<p>
													<strong>서비스</strong>
													<span><a href=""><img src="/resources/images/main/btn_detail.gif" alt="자세히보기" /></a></span>
												</p>
												<p>특허출원후 등록까지의 전과정 
												및 각종 법률상담 문헌정보인 
												포대에 관한</p>
											</dd>
										</dl>
									</li>
								</ul>
							</div>
							
							<div class="service-wrap">
								<ul class="servList">
									<li>
										<dl>
											<dt><img src="/resources/images/main/img_sevice.gif" alt="안내 이미지" /></dt>
											<dd>
												<p>
													<strong>서비스</strong>
													<span><a href=""><img src="/resources/images/main/btn_detail.gif" alt="자세히보기" /></a></span>
												</p>
												<p>특허출원후 등록까지의 전과정 
												및 각종 법률상담 문헌정보인 
												포대에 관한</p>
											</dd>
										</dl>
									</li>
								</ul>
							</div>							
					  </div>
					</div>					
					<div id="serviceSpot" class="sevice-paging">
						<a href="#"><img src="/resources/images/main/bul_won_on.gif" alt="1page" /></a>
						<a href="#"><img src="/resources/images/main/bul_won_off.gif" alt="2page" /></a>
						<a href="#"><img src="/resources/images/main/bul_won_off.gif" alt="3page" /></a>
					</div>
				</div>
				<!-- //서비스 안내 -->
				
				
				
				
			</div>
		</div>

        <!-- //contents --> 
    </div>
	<!-- //container -->

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>