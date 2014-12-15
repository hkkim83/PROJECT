<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="kr.co.aegis.dto.User, java.util.Map, java.util.List"%>
<%@ page import="kr.co.aegis.base.BaseController"%>
<% User user = (User)session.getAttribute(BaseController.USER_SESSION); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link type="text/css" rel="stylesheet" href="/resources/css/style.css" />

<%@ include file="/WEB-INF/views/common/include.jsp" %>

<script>

(function($){
	
})(jQuery);
</script>
</head>
<body style="background:transparent">
