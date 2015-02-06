<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="kr.co.aegis.dto.User, java.util.Map, java.util.List, kr.co.aegis.util.StringUtil"%>
<%@ page import="kr.co.aegis.base.BaseController"%>
<% User user = (User)session.getAttribute(BaseController.USER_SESSION); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AEGIS 특허분석시스템</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" /> 
<meta name="subject" content="AEGIS 특허분석시스템" />
<meta name="keywords" content="AEGIS 특허분석시스템" />
<meta name="description" content="AEGIS 특허분석시스템" /> 
<meta name="language" content="ko" /> 
<!--[if lte IE 7]><link	rel="stylesheet" href="/resources/css/ie7.css" type="text/css" media="all"><![endif]-->

<%@ include file="/WEB-INF/views/common/include.jsp" %>
<script>
(function($){

	var showMenu = function(menuId) {
		$('.nav > li').each(function(){
			var strSrc = $('img', $(this)).attr('src');
			strSrc = strSrc.replace('_on', '_off');
			$('img', $(this)).attr('src', strSrc);
			if($('ul', $(this)) != undefined)
				$('ul', $(this)).hide();
		});
		
		var strSrc = $('#'+menuId+' img').attr('src');
		if(strSrc == undefined) return;
		console.log(strSrc);
		strSrc = strSrc.replace('_off', '_on');
		$('#'+menuId+' img').attr('src', strSrc);
		$('#tb_sub_'+menuId).show();
	};

	var logout = function() {
		
		var strParam = '';
		$.ajax({
			url : "/logout.do",
			type : "POST",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD != "SUCC_0001") {
					alert(data.RESULT_MSG);
					return;
				}
				alert('로그아웃 되었습니다.');
				location.href = '/index.do';
			}
		});
	};
	
	var changeProject = function() {
		var beforeURI = "<%=request.getRequestURI()%>";
		//alert(beforeURI);
		var strParam = 'PROJECT_ID='+$('#loginProjectList option:selected').val();
		$.ajax({
			url : "/setProjectId.do",
			type : "POST",
			data : strParam,
			success : function(data) {
				if(data.RESULT_CD != "SUCC_0001") {
					alert(data.RESULT_MSG);
					return;
				} else {
					alert('프로젝트가 변경되었습니다.');
					if(beforeURI.indexOf("patentSumView") > -1)
						location.href = '/patent/view.do';
					else if(beforeURI.indexOf("process")  > -1 ||
						beforeURI.indexOf("applicant")    > -1 ||
						beforeURI.indexOf("omission")     > -1 ||
						beforeURI.indexOf("category")     > -1 )
						location.href = '/index.do';
					else 
						location.reload();
				}
			}
		});		
	};
	
	
	$(document).ready(function(){

/* 		$('.nav div:eq(0) a').bind('mouseover', function(){
			var menuId = $(this).attr('id');
			showMenu(menuId);
		});
		
		$('.nav').bind('mouseleave', function(){
			initMenu();
		}); */
		
		$('.nav > li > a').bind('mouseover', function() {
			var menuId = $(this).attr('id');
			showMenu(menuId);			
		});
		
		$('#btnLogout').bind('click', logout);

		$('#loginProjectList').bind('change', function(event) {
			changeProject();
		});
		
		showMenu('menu01');
	});

})(jQuery);
</script>
</head>
<body>
<!-- skipToContent -->
<div id="skipToContent"> 
   <a href="#container">메인콘텐츠 바로가기</a> 
</div>
<!-- //skipToContent -->

<div id="wrap"> 
    <!-- header -->
    <div id="header">
		<div class="headConts">
<% if(user != null){ 
	String str = StringUtil.comma(user.getPoint());
%>
			<ul class="topAdmin">
				<li><strong><%=user.getName()%></strong>님</li>
				<li>잔여포인트 : <em><%=str%>p</em></li>
				<li><label for="">프로젝트</label>
					<select name="loginProjectList" id="loginProjectList">
<%	if(!user.getProjectList().isEmpty() || user.getProjectList().size() > 0) {
		for(Map<String, String> map : user.getProjectList()) {
			String projectId = user.getProjectId();
			if(projectId.equals(map.get("PROJECT_ID"))) {
%>
						<option value="<%=map.get("PROJECT_ID")%>" selected><%=map.get("PROJECT_NAME")%></option>
<%		
			} else {
%>
						<option value="<%=map.get("PROJECT_ID")%>"><%=map.get("PROJECT_NAME")%></option>
<%				
			}
		}
	} else {
%>			
						<option value="">선택하세요</option>
<% } %>			
					</select>
				</li>
				<li><a id="btnLogout" href="#">로그아웃</a></li>
			</ul>
<% }else{ %>
			<div style="height:26px;"></div>
<% } %>		




			<div class="topGroup">
				<h1><a href="/index.do"><img src="/resources/images/main/logo.png" alt="AGEIS" /></a></h1>
				
<!-- 상단메뉴 시작 -->				
				<div style="float:left;">
					<ul class="nav">
<% if(user == null || "U".equals(user.getPriority())){ %>
						<li><a id="menu01" href="/searchFormula/view.do"><img src="/resources/images/main/main_nav_01_off.png" alt="검색식" /></a></li>
	<% if(user != null && "1".equals(user.getProjectAuth())){ %>
						<li><a id="menu02" href="#"><img src="/resources/images/main/main_nav_02_off.png" alt="데이터가공" /></a>
							<ul id="tb_sub_menu02">
								<li><a href="/process/view.do">일괄자동등록</a></li>
								<li><a href="/applicant/view.do">대표명화관리</a></li>
								<li><a href="/omission/view.do">특허문헌 누락처리</a></li>
								<li><a href="/category/view.do">OS 관리</a></li>
								<li><a href="/processStep/view.do">단계별 데이터 처리</a></li>								
							</ul>
						</li>
	<%}%>
						<li><a id="menu03" href="#"><img src="/resources/images/main/main_nav_03_off.png" alt="데이터분석" /></a>
							<ul id="tb_sub_menu03">
								<li><a href="/patent/view.do">특허검색</a></li>
								<li><a href="/OSMatrix/view.do">OS Matrix</a></li>
								<li><a href="/keyPatent/view.do">핵심특허분석</a></li>
							</ul>							
						</li>
						<li><a id="menu04" href="#"><img src="/resources/images/main/main_nav_04_off.png" alt="그래프분석" /></a>
							<ul id="tb_sub_menu04">
								<li><a href="/graph/yearView.do">국가별연도별분석</a></li>
								<li><a href="/graph/gradeView.do">국가별등급별분석</a></li>
								<li><a href="/graph/applView.do">출원인별등급별분석</a></li>
								<li><a href="/graph/cateView.do">기술분류별분석</a></li>
							</ul>							
						</li>
<% } else if("A".equals(user.getPriority())){ %>
						<li><a id="menu11" href="/project/view.do"><img src="/resources/images/main/main_nav_11_off.png" alt="프로젝트관리" /></a></li>
						<li><a id="menu12" href="/user/view.do"><img src="/resources/images/main/main_nav_12_off.png" alt="사용자관리" /></a></li>
<% } else if("M".equals(user.getPriority())){ %>
						<li><a id="menu21" href="/admin/view.do"><img src="/resources/images/main/main_nav_21_off.png" alt="고객관리" /></a></li>
						<li><a id="menu22" href="/board/view.do"><img src="/resources/images/main/main_nav_22_off.png" alt="게시판관리" /></a></li>
<% } %>
					</ul>
					<!-- 
					<div id="header_bottom" align="center" style="display:block;">
						<table id="tb_sub_menu02">
						  <tr>
							<td><a href="/process/view.do">일괄자동등록</a></td>
							<td>|</td>
							<td><a href="/applicant/view.do">대표명화관리</a></td>
							<td>|</td>
							<td><a href="/omission/view.do">특허문헌 누락처리</a></td>
							<td>|</td>
							<td><a href="/category/view.do">OS 관리</a></td>
							<td>|</td>
							<td><a href="/processStep/view.do">단계별 데이터 처리</a></td>
						  </tr>
						</table>
						
						<table id="tb_sub_menu03" style="display:none;">
						  <tr>
							<td><a href="/patent/view.do">특허검색</a></td>
							<td>|</td>
							<td><a href="/OSMatrix/view.do">OS Matrix</a></td>
							<td>|</td>
							<td><a href="/keyPatent/view.do">핵심특허분석</a></td>
						  </tr>
						</table>
						
						<table id="tb_sub_menu04" style="display:none;">
						  <tr>
							<td><a href="/graph/yearView.do">국가별연도별분석</a></td>
							<td>|</td>
							<td><a href="/graph/gradeView.do">국가별등급별분석</a></td>
							<td>|</td>
							<td><a href="/graph/applView.do">출원인별등급별분석</a></td>
							<td>|</td>
							<td><a href="/graph/cateView.do">기술분류별분석</a></td>
						  </tr>
						</table>
					</div>
					 -->
				</div>				
<!-- 상단메뉴 종료 -->				
				
				
	
				
				
			</div>
		</div>
    </div>
    <!-- //header -->  
