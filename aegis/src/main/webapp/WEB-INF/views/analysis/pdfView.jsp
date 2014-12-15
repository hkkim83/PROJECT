<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AEGIS 특허분석시스템</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" /> 
<meta name="subject" content="AGEIS 특허분석시스템" />
<meta name="keywords" content="AGEIS 특허분석시스템" />
<meta name="description" content="AGEIS 특허분석시스템" /> 
<meta name="language" content="ko" /> 
<%@ include file="/WEB-INF/views/common/include.jsp" %>
<script>
(function($){
	$(document).ready(function(){
		$('object').height($(document).height());
	});
})(jQuery);
</script>
</head>
<body style="overflow:hidden;">	
	<object type="application/pdf" data="${PDF}" width="100%"></object>
</body>
</html>