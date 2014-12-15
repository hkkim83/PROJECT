<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<style>
</style>

   <!-- footer -->
    <div id="footer"> 
    	 <div class="footerCont">
			<div>
				<h1><img src="/resources/images/main/footer_logo.png" alt="로고" /></h1>
				<address>Copyright @ AIRS All rights reserved.</address>
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