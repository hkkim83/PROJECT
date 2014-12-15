<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top_popup.jsp" %>

<style>
.layerPopup.wid1{
	box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-box-sizing:border-box;
	width:100%;
	background-color: white;
}

.file_input_div{
	position:relative; overflow:hidden; padding:15px 0 5px 0
}
.file_input_hidden{ 
	font-size:20px;
	position:absolute;
	width:70px;
	opacity:0; 
	filter:alpha(opacity=0);
	-ms-filter:"alpha(opacity=0)";
	-khtml-opacity:0;
	-moz-opacity:0;
}

</style>

<script src="/resources/js/jquery.ui.widget.js"></script>	
<script src="/resources/js/jquery.iframe-transport.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>

<% 
	String priority = user != null ? user.getPriority() : "";
	String loginId  = user != null ? user.getId() : "";
%>

<script type="text/javascript">
var files = null;

// 첨부파일 다운로드
var downloadFile = function(filePath) {
	var pos = filePath.lastIndexOf("/");
	var fileName = filePath.substring(pos+1);
	location.href = "/download.do?filePath="+filePath+"&fileName="+fileName;
};

var BoardDlg = function(data, fnOkCallback, fnCloseCallback) {

	var priority  = "<%=priority%>";	// 사용자권한
	var status = data.STATUS;
	
	// 저장
	var save = function() {
		if (!confirm('저장하시겠습니까?')) {
			return;
		}
		var fdata = new FormData();
		fdata.append("TITLE",   $('#title').val());
		fdata.append("CONTENT", $('#content').val());
		fdata.append("FLAG", "N");
		fdata.append("STATUS",  status);
		if (files != null) {
			fdata.append("FILE", files["0"]);
		}

		$.ajax({
			type : "POST",
			url : "/board/save.do",
			data : fdata,
			dataType : "json",
			processData : false,
			contentType : false,
			success : function(data) {
				alert(data.RESULT_MSG);
				fnOkCallback();
			}
		});
	};

	// 삭제
	var del = function() {
		if (!confirm('삭제하시겠습니까?')) {
			return;
		}

		data.STATUS = "DELETE";

		var strParam = "DATA=" + Common.stringify(data);
		$.ajax({
			url : '/board/save2.do',
			data : strParam,
			type : 'POST',
			async : false,
			success : function(data) {
				alert(data.RESULT_MSG);
				fnOkCallback();
			}
		});
	};

	$('.pHeader h2').text(status == "INSERT" ? "공지사항 신규" : "공지사항 상세조회");
	$('#title').val(data.TITLE);
	$('#content').val(data.CONTENT);
	$('#filename').text(data.FILE_NAME);
	$('#filesize').text(Math.round(parseInt(data.FILE_SIZE)/1024));
	$('#filepath').attr("href", "javascript:downloadFile('"+data.FILE_PATH+"')");
	if(data.FILE_NAME == "" || data.FILE_NAME == null)
		$('#fileInfo').hide();
	else 
		$('#fileInfo').show();
	$('#btnSave').bind('click', save);
	$('#btnDel').bind('click', del);
	$('#btnClose').bind('click', fnCloseCallback);
	
	if(priority != "M" || data['WHERE'] == "INDEX") {
		$('#attachFile').hide();
		$('#btnSave').hide();
		$('#btnDel').hide();
		$('input, textarea').attr("readonly", true);
	}
};

(function($) {

	$(document).ready(function() {
		$('input[type=file]').on('change', function(event) {
			files = event.target.files;
		});
	});

})(jQuery);
</script>

<!-- layer popup 삽입시작 -->
<div class="layerPopup wid1" id="pop_search1" style="display:block;">
	<!-- header -->
	<div class="pHeader">
		<h2>공지사항 신규/수정</h2>
	</div>
	<!-- //header -->
 
	<!-- contents -->
	<div class="pContents">
		<form id="form" enctype="multipart/form-data" method="post">
			<fieldset>
				<div class="tbl_bbs4">
					<table summary="제목,내용">
					<caption>공지사항 신규/수정</caption>
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>
					<tbody>
					<tr>
						<th><label for="title">제목</label></th>				
						<td><input type="text" name="TITLE" id="title" class="w95" /></td>
					</tr>
					<tr>
						<th><label for="title">첨부파일</label></th>
						<td>
							<div id="attachFile">
								<input type="hidden" name="FLAG" id="flag" value="N" readonly/>
								<input type="file" id="file" name="file" class="file_input_hidden" title="파일추가"/>
								<a id="addFile" href="#" class="btntype2"><span>파일추가</span></a>
							</div>
							<div id="fileInfo">
							<span id="filename">파일있음</span>[ <span id="filesize"></span>KB ] <a id="filepath" href="#"><img src="/resources/images/common/ico_file.gif"></a>
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="content">내용</label></th>
						<td>
							<textarea class="w95" name="CONTENT" id="content"></textarea>
						</td>
					</tr>
					</tbody>
					</table>
				</div>
			</fieldset>
		</form>
	</div>
	<!-- //contents -->
	
	<!-- footer -->
	<div class="pFooter">
		<div class="pbtn">
			<button type="button" id="btnSave" class="btnPoGreen">저장</button>
			<button type="button" id="btnDel" class="btnPoOrang">삭제</button>
			<a href="#" id="btnClose" class="btnPoGray">닫기</a>
		</div>
	</div>
	<!-- //footer -->
</div>
<!-- //layer popup 삽입 끝 -->

<%@ include file="/WEB-INF/views/common/bottom_popup.jsp" %>