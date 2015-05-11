<%@ page language="java" contentType="application/hwp; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="kr.co.aegis.dto.User, java.util.Map, java.util.List, kr.co.aegis.util.StringUtil, kr.co.aegis.util.DateUtil, java.net.URLEncoder"%>
<%
	//String time = DateUtil.getDateTimeToString();
	String fileName = "선행기술조사보고서.hwp";
	fileName = URLEncoder.encode(fileName, "utf-8");
	response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	response.setHeader("Content-Description", "JSP Generated Data");
	response.setContentType("application/hwp");
%>

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
</head>
<body>
<TABLE border="1" cellspacing="0" cellpadding="0" style='border-collapse:collapse;border:none;'>
<TR>
	<TD colspan="3" width="601" height="27" valign="middle" bgcolor="#4764be" style='border-left:solid #162d68 0.9pt;border-right:solid #162d68 0.9pt;border-top:solid #162d68 0.9pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:36.9pt;text-align:center;text-indent:-36.4pt;line-height:190%;'><SPAN STYLE='font-size:12.0pt;color:#ffffff;line-height:190%;'>조사 기준 및 방법</SPAN></P>
	</TD>
</TR>
<TR>
	<TD rowspan="7" width="70" height="187" valign="middle" bgcolor="#fbfbec" style='border-left:solid #000000 1.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN>검색<br/>결과<br/>건수</SPAN></P>
	</TD>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>KR</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.KR_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>JP</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.JP_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>US</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.US_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>EP</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.EP_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>CN</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.CN_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>PCT</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.PCT_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="109" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN>Total</SPAN></P>
	</TD>
	<TD width="422" height="25" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #162d68 0.9pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";color:#ff0000;'><c:out value="${MAP.TOT_COUNT}"/></SPAN></P>
	</TD>
</TR>
<TR>
	<TD width="70" height="46" valign="middle" bgcolor="#fbfbec" style='border-left:solid #000000 1.4pt;border-right:solid #000000 0.4pt;border-top:solid #162d68 0.9pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN>조사 DB</SPAN></P>
	</TD>
	<TD width="109" height="46" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN>&nbsp;DB</SPAN></P>
	</TD>
	<TD width="422" height="46" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-indent:1.3pt;'><SPAN>&nbsp;■ </SPAN><SPAN>KIPRIS PLUS</SPAN></P>
	</TD>
</TR>
</TABLE>
    <br><br><br>
<TABLE border="1" cellspacing="0" cellpadding="0" style='border-collapse:collapse;border:none;'>
<TR>
	<TD colspan="7" width="598" height="27" valign="middle" bgcolor="#4764be" style='border-left:solid #162d68 0.9pt;border-right:solid #162d68 0.9pt;border-top:solid #162d68 0.9pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:36.9pt;text-align:center;text-indent:-36.4pt;line-height:190%;'><SPAN STYLE='font-size:12.0pt;color:#ffffff;line-height:190%;'>주요 선행기술</SPAN></P>
	</TD>
</TR>
<TR>
	<TD rowspan="${MAP.TOT_COUNT+1}" width="74" height="51" valign="middle" bgcolor="#fbfbec" style='border-left:solid #000000 1.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN>주요<br/>선행기술</SPAN></P>
	</TD>
	<TD width="42" height="38" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";'>NO.</SPAN></P>
	</TD>
	<TD colspan="4" width="423" height="38" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN STYLE='font-weight:"bold";'>특허번호</SPAN></P>
	</TD>
	<TD width="60" height="38" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN STYLE='font-weight:"bold";'>관련도<br/>(X,Y,Z)</SPAN></P>
	</TD>
</TR>  
<c:choose>
<c:when test="${! empty LIST}"> 
<c:forEach items="${LIST}" var="PATENT" varStatus="status">    
<TR>
	<TD width="42" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN><c:out value="${status.count}"/></SPAN></P>
	</TD>
	<TD width="71" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN><c:out value="${PATENT.NATL_CODE}"/></SPAN></P>
	</TD>
	<TD colspan="2" width="250" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt;mso-number-format:"\@";'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN><c:out value="${PATENT.REGI_NUM}"/></SPAN></P>
	</TD>
	<TD width="102" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN><c:out value="${PATENT.KINDS_IP_CODE}"/></SPAN></P>
	</TD>
	<TD width="60" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 0.4pt;border-bottom:solid #000000 0.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='text-align:center;'><SPAN><c:out value="${PATENT.GRADE_CONST}"/></SPAN></P>
	</TD>
</TR>
</c:forEach>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>   
<TR>
	<TD rowspan="3" width="74" height="51" valign="middle" bgcolor="#fbfbec" style='border-left:solid #000000 1.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 1.4pt 1.4pt 1.4pt'>
	<P STYLE='margin-left:2.0pt;margin-right:2.0pt;text-align:center;text-indent:1.3pt;'><SPAN>관련도<br/>설명</SPAN></P>
	</TD>
	<TD colspan="3" width="230" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>X</SPAN></P>
	</TD>
	<TD colspan="3" width="295" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>1개 문헌으로 신규성</SPAN></P>
	</TD>
</TR>
<TR>
	<TD colspan="3" width="230" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>Y</SPAN></P>
	</TD>
	<TD colspan="3" width="295" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>2개 문헌 조합으로 진보성</SPAN></P>
	</TD>
</TR>
<TR>
	<TD colspan="3" width="230" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 0.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>Z</SPAN></P>
	</TD>
	<TD colspan="3" width="295" height="17" valign="middle" style='border-left:solid #000000 0.4pt;border-right:solid #000000 1.4pt;border-top:solid #000000 1.4pt;border-bottom:solid #000000 1.4pt;padding:1.4pt 5.7pt 1.4pt 5.7pt'>
	<P STYLE='margin-left:5.0pt;text-align:center;line-height:170%;'><SPAN>이 분야 관련기술</SPAN></P>
	</TD>
</TR>    
</TABLE>
</body>
</html>
