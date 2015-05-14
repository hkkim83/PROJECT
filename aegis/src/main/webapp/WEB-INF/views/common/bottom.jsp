<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<style>
</style>

   <!-- footer -->
    <div id="footer"> 
    	 <div class="footerCont">
			<div>
				<h1><img src="/resources/images/common/footer_logo.png" alt="로고" /></h1>
				<address>
                  담당자: 임철홍 차장&nbsp; 문의전화: 070-8891-6347(직통) 010-2669-0214(휴대폰)<br>
                  이메일: chyim@airsgroup.com [전화상담 운영시간(평일) 09:00 ~ 18:00]<br>
                  Copyright @ AIRS All rights reserved.
                </address>
			</div>
		 </div>
	</div>
    <!-- //footer -->
	
	<div id="dlg_login" style="display:none;z-index:50;position:absolute;top:0px;left:0px;width:100%;height:100%;background-color:rgba(0, 0, 0, 0.6);">
	  <iframe src="/loginDlg.do" style="position:absolute;top:200px;width:300px;height:500px;"></iframe>
	</div>
<script>
	var showLoginPop = function(fnLoginOkCallback, data){
		var $dialog = $('#dlg_login');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		new dialogWin.LoginDlg(data, fnLoginOkCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($('body').height());
		$dialog.show();		
	};
</script>		
</div><!-- //wrap -->
</body>
</html>