<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<style>
.expressionBox{
	padding:4px !important;
}

select {
	height: 22px;
}

.asideMenu{
	min-height: 10px !important;
}
#container{
	height: auto !important;
}

.td01 {
	vertical-align: middle;
	text-align: right;
	color: #25ac01;
	font-weight: bold;
}

#tr_keyword > td > table > tbody > tr {
	border-top: 1px solid #e1ebce;
}
#tr_keyword > td > table > tbody > tr > td {
	padding: 6px 0px 6px 0px;
	vertical-align: middle;
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
<script type="text/javascript" src="/resources/js/search/searchFormula.js" ></script>
<script type="text/javascript" src="/resources/js/search/wipsonParser.js" ></script>
<script type="text/javascript" src="/resources/js/search/focustParser.js" ></script>
<script type="text/javascript" src="/resources/js/search/kiprisParser.js" ></script>
<script type="text/javascript">
<!--
//-->
(function($){

	//var sampleWipson = '(((철도? OR 열차* 기차* 객차* 트레인* train* 전철* 지하철* 레일* subway* rail*).ti. and (승강문* 출입문* 도어* door* 게이트* gate* 리프* leaf* (outgoing near3 (문* 장치*)) ((승강* 출입* board* alight* access* enter* incoming outgoing) near2 (문* 장치* device* equipment* 수단* means way method measure expedient))) and (b61b* b61c* b61d* b61f* b60j*).ipc. and (@AD>=2012<=2013) and (@PRD<=2013) and (outgoing near3 (문* 장치*))))';	
	
	//var sampleFocust = 'TI=(imag* or vedeo or camera or 영상 or 비디오 or 비데오 or 카메라) and (object or target or body or 대상 or 목표 or 타켓 or 물체) and (cognit* or track* or detect* or 인식 or 인지 or 트래킹* or 트랙 or 검출 or 디텍터*) and (security* or surveil* or 보안 or 감시 or 탐지) and IC=(H04L-012* or H04N-005* or H04N-007*)';	
	//var sampleFocust = 'TI=(하이브리드* and 자동차) AND AB=(하이브리드 WITHIN/1 (차량 or 자동차) ) AND CL=(하이브리드 and (차량 or 자동차) ) AND (AD>=20130101) AND (AD<=20131231)';	
	
	//var sampleKipris = '자동차*엔진*IPC=[H04N+H04L]*TL=[(imag+video+camera+영상+비디오+비데오+카메라)]*(object+target+body+대상+목표+타켓+물체)*(인식+인지+트래킹+트랙+검출+디텍터)*(보안+감시+탐지+aaa^2bbb)';
	//var sampleKipris = '자동차*엔진*AN=[1020020012345]*PD=[20120101~20131231]*(^2)';
	
	
	var $trBaseParameter = null;
	var $trBaseKeyword = null;
	
	
	// 검색식 생성
	var makeSearchFormula = function(){
		var arrKeyword = new Array();
		$('#tbl_keyword > tbody > tr[id=tr_keyword]').each(function(trIdx){
			var arrParameter = new Array();
			$(this).find('[id=tr_parameter]:visible').each(function(){
				var oParameter = new Object();
				oParameter['parameter'] = $(this).find('#parameter').val();
				arrParameter.push(oParameter);
			});
			var oKeyword = new Object();
			oKeyword['keyword'] = $(this).find('#keyword').val();
			oKeyword['fieldCode'] = $(this).find('#field').val();
			oKeyword['field'] = $(this).find('#field option:selected').attr('_'+$('#db_type').val());
			oKeyword['parameters'] = arrParameter;
			arrKeyword.push(oKeyword);
		});
		
		var oSearchFormulaGenerator = new SearchFormulaGenerator();
		var searchFormula = oSearchFormulaGenerator.generate(arrKeyword, $('#db_type').val());
		$('#search_formula').val(searchFormula);
		
		$('#text_db_type_cd').val($('#db_type').val());
		$('#text_search_formula').val(searchFormula);
	};
	
	
	// 키워드분석
	var setParametersTr = function(keywordTr){
		
		var keyword = $(keywordTr).find('#keyword').val();
		$(keywordTr).find('> td > table > tbody > tr').filter('[id=tr_parameter]').hide();
		
		var oSharpIterator = new SharpIterator(keyword); 
		var strSharp = '';
		while((strSharp=oSharpIterator.nextSharp()) != ''){
			var $parameterTr = $(keywordTr).find('[id=tr_parameter]').eq(oSharpIterator.getIdx());
			if($parameterTr.attr('id') == 'tr_parameter'){	// 숨겨진 parameter row가 존재한다면 보여준다. 
				$parameterTr.show();
			}else{
				$parameterTr = appendParameterRow(keywordTr);
			}
			$parameterTr.find('#title').text(strSharp);
		}
	};
	
	
	// 키워드행 추가
	var appendKeywordRow = function(){
		var $trKeyword = $trBaseKeyword.clone();
		$trKeyword.find('#keyword').bind('keyup', {tr:$trKeyword[0]}, function(event){
			setParametersTr(event.data.tr);
		});
		$trKeyword.find('#field').bind('change', function(){
			if($(this).val() == '04' || $(this).val() == '18'){
				$trKeyword.find('#title').eq(0).text('특허분류');
			}else{
				$trKeyword.find('#title').eq(0).text('키워드');
			}
		});
		setFieldCombo($trKeyword.find('#field'));
		$trKeyword.find('#btn_delete').bind('click', {tr:$trKeyword[0]}, function(event){
			event.preventDefault();
			if(!confirm('삭제하시겠습니까?')){
				return;
			}
			$(event.data.tr).remove();
		});
		$('#tbl_keyword').append($trKeyword);
		return $trKeyword;
	};
	
	
	// 파라미터행 추가
	var appendParameterRow = function(targetKeywordTr){
		var $trParameter = $trBaseParameter.clone();
		$trParameter.find('#btn_delete').bind('click', {tr:$trParameter[0]}, function(event){
			$(event.data.tr).remove();
			makeSearchFormula();
		});
		
		$(targetKeywordTr).find('> td > table > tbody').append($trParameter);
		return $trParameter;
	};	
	
	
	// 검색식 분리
	var reverseSearchFormula = function(){
		
		var strSearchFormula = $('#search_formula').val();
		var oSearchFormula = new SearchFormula();
		
		var mapResult = oSearchFormula.parse(strSearchFormula);
		$('#text_db_type_cd').val(mapResult['dbTypeCd']);
		$('#text_search_formula').val(mapResult['searchFormula']);
		$('#db_type').val(mapResult['dbTypeCd']);
		$('#db_type').trigger('change');
		
		var arrKeyword = mapResult['arrKeyword'];
		$('#tbl_keyword > tbody > tr').remove();
		for(var i=0; i<arrKeyword.length; i++){
			var oKeyword = arrKeyword[i];
			var $trKeyword = appendKeywordRow();
			$trKeyword.find('#keyword').val(oKeyword['keyword']);
			var attrSelector = '[_' + mapResult['dbTypeCd'] + '=' + oKeyword['field']+']';
			var fieldVal = $trKeyword.find('#field option').filter(attrSelector).val();
			$trKeyword.find('#field').val(fieldVal);
			$trKeyword.find('#field').trigger('change');
			if(oKeyword['parameters'] != null){
				for(var j=0; j<oKeyword['parameters'].length; j++){
					var oParameter = oKeyword['parameters'][j];
					var $trParameter = appendParameterRow($trKeyword[0]);
					$trParameter.find('#title').text('#'+(j+1));
					$trParameter.find('#parameter').val(oParameter['parameter']);
				}
			}
		}
	};
	
	
	// 필드콤보 값설정
	var setFieldCombo = function($combo){
		Common.setCommonCodeCombo('11', $combo, function(oOption){
			var $option = $(oOption);
			$option.val(this['COMM_CODE']);
			$option.text(this['COMM_NAME']);
			$option.attr('_11', this['VAL_1']);
			$option.attr('_12', this['VAL_2']);
			$option.attr('_13', this['VAL_3']);
		});
	};
	
	
	// 검색식 신규저장 팝업
	var save = function(){
		
		var content = $('#text_search_formula').val();
		if(content.trim() == ''){
			alert('생성된 검색식이 없습니다.');
			return;
		}
		
		var data = new Object();
		data.DB_TYPE_CD = $('#text_db_type_cd').val();
		data.CONTENT = content;
		
		if(!Common.checkLogin()){
			showLoginPop(function(){
				location.reload();
			}, data);
			return;
		}
		
		var $dialog = $('#dlg_search_formula_rgs');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		new dialogWin.SearchFormulaRgsDlg(data, fnCloseCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();		
	};
	
	
	// 검색식 불러오기 팝업
	var load = function(){
		
		if(!Common.checkLogin()){
			showLoginPop(function(){
				location.reload();
			});
			return;
		}
		
		var $dialog = $('#dlg_search_formula_lst');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		var fnOkCallback = function(searchFormulaContent){
			$('#search_formula').val(searchFormulaContent);
			reverseSearchFormula();
			$dialog.hide();
			dialogWin.location.reload();
		};
		new dialogWin.SearchFormulaLstDlg(fnOkCallback, fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();		
	};
	
	
	// 검색식 수정팝업
	var modify = function(){
		
		if(!Common.checkLogin()){
			showLoginPop(function(){
				location.reload();
			});
			return;
		}
		
		var $dialog = $('#dlg_search_formula_mod');
		var left = ($('body').width()-$dialog.find('iframe').width())/2;
		var dialogWin = $dialog.find('iframe')[0].contentWindow;
		var fnCloseCallback = function(){
			$dialog.hide();
			dialogWin.location.reload();
		};
		new dialogWin.SearchFormulaModDlg(fnCloseCallback);
		$dialog.find('iframe').css('left', left);
		$dialog.height($(document).height());
		$dialog.show();		
	};	
	
	
	$(document).ready(function(){
		
		$trBaseParameter = $('#tr_parameter').remove();
		$trBaseKeyword = $('#tr_keyword').remove();

		$('#btn_add').bind('click', function(event){
			event.preventDefault();
			appendKeywordRow();
		});
		$('#btn_create').bind('click', function(event){
			event.preventDefault();
			makeSearchFormula();
		});
		
		$('#btn_load').bind('click', function(event){
			event.preventDefault();
			load();
		});
		$('#btn_modify').bind('click', function(event){
			event.preventDefault();
			modify();
		});
		$('#btn_save').bind('click', function(event){
			event.preventDefault();
			save();
		});
		$('#db_type').bind('change', function(){
			var dbUrl = $(this).find('option:selected').attr('VAL_1');
			$('#btn_go_to_search_db').find('span').text('검색DB 바로가기 ['+dbUrl+']');
		});
		
		$('#btn_copy_search_formula').zclip({ 
			  path:'/resources/swf/ZeroClipboard.swf'
			, copy:function(){return $('#text_search_formula').val();}
		});
		
		$('#btn_go_to_search_db').bind('click', function(event){
			event.preventDefault();
			var dbUrl = 'http://'+$('#db_type').find('option:selected').attr('VAL_1');
			window.open(dbUrl);
		});
		
		appendKeywordRow();
		Common.setCommonCodeCombo('01', $('#db_type'));
		$('#db_type').trigger('change');
		
		if('<%=request.getAttribute("CONTENT")%>' != 'null'){
			$('#db_type').val('<%=request.getAttribute("DB_TYPE_CD")%>');
			$('#search_formula').val('<%=request.getAttribute("CONTENT")%>');
			reverseSearchFormula();
		}
	});
	
})(jQuery);
</script>
<div id="dlg_search_formula_rgs" class="layer_dialog">
  <iframe src="/searchFormula/rgsDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
<div id="dlg_search_formula_mod" class="layer_dialog">
  <iframe src="/searchFormula/modDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>
<div id="dlg_search_formula_lst" class="layer_dialog">
	<iframe src="/searchFormula/lstDlg.do" allowTransparency="true" marginheight="0" marginwidth="0" frameborder="0"></iframe>
</div>

    <!-- container -->
    <div id="container"> 
        <!-- contents -->
		<div id="contents">
			<div class="contsMiddle">
				<!-- contents body -->
				<div class="contBody">
					<!-- title/location -->
					<div class="hgroup">
						<h3><img src="/resources/images/common/h3_01.png" alt="검색식"></h3>
						<div class="localtion">
							<ul>
								<li>홈</li>
								<li><strong>검색식</strong></li>
							</ul>
						</div>
					</div>
					<!-- // title/location -->
					
					<!-- 검색 결과  -->
					<form>
						<fieldset>
						<div class="btnArea2 right">
							<a id="btn_load" href="#" class="btntype1"><span>불러오기</span></a>
							<a id="btn_modify" href="#" class="btntype1"><span>수정</span></a>
							<a id="btn_save" href="#" class="btntype1"><span>신규저장</span></a>
						</div>
						<input id="text_db_type_cd" type="hidden" >
						<input id="text_search_formula" type="hidden" >			
						<div class="searchexpression">
							<p class="btoon" style="text-align:right;margin-top:8px;"><button id="btn_create" type="button" class="btnSmall gray">검색식 생성</button></p>
							
							
							
							
							
							<div class="expressionBox">
								<table style="width:100%;">
									<colgroup>
										<col width="100"/>
										<col width="*"/>
										<col width="100"/>
									</colgroup>
									<tr>
										<td style="padding: 6px 0px 6px 0px;vertical-align:middle;">
									        <table style="width:100%;">
									          <tr>
												<td class="td01" style="padding-left:10px;width:13%;">
													<span id="title">DB 종류</span>
												</td>
												<td style="padding-left:10px;width:70%;padding-right:10px;">
													<select id="db_type">
													</select>
												</td>
												<td style="padding-left:10px;width:17%;">
												</td>
									          </tr>
									        </table>
										</td>
									</tr>
								</table>	
								
								
								<table id="tbl_keyword" style="width:100%;">
									<colgroup>
										<col width="100"/>
										<col width="*"/>
										<col width="100"/>
									</colgroup>
									<tr id="tr_keyword">
										<td>
										  <table style="width:100%;">
										    <tr>
										      <td style="padding: 6px 0px 6px 0px;">
										        <table style="width:100%;">
										          <tr>
													<td style="padding-left:10px;width:13%;">
														<table style="width:100%">
														  <tr>
														    <td class="td01" style="text-align:left;vertical-align:inherit;">
																<span><a id="btn_delete" style="color:red;" href="#">[X]</a></span>
														    </td>
														    <td class="td01" style="text-align:right;vertical-align:inherit">
																<span id="title">키워드</span>
														    </td>
														  </tr>
														</table>
													</td>
													<td style="padding-left:10px;width:70%;padding-right:10px;"><input id="keyword" type="text" style="width:100%;"></td>
													<td style="padding-left:10px;padding-right:6px;width:17%;">
														<select id="field" style="width:100%;">
														</select>
													</td>
										          </tr>
										        </table>
										      </td>
										    </tr>
										    <tr id="tr_parameter">
										      <td style="padding: 6px 0px 6px 0px;">
										        <table style="width:100%;">
										          <tr>
													<td class="td01" style="padding-left:10px;width:13%;">
														<span id="title">#1</span>
													</td>
													<td style="padding-left:10px;width:70%;padding-right:10px;">
														<input id="parameter" type="text" style="width:100%;">
													</td>
													<td style="width:100px;padding-left:10px;">
														<!-- 
														<select id="field" style="width:17%;">
														</select>
														 -->
													</td>
										          </tr>
										        </table>
										      </td>
										    </tr>
										  </table>
										</td>
									</tr>
								</table>
								<div class="btnRight"><a id="btn_add" href="#" class="btntype1"><span>추가</span></a></div>
							</div>
							
							
							
							
							
							<div class="expressionBox">
								<table style="width:100%;">
									<tr>
										<td style="padding: 6px 0px 6px 0px;">
									        <table style="width:100%;">
									          <tr>
												<td class="td01" style="padding-left:10px;width:13%;">
													<span id="title">검색식</span>
												</td>
												<td style="padding-left:10px;width:87%;padding-right:28px;">
													<textarea id="search_formula" style="width:100%;" readonly="readonly" rows=10></textarea>
												</td>
									          </tr>
									        </table>
										</td>
									</tr>
								</table>	
							</div>
							<div class="btnArea right">
								<a id="btn_copy_search_formula" href="#" class="btntype1"><span>복사</span></a>
								<a id="btn_go_to_search_db" href="#" class="btntype1"><span>검색DB 바로가기</span></a>
							</div>
						</div>
						</fieldset>
					</form>
					<!-- //검색결과 -->
					
				</div>
				<!-- //contents body -->

			</div>
		</div>
        <!-- //contents --> 
    </div>
	<!-- //container -->


<%@ include file="/WEB-INF/views/common/bottom.jsp" %>