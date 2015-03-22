<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<script type="text/javascript">
<!--
//-->
(function($){
	var isCheckID = false;
	// 중복체크 버튼 클릭시
	var dupCheck = function() {
		var strParam = "TYPE=ID&ID="+$('#ID').val();
		
		if($('#ID').attr("readonly") == "readonly") return;
		if(($('#ID').val()).length < 4) {
			alert("아이디는 4자리 이상 입력하기 바랍니다.");
			$('#ID').focus();
			return;
		}
		
		$.ajax({
			url: '/admin/dupCheck.do',
			data : strParam,
			type: 'POST',
			beforeSubmit : function() {
				checkVal("DUP_CHECK");
			},
			success: function(data){
				if(data.RESULT_CD == "SUCC_0001") {
					if(data.CHECK_MAP.DUP_CHECK == "F") {
						alert("사용하실 수 있는 아이디 입니다.");
						isCheckID = true;
						$('#NAME').focus();
					} else {
						alert("이미 등록된 아이디가 있습니다.");
						isCheckID = false;
						$('#ID').focus();
					}
				} else {
					alert(data.RESULT_MSG);
				}
			}
		});			
	};
	
	// 필수값 체크
	var isNullCheck = function(colIdList) {
		for(var i=0; i<colIdList.length; i++) {
			if($('#'+colIdList[i]).val() == "") {
				var colName = $('label[for*='+colIdList[i]+']').eq(0).text();
				alert(colName.replace("*","")+"은 필수입력입니다.");
				$('#'+colIdList[i]).focus();
				return false;
			}
		}
		return true;
	};
	
	// 정합성 체크
	var checkVal = function() {
		
		// 필수값 체크
		var colIdList = ["COMPANY", "BIZ_NO1", "BIZ_NO2", "BIZ_NO3", "ID", "NAME", "PASSWORD"];
			
		if(!isNullCheck(colIdList)) return false;
		
		if(($('#ID').val()).length < 4) {
			alert("아이디는 4자리 이상 입력하기 바랍니다.");
			$('#ID').focus();
			return;
		}
		
		if(!isCheckID) {
			alert("아이디 중복체크를 해주시기 바랍니다.");
			$('#id').focus();
			return false;
		}
		
		if($('#PASSWORD').val() != $('#RE_PASSWORD').val()) {
			alert("비밀번호가 일치하지 않습니다.  다시 확인해 주시기 바랍니다.");
			$('#PASSWORD').focus();
			return false;
		}
		
		return confirm("가입요청하시겠습니까?");
	};
	
	// 데이터 직렬화
	var serialize = function() {
		var array = new Array();
		var data = new Object();
		data['APPV_YN'] = '0';		// 승인여부 미승인으로 셋팅
		data['STATUS'] = 'INSERT';	// 등록셋팅
		$('input').each(function(){
			data[$(this).attr("id")] = $(this).val();
		});
		$('textarea').each(function(){
			data[$(this).attr("id")] = $(this).val();
		});
		array.push(data);
		return Common.stringify(array);
	};
	
	// 저장버튼 클릭시
	var save = function() {
		if(!checkVal()) return;
		var strParam = "DATA="+serialize();
		$.ajax({
			url : '/request.do',
			data : strParam,
			success : function(data) {
				alert(data.RESULT_MSG);
				if(data.RESULT_CD == "SUCC_0001")
					location.href = '/index.do';
			}
		});
	};
	
	// 아이디 값 입력시 중복체크여부 변경
	var onKeyUp = function(obj) {
		var colid = obj.attr("id");
		if(colid == "ID") {
			isCheckID = false;
		}
	};
	
	// 화면 로딩시
	$(document).ready(function(){
		$('#btnSave').bind('click', save);
		$('#btnCancel').bind('click', function() {
			if(confirm("입력된 내용이 모두 취소됩니다. 취소하시겠습니까?"))
				location.href = "/index.do";
		});
		$('#btnDupCheck').bind('click', dupCheck);
		$('input').bind('keyup', function() {
			onKeyUp($(this));
		});
		
		$(document).on("keyup", "input:text[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );});
		$(document).on("keyup", "input:text[alphaOnly]", function() {$(this).val( $(this).val().replace(/[^0-9a-zA-Z]/gi,"") );});
		
		$('#COMPANY').focus();
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
						<h3><img src="/resources/images/common/h3_login_1.png" alt="회원가입"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li><strong>회원가입</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 회원가입폼  -->
					<div class="searchResults">
						<p class="txt">
							사업자별 회원가입 요청 페이지 입니다. <br />회사 내의 각 사용자 등록은 귀하의 사내 관리자에게 문의하세요. 
						</p>
						<h4>사업자 회원가입</h4>
						<div class="tbl_bbs6">
							<form name="join" method="post">
								<fieldset>
									<table summary="">
									<caption><caption>
									<colgroup>
										<col width="15%" />
										<col width="35%" />
										<col width="15%" />
										<col width="35%" />
									</colgroup>
									<tbody>
									<tr>
										<th scope="row"><label for="COMPANY">* 회사명</label></th>
										<td><input type="text" class="w90" id="COMPANY" /></td>
										<th scope="row"><label for="BIZ_NO1BIZ_NO2BIZ_NO3">* 사업자등록번호</label></th>
										<td>
											<input type="text" id="BIZ_NO1" class="w15" maxlength="3" numberOnly=true/> -
											<input type="text" id="BIZ_NO2" class="w10" maxlength="2" numberOnly=true/> -
											<input type="text" id="BIZ_NO3" class="w20" maxlength="5" numberOnly=true/>
										</td>										
									</tr>
									<tr>
										<th scope="row"><label for="ID">* 관리자 ID</label></th>
										<td><input type="text" id="ID" alphaOnly=true/> <button type="button" id="btnDupCheck" class="btnSmall gray">중복체크</button></td>
										<th scope="row"><label for="NAME">* 관리자 이름</label></th>
										<td colspan="3"><input type="text" id="NAME" class="w50" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="PASSWORD">* 관리자 PW</label></th>
										<td><input type="password" id="PASSWORD" class="w90" /></td>
										<th scope="row"><label for="RE_PASSWORD">PW 확인</label></th>
										<td><input type="password" id="RE_PASSWORD" class="w90" /></td>
									</tr>
									<tr>
									</tr>
									<tr>
										<th scope="row"><label for="E_MAIL">E-mail</label></th>
										<td><input type="text" id="E_MAIL" class="w90" /></td>
										<th scope="row"><label for="TEL_1TEL_2TEL_3">전화번호</label></th>
										<td>
											<input type="text" id="TEL_1" class="w15" title="첫번째번호" maxlength="3" numberOnly=true/> -
											<input type="text" id="TEL_2" class="w15" title="중간번호" maxlength="4" numberOnly=true/> -
											<input type="text" id="TEL_3" class="w15" title="끝번호" maxlength="4" numberOnly=true/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="COMMENT">남기는 말</label></th>
										<td colspan="3">
											<textarea title="남기는 말" id="COMMENT" class="w97"></textarea>
										</td>
									</tr>
									</tbody>
									</table>
									<div class="btnArea">
										<a href="#" id="btnSave" class="btntype4"><span>가입요청</span></a>
										<a href="#" id="btnCancel" class="btntype1"><span>취소</span></a>
									</div>
								</fieldset>
							</form>
						</div>
						<p class="txt"> 담당자 : 임청홍 차장  문의전화 : 070-8891-6347(직통), 010-2669-0214(핸드폰) [ 전화상담 운영시간 (평일) 09:00 ~ 18:00 ],  이메일 : chyim@airsgroup.com</p>
					</div>
					<!-- //회원가입폼 -->
					
				</div>
				<!-- //contents body -->
			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->


<%@ include file="/WEB-INF/views/common/bottom.jsp" %>