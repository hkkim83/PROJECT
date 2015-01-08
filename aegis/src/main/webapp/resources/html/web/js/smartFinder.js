/************************************************************************
 * SmartFinder 의 기능을 처리하기 위한 javascript
 * SmartFinder 기능처리가 주된 내용이지만 jquery를 이용한
 * 	이벤트 초기화 작업도 포함되어있음..
 * jquery 1.7.1 & jquery UI 1.8.3
 * 2012.09.21 bhhan
 ************************************************************************/

var sf_stat = "close";

var historyStr = "";
var historyArr = "";
var startHistoryNum = 0;
var maxViewHistoryNum = 7; //기존 5에서 7로 변경 by lhy 2013.03.14
var isAutoScroll = true;  // 자동스크롤 on을 기본값으로 변경 2013.05.23
var btn_ypos = 0;
var global_timer = null;

jQuery(document).ready(function(){

	/****************************************************************************
	 * 자동 스크롤 관련 스크립트 Start
         * 스마트검색 열기 버튼의 위치 조정을 위해 수정하였음. by lhy2013.05.23
	 ****************************************************************************/
        
	// 스마트 파인더 열림/닫힘 상태

	var wrapobj = jQuery("#divSmartFinderWrap");
	var btnobj = jQuery("#divSmartFinderBtn");
	var dummybtnobj = jQuery("#divDummySmartFinderBtn");
	var btn_height = btnobj.height();
	var btn_width = btnobj.width();
	var wrap_height = wrapobj.height();
	wrapobj
		.hide()
		.height(0);
	dummybtnobj.hide();

	var oset = btnobj.offset();
	btn_ypos = oset.top;
	var div_xpos = ($(window).width() - $(wrapobj).width()) / 2;
	//var scrltop = $(this).scrollTop();

	//wrapobj.offset({"top": (btn_ypos + btn_height), "left" : div_xpos});

	/**
	 * 스크롤 상태에 따라서 SmartFinder를 상단에 고정시킴
	 * 2012.09.17 bhhan
	 */
	jQuery(window).scroll(function(){
            
            var scrltop = $(this).scrollTop();
            var xpos= ($(window).width() - btn_width) / 2;
            
            // 자동스크롤 상태에서 열려 있는 경우, 화면상단까지 가지 못하도록 함. by lhy 2013.06.03
            if(sf_stat == "open" && wrapobj.css("position") == "fixed" && 191 > scrltop ){
                    wrapobj.css("top",191 - scrltop);
                    wrapobj.css("z-index",99);
            } else {
                wrapobj.css("top",0);
                wrapobj.css("z-index",100);
            }
            
            if(sf_stat == "open" || isAutoScroll == false)
                    return;

            // 스마트파인더 보기버튼의 원래 위치보다 스크롤이 더 내려온 경우
            if(btn_ypos < scrltop)
            {
                // 화면에 계속 보이도록 버튼위치를 상단에 고정시킨다.                         
                /*
                btnobj.fadeIn("slow")
                        //.css("position", "fixed")
                        .css("position", "relative")
                        .css("z-index", 100)
                        //.css("top", 0)
                        //.css("left", xpos)
                        .css("top", scrltop-192)
                        .css("left", 0)
                        .css("opacity", 0.8);
                */ 
                btnobj.css("position", "relative")
                        .css("z-index", 99)			
                        .css("top", scrltop-192)
                        .css("left", 0)
                        .css("opacity", 0.8)
                        .fadeIn("slow");        
                
                global_timer = ResetTimer(global_timer, btnobj);
                 
            }            
            else // 스마트파인더 보기버튼의 원래 위치보다 스크롤이 위에 있는 경우(기본 위치에 있어야 할 경우)
            {
                // 버튼위치를 원래 위치로 되돌린다.
                btnobj.fadeIn("slow")
                        .css("position", "relative")
                        .css("opacity", 1)
                        //.offset({"top":btn_ypos, "left":xpos});
                        .offset({"top":btn_ypos})
                        .css("left",0);

                global_timer = ClearTimer(global_timer);
                
            }

	});

	jQuery(window).resize(function(){

		var scrltop = $(this).scrollTop();

		// 스마트파인더 보기버튼의 원래 위치보다 스크롤이 더 내려온 경우
		if(btn_ypos < scrltop)
		{
			var xpos= ($(window).width() - btn_width) / 2;
			var pos = btnobj.css("position");
			if(pos == "fixed")
				btnobj.css("left", xpos);

			pos = dummybtnobj.css("position");
			if(dummybtnobj == "fixed")
				dummybtnobj.css("left", xpos);
		}
                
                
                
                 if(is_IE()){
                    dummybtnobj.css("top",9);   
                } else {
                    dummybtnobj.css("top",5);   
                 }
            
            /* 너비가 줄어도 높이 변화가 없으므로 주석 처리 by 2013.12.03 Jak
                // 자동스크롤시 화면이 작아지면 스마트검색닫기 버튼이 아래로 떨어져 top 조절
            
             if(isAutoScroll && $(".btn_area").width() < 930){
                    //dummybtnobj.css("top",15);                    
                    dummybtnobj.css("top",5);                    
                } else {
                    dummybtnobj.css("top",5);
                }
            
             
           
                // 스마트검색이 열린 상태에서 resize가 될때 스마트검색 height 변경 by lhy 2013.08.06
                if (!is_IE()) {
                    if($("#divSmartFinderWrap").width() < 1190) {
                        /*$("#divSmartFinderWrap").height(653);
                        상단 권리구분/행정처리 추가로 길이 증가 시킴 by 2013.10.02 Jak
                         $("#divSmartFinderWrap").height(730);
                    } else {
                      /*  $("#divSmartFinderWrap").height(603);test
                      $("#divSmartFinderWrap").height(680);
                    }
                }
              */  
	});
	
	// 접근성때문에 키보드로 스마트검색 버튼에서 엔터키를 눌렀을때도 동작하도록 수정..
	jQuery("#btnToggleSmartFinder, #btnToggleSmartFinder2").unbind("keypress");
	jQuery("#btnToggleSmartFinder, #btnToggleSmartFinder2").keydown(function(event){
		if(event.keyCode == 13)
		{
			if(jQuery("#ToggleSmartFinder").css("display") != "none")
				jQuery("#ToggleSmartFinder").trigger("click");
			else if(jQuery("#DummySmartFinder").css("display") != "none")
				jQuery("#DummySmartFinder").trigger("click");
		}
	});
	
 	// 스마트 파인더 보기 버튼 토글기능
	jQuery("#ToggleSmartFinder, #DummySmartFinder, #ToggleSmartFinder2").click(function(){

		var scrltop = $(window).scrollTop();
		var xpos= ($(window).width() - btn_width) / 2;

		var pos = btnobj.css("position");
		//alert(pos);
		// 스마트파인더 열기
		if(sf_stat == "close")
		{
                        // 스마트파인더 보기버튼의 원래 위치보다 스크롤이 더 내려온 경우
			//if(pos == "fixed")
                        if(isAutoScroll == true && btn_ypos <= $(window).scrollTop() ) //자동스크롤이 on이고 열기버튼이 스크롤되어 내려온 경우 
			{
                                btnobj.hide();

				dummybtnobj
					.show()
					//.css("position", "fixed")
					//.css("top", 0)                                        
					//.css("left", xpos)
                                        //.css("left",$("#side").width()+20)
					//.animate({"top" : (wrap_height - btn_height) + 8}, 380);
                                        ;                                

                        //창이 작을 경우 원래 위치에서 스마트 검색이 열리도록 수정 by 2013.12.12 Jak
                        if( ($(window).height() < 700)){
                           /*     wrapobj
					.css("z-index", 0)
					.css("position", "relative")
					.show()
					.animate({ height : (wrap_height - btn_height) + 10 }, 380, function(){

                                        });
                             */   
                                $(window).scrollTop(0);
                                wrapobj
					.css("z-index", 0)
					.css("position", "relative");
                                btnobj.css("top", 0);
                                        
                                $("#ToggleSmartFinder").click();
                                        
                        }   else {                                
				wrapobj
					.css("z-index", 100)
					.css("position", "fixed")
					.css("top", 0)
					.show()
					.animate({ height : (wrap_height - btn_height) + 10}, 380, function(){
                                            /* 너비가 줄어들 경우 높이값 변화 없으므로 주석 처리 by 2013.12.03 jak
                                            // 스마트검색의 너비가 줄어들 경우 높이를 늘려줘야 함 by lhy 2013.08.07 
                                            if($("#divSmartFinderWrap").width() < 1190) {
                                                // IE가 아니거나, IE9, IE10이 아닌 경우(IE8이하인 경우) 스마트검색의 높이를 50px 늘려줌. 
                                                 if( !(is_IE() && (navigator.appVersion.indexOf('Trident/5.0') > -1 || navigator.appVersion.indexOf('Trident/6.0') > -1)) ){
                                                    $("#divSmartFinderWrap").height($("#divSmartFinderWrap").height() + 50);
                                                }
                                            }
                                           
                                            if($(".btn_area").width() < 930){
                                                //dummybtnobj.css("top", 15);
                                                // IE9,10 일 경우 위치조정
                                                if( is_IE() && (navigator.appVersion.indexOf('Trident/5.0') > -1 || navigator.appVersion.indexOf('Trident/6.0') > -1) ){
                                                    dummybtnobj.css("top", 10);
                                                } else {
                                                    dummybtnobj.css("top", 15);
                                                }
                                            } else {
                                                dummybtnobj.css("top",5);
                                                }
                                                */
                                                if(is_IE()){
                                                     dummybtnobj.css("top",10);
                                                } else {
                                                     dummybtnobj.css("top",5);
                                                }
                                        });

                                    }

                        }
			// 스마트파인더 보기버튼의 원래 위치보다 스크롤이 위에 있는 경우
                        // 자동스크롤이 off 된 경우
			else
			{
				dummybtnobj.hide();
				wrapobj
					.show()                                        
					.css("position", "relative")
                                        .css("z-index", 0) //자동스크롤 상태에서 스마트검색창을 열 경우 z-index가 100되므로 원래대로 돌림. by lhy 2013.06.02
					.animate({ height : (wrap_height - btn_height) + 10}, 380, function()
					{
						btnobj.show();
                                           /*   높이값이 변화 없으므로 주석 처리 by 2013.12.03 Jak  
                                                if($("#divSmartFinderWrap").width() < 1190) {
                                                    $("#divSmartFinderWrap").height($("#divSmartFinderWrap").height() + 50);
                                                }
                                                */
					});
                                
                                global_timer = ClearTimer(global_timer);
			}

			sf_stat = "open";
			jQuery("#ToggleSmartFinder")
				.prop("alt", "스마트검색 닫기")
				.prop("src", "../images/common/btn_smartfinder_close.gif");
			jQuery("#DummySmartFinder")
				.prop("alt", "스마트검색 닫기")
				.prop("src", "../images/common/btn_smartfinder_close.gif");
                                
                        //스마트검색 이미지 변경에 따라 스마트검색창을 열고 닫을 때 스마트검색 왼쪽버튼 표시 상태 변경함. by lhy 2013.08.06
                        $(".sfinder_btn_left").hide();        

			jQuery("#KW", jQuery("#divSmartFinder")).focus();
		}

		// 스마트파인더 닫기
		else if(sf_stat == "open")
		{
			// 스마트파인더 보기버튼의 원래 위치보다 스크롤이 더 내려온 경우
                        //자동스크롤이 off 
			//if(pos == "fixed")
                        if(isAutoScroll == false || btn_ypos >= $(window).scrollTop()) //자동스크롤이 off 된 경우, 자동스크롤일 경우에도 스크롤이 위에 있으면 원래 위치로.
			{
				//dummybtnobj.show();
				//btnobj.hide();
				wrapobj
					.animate({ height : 8}, 380)
					.animate({ height : 0}, 340, function()
					{
						wrapobj.hide();
						btnobj.show();

						var scrltop_tmp = $(window).scrollTop();
						$(window).scrollTop((scrltop_tmp + 5));

						global_timer = ClearTimer(global_timer);
					});

				/*
                                dummybtnobj
					.animate({"top" : 8}, 380)
					.animate({"top" : 0}, 340, function(){
						dummybtnobj.hide();
						btnobj.show();
				});
                                */

			}
			// 스마트파인더 보기버튼의 원래 위치보다 스크롤이 위에 있는 경우
                        //자동스크롤 on
			else
			{
				// 스마트 파인더 닫기 구현
				//dummybtnobj.hide();
				//btnobj.show();

				wrapobj
					.animate({ height : 8}, 380)
					.animate({ height : 0}, 340, function()
					{
						wrapobj.hide();                                                
					});
                               
                               // 스마트검색 버튼 위치 조정 by lhy 2013.05.23
                               if(btnobj.offset().top <= $(window).scrollTop()){
                                    btnobj.css("top", scrltop-192);
                               }
                                   
                               
                               dummybtnobj
					.animate({"top" : 8}, 380)
					.animate({"top" : 0}, 340, function(){
						dummybtnobj.hide();
						btnobj.show();
				});         

			}
			sf_stat = "close";
			jQuery("#ToggleSmartFinder")
				.prop("alt", "스마트검색 열기")
				.prop("src", "../images/common/btn_smartfinder_open_m.gif");
			jQuery("#DummySmartFinder")
				.prop("alt", "스마트검색 열기")
				.prop("src", "../images/common/btn_smartfinder_open_m.gif");
                                
                        //스마트검색 이미지 변경에 따라 스마트검색창을 열고 닫을 때 스마트검색 왼쪽버튼 표시 상태 변경함. by lhy 2013.08.06
                        $(".sfinder_btn_left").show();        
		}
	});
        
	/****************************************************************************
	 * 자동 스크롤 관련 스크립트 End
	 ****************************************************************************/


	/****************************************************************************
	 * SmartFinder 내부 버튼 이벤트 정의 Start
	 ****************************************************************************/

	// 슬라이드바 초기화
	/*
	jQuery("#slide_bar").slider({
		range: true,
		min : 0,
		max: 20,
		values : [15, 20],
		slide : function(event, ui){
			//$("#SLIDE_FROM").val(ui.values[0]);
			//$("#SLIDE_TO").val(ui.values[1]);
			setSlideDateDuration((20 - ui.values[0]), (20 - ui.values[1]));
		}
	});

	// 슬라이드바 초기값에 따라 텍스트상자에도 기본값을 표시한다.
	var slide_from = jQuery("#slide_bar").slider("values", 0);
	var slide_to = jQuery("#slide_bar").slider("values", 1);
	*/
	//setSlideDateDuration((20 - slide_from), (20 - slide_to));	=> 최초에 아무값도 없게 한다.

	// 날짜 선택 텍스트박스에 DatePicker를 적용한다.
	SetDatePicker(jQuery("input[type='text']", jQuery("#divDatePickArea")), "yymmdd"); //DatePicker 적용
        
        // 현재 사용안해서 주석처리함. 달력버튼 추가시 주석해제 해야함. by lhy 2013.07.25
        // 달력아이콘에 css 적용
        /*
        try{
            $("img.ui-datepicker-trigger").css("vertical-align","middle");
            //달력레이어에 title과 alt추가 by lhy 2013.07.25
            $("img.ui-datepicker-trigger").attr({
                title:'Open calendar layer',
                alt : 'Open calendar layer',
            });
        } catch (e) {}
        */

	jQuery("#btnOnoffNumInfo").bind("click", BindOnoffNumInfo);
	jQuery("#btnOnoffDateInfo").bind("click", BindOnoffDateInfo);
	jQuery("#btnOnoffDirectInput").bind("click", BindOnoffDirectInput);
	jQuery("#btnItemizedSearch").bind("click", BindItemizedSearch);
	jQuery("#btnCyberItemizedSearch").bind("click", BindCyberItemizedSearch);
	jQuery("input[id*='Hangjung']").bind("click", BindHangjungChk);
	jQuery("input[id*='Gubn']").bind("click", BindGubnChk);
//	jQuery("#btnOnoffAutoScroll,#btnDummyOnoffAutoScroll").bind("click", BindOnoffAutoScroll);	
        // pi 출원인 항목 추가 by lhy 2013.06.07
        //jQuery("#ulSortLayer_1,#ulSortLayer_2,#divStatLayerBox_1,#divStatLayerBox_2,#divStatLayerBox_3,#divStatLayerBox_4,#ulSelPatArea").mouseleave(function(){
        jQuery("#ulSortLayer_1,#ulSortLayer_2,#divStatLayerBox_1,#divStatLayerBox_2,#divStatLayerBox_3,#divStatLayerBox_4,#divStatLayerBox_5,#ulSelPatArea")
            .mouseleave(function(){
		$(this).slideUp("fast");
            });
        
        // 시소러스 검색어 확장 버튼
        $("#thsrs_view").bind("click", BindSearchInThsrs);
	/*******************************************************************************
	 * SmartFinder 내부 버튼 이벤트 정의 End
	 *******************************************************************************/


	/*******************************************************************************
	 * 기타 처리 Start
	 *******************************************************************************/
	jQuery(":text, textarea", jQuery("#divSearchItems")).unbind("keypress");
	jQuery(":text, textarea", jQuery("#divSearchItems")).keydown(function(event){
		if(event.keyCode == 13)
		{
			if(jQuery("#SEL_PAT", jQuery("#divSearchItems")).val() == "CYBER"){
                            //placeholder 내용을 숨김.
                            hideplaceholder();
                            
                            DoCyberSearch();
                            
                            //placeholder 내용이 다시 보이도록 처리.
                            showplaceholder();
			} else{
                            //placeholder 내용을 숨김.
                            hideplaceholder();
                            
                            DoSearch();
                            
                            //placeholder 내용이 다시 보이도록 처리.
                            showplaceholder();
                        }
		}
	});

	jQuery(":text", jQuery("#divSmartFinder")).unbind("keypress");
	jQuery(":text", jQuery("#divSmartFinder")).keydown(function(event){
		if(event.keyCode == 13)
		{
			if(jQuery("#SEL_PAT", jQuery("#divSearchItems")).val() == "CYBER")
				//GoCyberItemizedSearch();
                                BindCyberItemizedSearch();                                
			else
				// enter입력시 스마트검색버튼 동작과 같도록 수정 by lhy 2013.02.27
                                //GoItemizedSearch();
                                BindItemizedSearch();
		}
	});

	// textarea가 cols로 지정해놓으면 브라우저 버전마다 크기가 달라지므로..
	jQuery("#keywordTextarea", jQuery("#divSearchItems")).width(430);

	jQuery("#slide_bar").hide();

	// 영역 내의 텍스트 상자 기본 색상을 변경한다.
	jQuery(":text", jQuery("#divSmartFinder"))
		.css("background-color", "#ffffff")
		.focus(function(){
			$(this)
				.css("background-color", "#ffffc0");
			})
		.blur(function(){
			$(this)
				.css("background-color", "#ffffff");
		});

	/*******************************************************************************
	 * 기타 처리 End
	 *******************************************************************************/



	/*******************************************************************************
	 * 일반 버튼 이벤트 정의 Start <= SmartFinder와 관련 없음...
	 *******************************************************************************/

	jQuery("#btnSimpleView").bind("click", BindSimpleView);
	jQuery("#btnTextView").bind("click", BindTextView);
	jQuery("#btnOneplanView").bind("click", BindOneplanView);
	jQuery("#btnAllplanView").bind("click", BindAllplanView);
        
	// pi 출원인 항목 추가 및 공통 함수로 변경 by lhy 2013.06.07
        /*
        jQuery("#btnCloseStatLayerBox_1").bind("click", BindCloseStatLayerBox_1);
	jQuery("#btnCloseStatLayerBox_2").bind("click", BindCloseStatLayerBox_2);
	jQuery("#btnCloseStatLayerBox_3").bind("click", BindCloseStatLayerBox_3);
	jQuery("#btnCloseStatLayerBox_4").bind("click", BindCloseStatLayerBox_4);
        */
        jQuery("#btnCloseStatLayerBox_1").bind("click", function(){BindCloseStatLayerBox("1");});
	jQuery("#btnCloseStatLayerBox_2").bind("click", function(){BindCloseStatLayerBox("2");});
	jQuery("#btnCloseStatLayerBox_3").bind("click", function(){BindCloseStatLayerBox("3");});
	jQuery("#btnCloseStatLayerBox_4").bind("click", function(){BindCloseStatLayerBox("4");});
        jQuery("#btnCloseStatLayerBox_5").bind("click", function(){BindCloseStatLayerBox("5");});
        
	// pi 출원인 항목 추가 및 공통 함수로 변경 by lhy 2013.06.07
        /*
        jQuery("#btnShowStatLayerBox_1").bind("click", BindShowStatLayerBox_1);
	jQuery("#btnShowStatLayerBox_2").bind("click", BindShowStatLayerBox_2);
	jQuery("#btnShowStatLayerBox_3").bind("click", BindShowStatLayerBox_3);
	jQuery("#btnShowStatLayerBox_4").bind("click", BindShowStatLayerBox_4);
        */
        jQuery("#btnShowStatLayerBox_1").bind("click", function(){BindShowStatLayerBox("1");});
	jQuery("#btnShowStatLayerBox_2").bind("click", function(){BindShowStatLayerBox("2");});
	jQuery("#btnShowStatLayerBox_3").bind("click", function(){BindShowStatLayerBox("3");});
	jQuery("#btnShowStatLayerBox_4").bind("click", function(){BindShowStatLayerBox("4");});
        jQuery("#btnShowStatLayerBox_5").bind("click", function(){BindShowStatLayerBox("5");});
        
	jQuery("div[id^='divStatLayerBox_']").bind("click", BindSelStatLayerBox);
	jQuery("#liSort_1").bind("click", BindShowSortLayer_1);
	jQuery("#liSort_2").bind("click", BindShowSortLayer_2);
	jQuery("button[id^='btnSelSortLayer_']").bind("click", BindSelSortLayer);
	jQuery("#btnHistoryPrev").bind("click", BindHistoryPrev);
	jQuery("#btnHistoryNext").bind("click", BindHistoryNext);
	jQuery("#btnKeywordareaOpen").bind("click", BindKeywordareaOpen);
	jQuery("#btnKeywordareaClose").bind("click", BindKeywordareaClose);
        jQuery("#btnViewSelItems").bind("click", BindViewSelItems);
	jQuery("#btnViewAllItems").bind("click", BindViewAllItems);
	jQuery("#btnViewSelectPat").bind("click", BindViewSelectPat);
	jQuery("a[id^='btnSelPat']").bind("click", BindSelectPat);
	jQuery("#spanCheckExtend").bind("click", BindCheckExtend);
	jQuery("#btnClearSmartFinder").bind("click", BindClearSmartFinder);
	
	jQuery("button[id^='divSelSort']")
		.unbind("keypress")
		.bind("keydown", BindSelSortKey);
	jQuery("button[id^='divSelSort']").bind("click", BindSelSortClick);
	
	/*******************************************************************************
	 * 일반 버튼 이벤트 정의 End
	 *******************************************************************************/
         
        // 항목별 예시 표시
        showplaceholder();

});

function BindSelSortKey(event)
{

	if(event.keyCode == 13)
	{
		var idnum = $(this).prop("id").replace(/divSelSort_/g, "");
		
		var open = idnum;
		var close = (idnum == "1") ? "2" : "1";
		jQuery("#ulSortLayer_" + open).slideDown('fast');
		jQuery("#ulSortLayer_" + close).slideUp('fast');
	}
	
}
	
function BindSelSortClick()
{
	var idnum = $(this).prop("id").replace(/divSelSort_/g, "");
	var open = idnum;
	var close = (idnum == "1") ? "2" : "1";
	jQuery("#ulSortLayer_" + open).slideDown('fast');
	jQuery("#ulSortLayer_" + close).slideUp('fast');
}


/**
 * 번호정보영역 여닫기 버튼 이벤트 처리
 * 2012.09.20 bhhan
 */
function BindOnoffNumInfo(){

	var obj = jQuery("#divNumInfoArea");

	if(obj.css("display") == "none")
	{
		obj.slideDown("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wclose.gif");
	}
	else if(obj.css("display") == "block")
	{
		obj.slideUp("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wopen.gif");
	}

}


/**
 * 일자정보영역 여닫기 버튼 이벤트 처리
 * 2012.09.20 bhhan
 */
function BindOnoffDateInfo(){

	var obj = jQuery("#divDateInfo");

	if(obj.css("display") == "none")
	{
		obj.slideDown("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wclose.gif");
	}
	else if(obj.css("display") == "block")
	{
		obj.slideUp("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wopen.gif");
	}


}

/**
 * 직접입력영역 여닫기 버튼 이벤트 처리
 * 2012.09.20 bhhan
 */
function BindOnoffDirectInput(){

	var obj = jQuery("#divDirectInput");

	if(obj.css("display") == "none")
	{
		obj.slideDown("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wclose.gif");
	}
	else if(obj.css("display") == "block")
	{
		obj.slideUp("fast");
		ImgobjSwapImage($(this), "/images/button/btn_Wopen.gif");
	}
}

/**
 * 스마트파인더 Search 버튼 이벤트 처리 (특허 실용신안)
 * 2012.09.20 bhhan
 */
function BindItemizedSearch(){
    //스마트검색시 북마크를 초기화 시킨다.
    jQuery("#FROM", jQuery("#divSearchItems")).val("");
    jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val("");
    
    //placeholder 내용이 안보이도록 함.
    hideplaceholder();    
    
    // 검색시작
    GoItemizedSearch();
    
    // 상단 검색창 by lhy 2013.10.22
    if($("#queryText").val() != "") {        
        $("#ol_queryTextlabel").hide(); 
    }
    
    //placeholder 내용이 다시 보이도록 처리.
    showplaceholder();
    
}

/**
 * 스마트파인더 Search 버튼 이벤트 처리 (인터넷 기술 공지)
 * 2012.09.20 bhhan
 */
function BindCyberItemizedSearch(){
        //placeholder 내용을 숨기도록 함
        hideplaceholder();
        
	GoCyberItemizedSearch();
        
        //placeholder 내용이 다시 보이도록 처리.
        showplaceholder();
}

/**
 * 행정처리 체크박스 "전체" 버튼과 관련된 버튼 이벤트 처리
 * 2012.09.20 bhhan
 */
function BindHangjungChk()
{
	var checkval = $(this).prop("checked");
	
	var id = $(this).prop("id");

	id = id.replace(/smartHangjung/g, "");
	id = id.replace(/leftHangjung/g, "");
	
	switch($(this).val())
	{
		case "0" :
			jQuery("input[id^='smartHangjung']", jQuery("#divSmartFinder")).prop("checked", checkval);
			jQuery("input[id^='leftHangjung']", jQuery("#divLeftSide")).prop("checked", checkval);
			break;
		default :
			jQuery("input[id='smartHangjung" + id + "']", jQuery("#divSmartFinder")).prop("checked", checkval);
			jQuery("input[id='leftHangjung" + id + "']", jQuery("#divLeftSide")).prop("checked", checkval);
			if(checkval == false)
			{
				jQuery("input[id^='smartHangjung']:first", jQuery("#divSmartFinder")).prop("checked", false);
				jQuery("input[id^='leftHangjung']:first", jQuery("#divLeftSide")).prop("checked", false);
			}
	}

}

/**
 * 권리구분 체크박스 관련된 버튼 이벤트 처리
 * 2012.09.20 bhhan
 */
function BindGubnChk()
{
	var checkval = $(this).prop("checked");
	var id = $(this).prop("id");

	id = id.replace(/smartGubn/g, "");
	id = id.replace(/leftGubn/g, "");

	jQuery("input[id='smartGubn" + id + "']").prop("checked", checkval);
	jQuery("input[id='leftGubn" + id + "']").prop("checked", checkval);

}

/**
 * 선택보기 - 이미지보기 버튼 이벤트 처리
 * 2012.09.24 bhhan
 */
function BindSimpleView()
{
	if(jQuery("#queryText", jQuery("#divSearchItems")).val() == "" && jQuery("#expression", jQuery("#divSearchItems")).val() == "")
	{
		alert("검색어를 입력하십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
		return;
	}
	
	if(jQuery(".search_nodata").length > 0)
	{
		alert("먼저 기본검색(상단검색, 스마트검색)을 하신 후에 사용해주십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}

	jQuery("#btnSimpleView").removeClass("img_view").addClass("img_view_on");
	jQuery("#btnTextView").removeClass("txt_view_on").addClass("txt_view");
	jQuery("#btnOneplanView").removeClass("onePlan_view_on").addClass("onePlan_view");
	jQuery("#btnAllplanView").removeClass("allPlan_view_on").addClass("allPlan_view");
	//jQuery("div[id^='divRealContent']").removeClass("noimg_list");

	toMoveNext("SimpleList");
}

/**
 * 선택보기 - 텍스트보기 버튼 이벤트 처리
 * 2012.09.24 bhhan
 */
function BindTextView()
{
	if(jQuery("#queryText").val() == "" && jQuery("#expression").val() == "")
	{
		alert("검색어를 입력하십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}

	if(jQuery(".search_nodata").length > 0)
	{
		alert("먼저 기본검색(상단검색, 스마트검색)을 하신 후에 사용해주십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}
	
	jQuery("#btnSimpleView").removeClass("img_view_on").addClass("img_view");
	jQuery("#btnTextView").removeClass("txt_view").addClass("txt_view_on");
	jQuery("#btnOneplanView").removeClass("onePlan_view_on").addClass("onePlan_view");
	jQuery("#btnAllplanView").removeClass("allPlan_view_on").addClass("allPlan_view");
	//jQuery("div[id^='divRealContent']").addClass("noimg_list");

	toMoveNext("TextList");
}

/**
 * 선택보기 - 대표도면보기 버튼 이벤트 처리
 * 2012.09.24 bhhan
 */
function BindOneplanView()
{
	if(jQuery("#queryText").val() == "" && jQuery("#expression").val() == "")
	{
		alert("검색어를 입력하십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}
	
	if(jQuery(".search_nodata").length > 0)
	{
		alert("먼저 기본검색(상단검색, 스마트검색)을 하신 후에 사용해주십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}

	jQuery("#btnSimpleView").removeClass("img_view_on").addClass("img_view");
	jQuery("#btnTextView").removeClass("txt_view_on").addClass("txt_view");
	jQuery("#btnOneplanView").removeClass("onePlan_view").addClass("onePlan_view_on");
	jQuery("#btnAllplanView").removeClass("allPlan_view_on").addClass("allPlan_view");

	toMoveNext("ImageList");
}

/**
 * 선택보기 - 일괄보기 버튼 이벤트 처리
 * 2012.09.24 bhhan
 */
function BindAllplanView()
{
	if(jQuery("#queryText").val() == "" && jQuery("#expression").val() == "")
	{
		alert("검색어를 입력하십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}

	if(jQuery(".search_nodata").length > 0)
	{
		alert("먼저 기본검색(상단검색, 스마트검색)을 하신 후에 사용해주십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
                return;
	}
	
	jQuery("#btnSimpleView").removeClass("img_view_on").addClass("img_view");
	jQuery("#btnTextView").removeClass("txt_view_on").addClass("txt_view");
	jQuery("#btnOneplanView").removeClass("onePlan_view_on").addClass("onePlan_view");
	jQuery("#btnAllplanView").removeClass("allPlan_view").addClass("allPlan_view_on");

	toMoveNext("AllImageList");
}


/**
 * 분류통계 레이어1 감추기
 * 2012.10.04 bhhan
 */
function BindCloseStatLayerBox_1()
{
	jQuery("#divStatLayerBox_1").slideUp('fast');        
}

/**
 * 분류통계 레이어2 감추기
 * 2012.10.04 bhhan
 */
function BindCloseStatLayerBox_2()
{
	jQuery("#divStatLayerBox_2").slideUp('fast');
}

/**
 * 분류통계 레이어3 감추기
 * 2012.10.04 bhhan
 */
function BindCloseStatLayerBox_3()
{
	jQuery("#divStatLayerBox_3").slideUp('fast');
}

/**
 * 분류통계 레이어4 감추기
 * 2012.10.04 bhhan
 */
function BindCloseStatLayerBox_4()
{
	jQuery("#divStatLayerBox_4").slideUp('fast');
}

//분류통계 레이어 감추기 - 공통 by lhy 2013.06.07
function BindCloseStatLayerBox(divNum){
	jQuery("#divStatLayerBox_" + divNum).slideUp('fast');
}

//분류통계 레이어 보이기 - 공통 by lhy 2013.06.07
function BindShowStatLayerBox(divNum){
	jQuery("div[id^='divStatLayerBox_']").slideUp('fast');
	if(jQuery("#divStatLayerBox_" + divNum).css("display") == "none")
		jQuery("#divStatLayerBox_" + divNum).slideDown('fast');
}

/**
 * 분류통계 레이어1 보이기
 * 2012.10.04 bhhan
 */
function BindShowStatLayerBox_1()
{
	jQuery("div[id^='divStatLayerBox_']").slideUp('fast');
	if(jQuery("#divStatLayerBox_1").css("display") == "none")
		jQuery("#divStatLayerBox_1")
//			.prop("z-index", 88)
			.slideDown('fast');
}

/**
 * 분류통계 레이어2 보이기
 * 2012.10.04 bhhan
 */
function BindShowStatLayerBox_2()
{
	jQuery("div[id^='divStatLayerBox_']").slideUp('fast');
	if(jQuery("#divStatLayerBox_2").css("display") == "none")
		jQuery("#divStatLayerBox_2")
//			.prop("z-index", 88)
			.slideDown('fast');
}

/**
 * 분류통계 레이어3 보이기
 * 2012.10.04 bhhan
 */
function BindShowStatLayerBox_3()
{
	jQuery("div[id^='divStatLayerBox_']").slideUp('fast');
	if(jQuery("#divStatLayerBox_3").css("display") == "none")
		jQuery("#divStatLayerBox_3")
//			.prop("z-index", 88)
			.slideDown('fast');
}

/**
 * 분류통계 레이어4 보이기
 * 2012.10.04 bhhan
 */
function BindShowStatLayerBox_4()
{
	jQuery("div[id^='divStatLayerBox_']").slideUp('fast');
	if(jQuery("#divStatLayerBox_4").css("display") == "none")
		jQuery("#divStatLayerBox_4")
//			.prop("z-index", 88)
			.slideDown('fast');
}


/**
 * 분류통계 레이어의 연도를 클릭했을때 이벤트 처리
 * 2012.10.04 bhhan
 * @param event
 */
function BindSelStatLayerBox(event)
{
	var target = $(event.target);
        var fullName = "";
        var apCode = "";

	jQuery("ul > li").removeClass("point01");

	//if(target.is("li") || target.is("em"))
	if(target.is("li") || target.is("button"))
	{
            if(target.prop("class") == "btn_layer_close")
                    return;
            
            if(target.is("li")) {
                target.addClass("point01");
                fullName = target.children().attr("title");
                apCode = target.children().attr("id");
            }
            //else if(target.is("em"))
            else if(target.is("button")) {
                target.parent().addClass("point01");
                fullName = target.attr("title");
                apCode = target.attr("id");
            }        
                    
            if(isChildOf(target, "divStatLayerBox_1"))
                goStatYear(1, target.text());
            else if(isChildOf(target, "divStatLayerBox_2"))
                goStatYear(2, target.text());
            else if(isChildOf(target, "divStatLayerBox_3"))
                goStatYear(3, target.text());
            else if(isChildOf(target, "divStatLayerBox_4"))
                goStatYear(4, target.text());
            // pi 출원인 항목 추가 by lhy 2013.06.07
            else if(isChildOf(target, "divStatLayerBox_5"))
                goStatYear(5, fullName, apCode);        
	}

}


/**
 * 분류통계에서 연도를 선택했을때 선택된 연도를 표시하고 연도에 해당하는 통계결과를 조회한다.
 * 2012.10.04 bhhan
 * @param didx_ : 몇번째 레이어인지
 * @param yr_ : 선택된 연도
 * @param apCode : 선택된 출원인코드
 */
function goStatYear(didx_, yr_, apCode)
{
	var yr = yr_.length > 4 ? yr_.substr(0, 4) : yr_;

	jQuery("span[id^='spanSelArea_']").html("");

	jQuery("div[id^='divStatLayerBorder_']")
		.removeClass("year_area year_on")
		.addClass("year_area");

	//jQuery("li :eq()", jQuery("#divStatLayerBox_" + didx_))

	jQuery("#divStatLayerBorder_" + didx_).removeClass("year_area").addClass("year_area year_on");

	jQuery("#divStatLayerBox_" + didx_).hide();

	switch(didx_)
	{
		case 1 :
				jQuery("span[id='spanSelArea_1']").html("<em class=\"txt_bold\">" + yr + "년 </em>");
				pisearch(yr, "GDP");
				break;
		case 2 :
				jQuery("span[id='spanSelArea_2']").html("<em class=\"txt_bold\">" + yr + "년 </em>");
				pisearch(yr, "ODP");
				break;
		case 3 :
				jQuery("span[id='spanSelArea_3']").html("<em class=\"txt_bold\">" + yr + "년 </em>");
				pisearch(yr, "ADP");
				break;
		case 4 :
				jQuery("span[id='spanSelArea_4']").html("<em class=\"txt_bold\">" + yr + " </em>");
				pisearch(yr, "IPC");
				break;
                case 5 :
				jQuery("span[id='spanSelArea_5']").html('<em class="txt_bold" title="' + yr_ + '\">' + yr_.substr(0, 6) + '</em>');
				//pisearch(yr_, "APV");
                                pisearch(apCode, "APC"); //영문명이 아닌 실제 출원인코드를 넣어야 함. by lhy 2013.06.13
				break;                
	}

}

/**
 * 분류통계 검색 결과 넣기 
 * 2013.06.10 lhy
 */
function getPIList(jsonpost) {
    jsonpost.next = "PIResult";
    jsonpost.method = "PIList";
    jsonpost.ajaxYn = "Y";
    
    $.ajax({
		url : "/kpat/piResulta.do",
		type : "post",
		data : jsonpost,
		async : true,
		cache : true,
		dataType: "json",
		success : function(data)
		{
                    //분류통계 조회가 끝나면 화면에 뿌려준다.
                    try{
                        jQuery("ul", jQuery("#divStatLayerBox_1"))
                                .empty()
                                .html(makePIHtml("GDP",data.GDP));
                        jQuery("ul", jQuery("#divStatLayerBox_2"))
                                .empty()
                                .html(makePIHtml("ODP",data.ODP));
                        jQuery("ul", jQuery("#divStatLayerBox_3"))
                                .empty()
                                .html(makePIHtml("ADP",data.ADP));
                        jQuery("ul", jQuery("#divStatLayerBox_4"))
                                .empty()
                                .html(makePIHtml("IPC",data.IPC));
                        jQuery("ul", jQuery("#divStatLayerBox_5"))
                                .empty()
                                .html(makePIHtml("APC",data.APC));
                            
                     } catch (e) {
                        
                     }
		},
		error : function(e1, e2)
		{
			hideLoadingBar();
                        //alert("분류통계 검색 중 오류가 발생했습니다.\n" + e1 + "\n" + e2);
		}
	});
    
}

//분류통계 결과 html 생성하기
function makePIHtml(part, jsonData){
    var returnStr = "";

    for(var i = 0;i < jsonData.length ; i++ ){        
        if(part == "APC"){
            var fldNmEnit = "";
            if(jsonData[i].fldNm.length > 9){
                fldNmEnit = jsonData[i].fldNm.substring(0,8).trim() + "..."; 
            } else {
                fldNmEnit = jsonData[i].fldNm;
            }
            returnStr += '<li class="long"><button type="button" class="txt_bold" title="' + jsonData[i].fldNm + '" id="' + jsonData[i].apCode + '" >' + fldNmEnit + '</button>(' + jsonData[i].hitCnt + ')</li>';
        } else {
            returnStr += '<li><button type="button" class="txt_bold">' + jsonData[i].fldNm + '</button>(' + jsonData[i].hitCnt + ')</li>';
        }
    }

    return returnStr;
}

/**
 * 1번 정렬 레이어 보이기
 * 2012.10.04 bhhan
 */
function BindShowSortLayer_1(event)
{
	var target = $(event.target);
	if(target.is("button"))
		BindSortOrderProc(1, target);

	else
	{
		if(jQuery("#ulSortLayer_1").css("display") == "none")
			jQuery("#ulSortLayer_1").slideDown('fast');
		else
			jQuery("#ulSortLayer_1").slideUp('fast');
		jQuery("#ulSortLayer_2").slideUp('fast');
	}
}

/**
 * 2번 정렬 레이어 보이기
 * 2012.10.04 bhhan
 */
function BindShowSortLayer_2(event)
{
	var target = $(event.target);
	if(target.is("button"))
		BindSortOrderProc(2, target);

	else
	{
		jQuery("#ulSortLayer_1").slideUp('fast');
		if(jQuery("#ulSortLayer_2").css("display") == "none")
			jQuery("#ulSortLayer_2").slideDown('fast');
		else
			jQuery("#ulSortLayer_2").slideUp('fast');
	}
}

/**
 * 정렬레이어에 있는 정렬값을 선택한 경우 처리
 */
function BindSelSortLayer()
{
	var sortfield1 = jQuery("#sortField1", jQuery("#divSearchItems"));
	var sortfield2 = jQuery("#sortField2", jQuery("#divSearchItems"));
	var fldname = DefSortFieldName($(this).text());

	if(isChildOf($(this), "ulSortLayer_1"))
	{
		if($(this).text() != "선택" && sortfield2.val() == fldname)
		{
			alert("아래에서 이미 선택된 정렬 필드입니다.");
			return;
		}
		
		jQuery("#divSelSort_1").text($(this).text());
		jQuery("#ulSortLayer_1").slideUp('fast');
		
		// 선택을 선택한 경우
		if($(this).text() == "선택")
		{
			jQuery("#spanSortOrderAsc_1").removeClass("btn_up_on").addClass("btn_up");
			jQuery("#spanSortOrderDesc_1").removeClass("btn_down_on").addClass("btn_down");
			sortfield1.val("");
			jQuery("#sortState1", jQuery("#divSearchItems")).val("");
			return;
		}
		else
		{
			jQuery("#spanSortOrderAsc_1").removeClass("btn_up").addClass("btn_up_on");
			jQuery("#spanSortOrderDesc_1").removeClass("btn_down_on").addClass("btn_down");
                        sortfield1.val(fldname);
			jQuery("#sortState1", jQuery("#divSearchItems")).val("ASC");
                        jQuery("#btnSortOrderAsc_1").focus(); // 오름차순으로 포커스 이동되도록 수정 cjb 2013.03.29
		}
	}
	else if(isChildOf($(this), "ulSortLayer_2"))
	{
		if(sortfield1.val() == "Score" || sortfield1.val() == "")
		{
			alert("1단계 정렬값을 먼저 선택하십시오");
			return;
		}
		
		if((sortfield1.val() == "Score" && fldname == "ANS") || sortfield1.val() == fldname)
		{
			alert("위에서 이미 선택된 정렬 필드입니다.");
			return;
		}
		
		jQuery("#divSelSort_2").text($(this).text());
		jQuery("#ulSortLayer_2").slideUp('fast');

		// 선택을 선택한 경우
		if($(this).text() == "선택")
		{
			jQuery("#spanSortOrderAsc_2").removeClass("btn_up_on").addClass("btn_up");
			jQuery("#spanSortOrderDesc_2").removeClass("btn_down_on").addClass("btn_down");
			sortfield2.val("");
			jQuery("#sortState2", jQuery("#divSearchItems")).val("");
		}
		else
		{
			jQuery("#spanSortOrderAsc_2").removeClass("btn_up").addClass("btn_up_on");
			jQuery("#spanSortOrderDesc_2").removeClass("btn_down_on").addClass("btn_down");
			sortfield2.val(fldname);
			jQuery("#sortState2", jQuery("#divSearchItems")).val("ASC");
                        jQuery("#btnSortOrderAsc_2").focus(); // 오름차순으로 포커스 이동되도록 수정 cjb 2013.03.29
		}
	}
}

/**
 * 오름/내림차순 정렬 활성화 버튼을 클릭한 경우 처리
 */
function BindSortOrderProc(idx_, obj_)
{
	var id = obj_.prop("id");

	var btnasc = jQuery("#spanSortOrderAsc_" + idx_);
	var btndesc = jQuery("#spanSortOrderDesc_" + idx_);
	var hidsstate = jQuery("#sortState" + idx_, jQuery("#divSearchItems"));
	var hidsfield = jQuery("#sortField" + idx_, jQuery("#divSearchItems"));


	if(id.indexOf("Asc") > 0)
	{
		// 오름차순버튼 활성화 시
		if(btnasc.prop("class") == "btn_up")
		{
			if(jQuery("#divSelSort_" + idx_).text() == "선택")
			{
				alert("먼저 정렬항목을 선택해주십시오.");
				return;
			}

			btnasc.removeClass("btn_up").addClass("btn_up_on");
			btndesc.removeClass("btn_down_on").addClass("btn_down");
			hidsstate.val("ASC");
		}
		// 오름차순버튼 비활성화 시
		else
		{
			jQuery("#divSelSort_" + idx_).text("선택");
			btnasc.removeClass("btn_up_on").addClass("btn_up");
			hidsfield.val("");
			hidsstate.val("");
		}
	}
	else if(id.indexOf("Desc") > 0)
	{
		// 내림차순버튼 활성화 시
		if(btndesc.prop("class") == "btn_down")
		{
			if(jQuery("#divSelSort_" + idx_).text() == "선택")
			{
				alert("먼저 정렬항목을 선택해주십시오.");
				return;
			}

			btnasc.removeClass("btn_up_on").addClass("btn_up");
			btndesc.removeClass("btn_down").addClass("btn_down_on");
			hidsstate.val("DESC");
		}
		// 내림차순버튼 비활성화 시
		else
		{
			jQuery("#divSelSort_" + idx_).text("선택");
			btndesc.removeClass("btn_down_on").addClass("btn_down");
			hidsfield.val("");
			hidsstate.val("");
		}
	}
	else return;
}

/**
 * 히스토리 이전검색어 표시
 * 2012.11.06 bhhan
 */
function BindHistoryPrev()
{
	var fr = (startHistoryNum - 1) < 0 ? 0 : startHistoryNum - 1;
	showHistoryStr(fr);

	jQuery("a[id^=btnHistory]")
		.unbind("click")
		.bind("click", BindHistoryGo);

}

/**
 * 히스토리 다음검색어 표시
 * 2012.11.06 bhhan
 */
function BindHistoryNext()
{
	if(historyStr.trim() == "")
		return;

	if(historyArr.length <= 3)
		return;

	fr = (startHistoryNum + 1) > (historyArr.length - 3) ? (historyArr.length - 3) : (startHistoryNum + 1);
	showHistoryStr(fr);

	jQuery("a[id^=btnHistory]")
		.unbind("click")
		.bind("click", BindHistoryGo);
}

/**
 * 히스토리 검색어 클릭 바인드 함수
 * 2012.11.06 bhhan
 */
function BindHistoryGo()
{
	var id = $(this).prop("id");
	idnum = parseInt(id.replace(/btnHistory/g, ""));
	idnum = historyArr.length - (idnum + 1);
	var histstr = historyArr[idnum];

	var start = histstr.indexOf("title='");
	histstr = histstr.substr((start + 7), histstr.length);
	var end = histstr.indexOf("'");
	histstr = histstr.substr(0, end);

	//alert(histstr);
	//var histstr = historyArr[idnum].replace(/<[^<|>]*>/g, "");	// 태그삭제

	jQuery("#queryText", jQuery("#divSearchItems")).val(histstr);
        
        // 상단 검색창 placeholder 삭제 by lhy 2013.10.22
        $("#ol_queryTextlabel").hide(); 
}

/**
 * 검색어 텍스트영역 펼치기 클릭 바인드 함수
 * 2012.11.06 bhhan
 */
function BindKeywordareaOpen()
{
	var txtareadiv = jQuery("#divKeywordTextarea", jQuery("#divSearchItems"));
	var txtareaobj = jQuery("#keywordTextarea", jQuery("#divSearchItems"));
	var txtobj = jQuery("#queryText", jQuery("#divSearchItems"));
	var stat = txtareadiv.css("display");

	if(stat == "none")
	{
		txtareadiv.show();

		txtareaobj			
                        .text(txtobj.val())
                        //긴 검색식의 value에도 입력하도록 수정, 크롬이나 파이어폭스에서 작동이 안되었음 by lhy 2013.04.02
                        .val(txtobj.val())
			.focus();

		txtobj
			.prop("readOnly", true)
			.val("");

		$(this)
			//.removeClass("btn_keyword_open")
			//.addClass("btn_keyword_close");
                        .addClass("btn_keyword_open");
	}
/*
	else
	{
		txtobj
			.prop("readOnly", false)
			.val(txtareaobj.text())
			.focus();

		txtareaobj.text("");
		txtareadiv.hide();

		$(this)
			.removeClass("btn_keyword_close")
			.addClass("btn_keyword_open");

	}
*/
}

function BindKeywordareaClose(){
    
    var txtareadiv = jQuery("#divKeywordTextarea", jQuery("#divSearchItems"));
    var txtareaobj = jQuery("#keywordTextarea", jQuery("#divSearchItems"));
    var txtobj = jQuery("#queryText", jQuery("#divSearchItems"));
    var stat = txtareadiv.css("display");
    
    if(stat != "none"){
        txtobj
            .prop("readOnly", false)
            //.val(txtareaobj.text()) 긴 검색식의 value을 입력하도록 수정 by lhy 2013.04.02            
            .val(txtareaobj.val())
            .focus();

        txtareaobj.text("");
        txtareadiv.hide();

        $(this)
            //.removeClass("btn_keyword_close")
            .addClass("btn_keyword_open");
    }
}


/**
 * 자동스크롤 클릭 바인드 함수
 * 2012.11.07 bhhan
 */
function BindOnoffAutoScroll() {
        // 자동스크롤 끄기
	if(isAutoScroll)
	{
		jQuery("#btnDummyOnoffAutoScroll")
			.prop("alt", "자동스크롤 켜기")
			.prop("src", "/images/common/txt_Cscroll_play.gif");
		jQuery("#btnOnoffAutoScroll")
			.prop("alt", "자동스크롤 켜기")
			.prop("src", "/images/common/txt_Cscroll_play.gif");


		// 버튼위치를 원래 위치로 되돌린다.
		var btnobj = jQuery("#divSmartFinderBtn");
		var pos = btnobj.css("position");

		//자동스크롤시에 position을 relative로 바꿔서 조건을 변경하고 위치 조정함. by lhy 2013.05.24                
                //if(pos == "fixed")
                if(btnobj.offset().top <= $(window).scrollTop())
		{
			var btn_xpos= ($(window).width() - btnobj.width()) / 2;
			btnobj.fadeOut("slow", function(){
                                btnobj
					.show()
					.css("position", "relative")
                                        .css("z-index", 0)
					.css("opacity", 1)
					//.offset({"top" : btn_ypos, "left" : btn_xpos});
                                        .offset({"top":btn_ypos})
                                        .css("left",0);
			});
		}
                
		global_timer = ClearTimer(global_timer);
	}	
	else // 자동스크롤 켜기
	{
		jQuery("#btnDummyOnoffAutoScroll")
			.prop("alt", "자동스크롤 끄기")
			.prop("src", "../images/common/txt_Cscroll_stop.gif");
		jQuery("#btnOnoffAutoScroll")
			.prop("alt", "자동스크롤 끄기")
			.prop("src", "../images/common/txt_Cscroll_stop.gif");
	}

	isAutoScroll = !isAutoScroll;
}



/////////////////////////////////////////////////////////////
// 북마크 기능 관련 함수 Start
/////////////////////////////////////////////////////////////

/**
 * 선택보기 버튼 클릭 바인드 함수 : 북마크 기능
 * 2012.11.07 bhhan
 */
function BindViewSelItems() 
{
	
	if(jQuery("#queryText", jQuery("#divSearchItems")).val() == "" && jQuery("#expression", jQuery("#divSearchItems")).val() == "")
	{
		alert("검색어를 입력하십시오.");
		jQuery("#queryText", jQuery("#divSearchItems")).focus();
		return;
	}
	
	if(jQuery(".search_nodata").length > 0)
	{
		alert("먼저 기본검색(상단검색, 스마트검색)을 하신 후에 사용해주십시오.");
		return;
	}

	var chklen = jQuery(":checked", jQuery("article[id^='divViewSel']")).length;
	if(chklen == 0 && jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val() == "")
	{
		alert("선택보기하실 항목을 선택하신 후에 사용해주십시오.");
		return;
	}
	
	jQuery("#showAllCheckArticleBtnContainer").show() ;
	jQuery("#showOnlyCheckArticleBtnContainer").hide() ;
	
	jQuery("#currentPage", jQuery("#divSearchItems")).val("1");
	jQuery("#FROM", jQuery("#divSearchItems")).val("BOOKMARK");
	//jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val("1020090082321,1020107001144 ");
	jQuery("#BOOKMARK", jQuery("#divSearchItems")).val(jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val());
	
	var artPost = getPostAllData("divSearchItems");
	//alert(artPost.strstat);
        
        //인터넷 기술공지,특실 모두 resulta.do로 이동 하므로 구별해서 각각 CyberResultA.do와 resulta.do로 구별해서 이동 하도록 변경 by 2013.06.20 Jak
        if( jQuery("#SEL_PAT", jQuery("#divSearchItems")).val() == "CYBER"){
            AjaxResultLoad("/kpat/cyberResulta.do", artPost); 
        } else{
            AjaxResultLoad("/kpat/resulta.do", artPost);
        }
         //AjaxResultLoad("/kpat/resulta.do", artPost);
    
}

/**
 * 스마트 검색 화면 초기화 (스마트검색에 이미 입력된 검색값을 모두 지우고 검색화면을 초기화한다.)
 * 2012.12.12 bhhan  
 */
function BindClearSmartFinder()
{
	jQuery("input[type='hidden'], :text", jQuery("#divSmartFinder")).val("");
	jQuery("select[id^='operate']", jQuery("#divSmartFinder")).val("and");
	jQuery("#nowTab_sep", jQuery("#divSmartFinder")).prop("checked", true);
	jQuery("input[name='COLLECTION']").each(function(){
		if($(this).prop("id") == "US" || $(this).prop("id") == "EP") 
			$(this).prop("checked", true);
		else
			$(this).prop("checked", false);
	});
}


/**
 * 전체보기 버튼 클릭 바인드 함수 : 북마크 초기화 기능
 * 2012.11.07 bhhan
 */
function BindViewAllItems() 
{

	jQuery("#showOnlyCheckArticleBtnContainer").show() ;
	jQuery("#showAllCheckArticleBtnContainer").hide() ;
	
	jQuery("#FROM", jQuery("#divSearchItems")).val("");
	//jQuery("#BOOKMARK", jQuery("#divSearchItems")).val("");
	
	var artPost = getPostAllData("divSearchItems");
	//alert(artPost.strstat);
        
        //인터넷 기술공지,특실 모두 resulta.do로 이동 하므로 구별해서 각각 CyberResultA.do와 resulta.do로 구별해서 이동 하도록 변경 by 2013.06.20 Jak
        if( jQuery("#SEL_PAT", jQuery("#divSearchItems")).val() == "CYBER"){
            AjaxResultLoad("/kpat/cyberResulta.do", artPost); 
        } else {
            AjaxResultLoad("/kpat/resulta.do", artPost);
        }
      //  AjaxResultLoad("/kpat/resulta.do", artPost);
}



/**
 * 전체선택체크 버튼 바인드 함수
 * 2013.02.04 bhhan
 */
function BindSelItemChkAll() 
{
	var anlist = "";
        jQuery("input[name='chkSelItem']").prop("checked", $(this).prop("checked"));

        // 체크시 전체값을 북마크에 넣어줌, unchecked시 값 삭제. by lhy 2013.02.27        
        if($(this).prop("checked")){
            $.each($("input[name='chkSelItem']"), function(i,v){
                //this.prop("checked","checked");
                anlist += $(v).val() + ",";
            });
            if(anlist.charAt(anlist.length-1) == ","){
                    anlist = anlist.substring(0, anlist.length-1);
            }
            $("#NWBOOKMARK", $("#divSearchItems")).val(anlist);
            
        } else {
            $("#NWBOOKMARK", $("#divSearchItems")).val("");
        }
}


/**
 * 항목선택 체크 버튼 바인드 함수 => 북마크 value 처리
 * 2013.02.06 bhhan
 */
function BindSelItemChk()
{
	var an = $(this).prop("id");
	an = an.replace(/chkSelItem/g, "");
	
	var anlist = jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val();

	// 체크면 북마크 추가
	if($(this).prop("checked"))
	{
		anlist += (((anlist == "") ? "" : ",") + an);	
	}
	
	// 체크해제면 북마크 삭제
	else
	{
		// start lhy 2013.02.27
                // 여러개를 선택했다가 마지막것을 선택취소하면 지워지지 않음
                // 여러개가 있을 경우 ","가 들어가는데 마지막 리스트에는 ","가 붙지 않아서 삭제가 안됨.
                // 번호를 지우고 ",,"는 ","로 치환하도록 함.
                //var rex = anlist.indexOf(",") >= 0 ? an + "," : an;
		//var reg = new RegExp(rex, "g");
		//anlist = anlist.replace(reg, "");                
                anlist = anlist.replace(an+ ",", ""); //뒤에 값이 있을 경우 "," 함께 삭제
                anlist = anlist.replace(an, ""); // 마지막 값일 경우 삭제
                //if(anlist.indexOf(",") == anlist.length-1){
                if(anlist.charAt(anlist.length-1) == ","){
                    anlist = anlist.substring(0, anlist.length-1);
                }
                // end
                 
	}
	
	jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val(anlist);
}


/**
 * 북마크에 선택된 항목에 체크 표시하기
 * 2013.02.06 bhhan
 */
function loadBookmarkChk()
{
	var anlist = jQuery("#NWBOOKMARK", jQuery("#divSearchItems")).val();
	
	var anarr = anlist.split(",");
	
	for(var i = 0; i < anarr.length ; i++)
	{
		if(isExistObj(jQuery("#chkSelItem" + anarr[i])))
			jQuery("#chkSelItem" + anarr[i]).prop("checked", true);
	}
	 
}

/**
 * 북마크보기가 아니면 북마크보기 버튼을 원래상태로 되돌린다..
 * 2013.02.06 bhhan
 */
function initViewAllItems()
{
	if(jQuery("#FROM", jQuery("#divSearchItems")).val() != "BOOKMARK")
	{
		jQuery("#showOnlyCheckArticleBtnContainer").show();
		jQuery("#showAllCheckArticleBtnContainer").hide();
	}
}


/////////////////////////////////////////////////////////////
//북마크 기능 관련 함수 End
/////////////////////////////////////////////////////////////


/**
 * 검색 권리 선택바 보이기 클릭 바인드 함수
 * 2012.11.07 bhhan
 */
function BindViewSelectPat()
{
	var obj = jQuery("#ulSelPatArea");
	var uldisp = obj.css("display");

	if(uldisp == "none")
		obj.show();
	else
		obj.hide();

}

/**
 * 검색 권리 선택 바인드 함수
 * 2012.11.07 bhhan
 */
function BindSelectPat()
{
	var id = $(this).prop("id");

	if(id == "btnSelPat01")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("KPORTAL");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "통합검색")
			.prop("src", "/images/common/txt_keyword01.gif");
	}
	else if(id == "btnSelPat02")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("KPAT");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "특허&middot;실용신안")
			.prop("src", "/images/common/txt_keyword02.gif");
	}
	else if(id == "btnSelPat03")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("DG");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "디자인")
			.prop("src", "/images/common/txt_keyword03.gif");
	}
	else if(id == "btnSelPat04")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("TM");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "상표")
			.prop("src", "/images/common/txt_keyword04.gif");
	}
	else if(id == "btnSelPat05")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("JM");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "심판")
			.prop("src", "/images/common/txt_keyword05.gif");
	}
	else if(id == "btnSelPat06")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("KPA");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "KPA")
			.prop("src", "/images/common/txt_keyword06.gif");
	}
	else if(id == "btnSelPat07")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("ABPAT");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "해외특허")
			.prop("src", "/images/common/txt_keyword07.gif");
	}
	else if(id == "btnSelPat08")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("ABROADTM");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
			.prop("alt", "해외상표")
			.prop("src", "/images/common/txt_keyword08.gif");
	}
	else if(id == "btnSelPat09")
	{
		jQuery("#SEL_PAT", jQuery("#divSearchItems")).val("CYBER");
		jQuery("#imgSelPat", jQuery("#divSearchItems"))
		.prop("alt", "인터넷기술공지")
		.prop("src", "/images/common/txt_keyword09.gif");
	}

	jQuery("#ulSelPatArea").hide();
}

/**
 * 검색어 확장 체크 버튼 클릭
 * @param from
 */
function BindCheckExtend() {

	var obj = jQuery("#searchInTransCk", jQuery("#divSearchItems"));
	var dummyBtn = jQuery("#spanCheckExtend", jQuery("#total_search"));
	var dummy = jQuery("#searchInTransCkDummy") ;

	if (obj.prop("checked")) 
	{
		dummyBtn.removeClass("extend_on") ;
		obj.prop("checked", false) ;
		dummy.prop("checked", false) ;
	} 
	else 
	{		
		dummyBtn.addClass("extend_on") ;
		obj.prop("checked", true) ;
		dummy.prop("checked", true) ;
	}
}

// 검색히스토리 세팅
function showHistoryStr(from)
{
	startHistoryNum = from;
	var viewHistory = "";
	for(var i = from; i < from + maxViewHistoryNum; i++)
	{
                if(i >= historyArr.length)
			break;
		viewHistory += historyArr[i];
	}
	jQuery("#divHistoryArea").html(viewHistory);
}

function DefSortFieldName(sortitem)
{
	var sortfield = "";

	switch(sortitem)
	{
		// 특허 / 실용신안
		case "출원번호" : 		sortfield = "ANS"; break;
		case "상태" : 			sortfield = "LST"; break;
		case "발명의 명칭" : 	sortfield = "TLV"; break;
		case "IPC" : 			sortfield = "IPV"; break;
		case "출원인" : 		sortfield = "APV"; break;
		case "대리인" : 		sortfield = "AGV"; break;
		case "발명자" : 		sortfield = "INV"; break;
		case "출원일자" : 		sortfield = "ADV"; break;
		case "등록번호" : 		sortfield = "GNV"; break;
		case "등록일자" : 		sortfield = "GDV"; break;
		case "공개번호" : 		sortfield = "ONV"; break;
		case "공개일자" : 		sortfield = "ODV"; break;
		case "공고번호" : 		sortfield = "PNV"; break;
		case "공고일자" : 		sortfield = "PDV"; break;
		case "우선권주장번호" : sortfield = "RNV"; break;
		case "우선권주장일자" : sortfield = "RDV"; break;
		case "국제출원번호" : 	sortfield = "FNA"; break;
		case "국제출원일자" : 	sortfield = "FDA"; break;
		case "국제공개번호" : 	sortfield = "FNO"; break;
		case "국제공개일자" : 	sortfield = "FDO"; break;

		// 인터넷 기술공지
		case "공지번호" : 		sortfield = "CRO"; break;
		case "공지제목" : 		sortfield = "CT"; break;
		case "작성자" : 		sortfield = "CRN"; break;
		case "작성일" : 		sortfield = "CDD"; break;
		default : 				sortfield = "Score";
	}

	return sortfield;
}


/**
 * 타이머에 의해 지정된 시간이 지나면 스마트파인더 버튼을 감춘다.
 * 2012.10.04 bhhan
 */
function SFHideTimerDone()
{
	var btnobj = jQuery("#divSmartFinderBtn");
	btnobj.fadeOut("slow");
}


/**
 * 스마트파인더 보기 버튼을 감추는 타이머를 클리어한다.
 * 2012.09.20 bhhan
 * @param global_timer : 전역 타이며 변수
 */
function ClearTimer(global_timer)
{
	if(global_timer != null)
	{
		clearTimeout(global_timer);
		golbal_timer = null;
	}

	return global_timer;
}

/**
 * 스마트파인더 보기 버튼을 감추는 타이머를 리셋한다.
 * 2012.09.20 bhhan
 * @param global_timer : 전역 타이며 변수
 * @param btnobj : 스마트파인더 버튼 오브젝트
 */
function ResetTimer(global_timer, btnobj)
{
	ClearTimer(global_timer);
	global_timer = setTimeout("SFHideTimerDone()", 1000 * 10); //기존 3초에서 10초로 변경 by lhy 2013.06.10

	return global_timer;
}

/**
 * 슬라이더에 의해 선택된 Duration을 날짜로 각 텍스트상자에 표시한다.
 * 2012.09.20 bhhan
 * @param from : 날짜 from
 * @param to : 날짜 to
 */
function setSlideDateDuration(from, to)
{
	var dt_from = getDateStr(CalcTime((-1 * from), 0, 0, 0), "");
	var dt_to = getDateStr(CalcTime((-1 * to), 0, 0, 0), "");

	$("#PD_FROM").val(dt_from);
	$("#PD_TO").val(dt_to);
}

/**
 * 스마트파인더에서 날짜 검색을 할때 From 과 To 에 입력된 값을 '~' 로 이어 붙인다.
 * 2012.09.21 bhhan
 */
function setValidDateSearchFormat()
{
	// 날짜(from과 to를 ~로 이어붙인)를 저장한 hidden value를 초기화한다.
	jQuery("input[type='hidden']", jQuery("#divDatePickArea")).val("");

	var retVal = true;
	jQuery("input[type='text']", jQuery("#divDatePickArea")).each(function(){

		var itemid = $(this).prop("id");
		if(itemid.indexOf("_TO") > 0)
		{
			var cmid = itemid.replace(/_FROM/g, "").replace(/_TO/g, "");
			var item_from = jQuery("#" + cmid + "_FROM");
			var item_to = $(this);
			var item = jQuery("#" + cmid);

			if(!(item_from.val() == "" && item_to.val() == ""))
				item.val(item_from.val() + "~" + item_to.val());
		}
	});
	return retVal;


}

/**
 * 스마트파인더를 감추고 버튼을 SmartFinder Open 으로 변경시킨다.
 * 2012.09.21 bhhan
 */
function hideSmartFinder()
{
        sf_stat = "close";
	jQuery("#ToggleSmartFinder").prop("src", "/images/common/btn_smartfinder_open_m.gif");
	jQuery("#divSmartFinderWrap").hide();	// 스마트 파인더 감추기
        
        //스마트검색 이미지 변경에 따라 스마트검색창을 열고 닫을 때 스마트검색 왼쪽버튼 표시 상태 변경함. by lhy 2013.08.13
        $(".sfinder_btn_left").show();
}

/**
 * 분류통계 조회
 * 2012.10.05 bhhan
 * @param piValue
 * @param piField
 */
function pisearch(piValue, piField)
{
	//alert(piValue+ " " + piField);
    var form = document.SearchPara;

    var elsevalue = "ALL";
    var lastvalue = "ALL";

    // 권리구분 설정
    var leftform = document.leftside;
    var  elseFlag = CheckKind(leftform);
    if ( elseFlag != false ) elsevalue = elseFlag;
    else return;

    // 행정처분 설정
    lastvalue = CheckLast(leftform);

    var queryText = form.queryText.value;

    form.historyQuery.value = queryText;

    if(elsevalue != "ALL" ) queryText = "(" + queryText + ")*" + elsevalue ;  //특허실용 선택 여부 확인 관련 (검색식 괄호 2008/04/02)
    if(lastvalue != "ALL" ) queryText = "(" + queryText + ")*" + lastvalue ; //최종선택 여부 확인 관련 (검색식 괄호 2008/04/02)

    //form.searchInResult.checked = false;
    form.piField.value = piField;
    form.piValue.value = piValue;
    form.next.value="PISearch";
    form.expression.value = queryText;
    form.currentPage.value = "1";
    //form.action = "/pat/resulta.do";
    //form.submit();
    var artPost = getPostAllData("divSearchItems");
    AjaxResultLoad("/kpat/resulta.do", artPost);
    hideSmartFinder();
}

/**
 * 스마트파인더 placeholder 감추기
 * 2013.03.13. psy mdf
 */
function hideplaceholder()
{
    jQuery("input[type='text']", jQuery("#smart_finder")).each(function(){

            var itemid = $(this).prop("id");
            var input = jQuery("#" + itemid);
            if(input.val() == input.attr('placeholder'))
            {
                input.val('');
            }
    });
}
/**
 * 스마트파인더 placeholder 보이기
 * 2013.03.13. psy mdf
 */
function showplaceholder()
{
    jQuery("input[type='text']", jQuery("#smart_finder")).each(function(){
            var itemid = $(this).prop("id");
            $("#"+itemid).textPlaceholder();
    });
}	

//시소러스 검색어 확장 링크 추가 by lhy 2013.04.17
function BindSearchInThsrs() {
    var spt = SearchItemForm.KW.value;
    var arr_split1 = spt.split(" ");
    var arr_split2 = spt.split("+");
    if(arr_split1.length > 1 || arr_split2.length > 1) {
        alert('검색어를 한단어로 입력하십시오!\n두단어 입력시 검색어 확장을 이용할 수 없습니다.');
        SearchItemForm.KW.focus()
    } else if(spt == "") {
        alert("'자유검색(전문)' 입력란에 검색어를 입력하십시오.");
    } else {
        SearchPara.searchInTrans.value="Y";
        window.open("/kpat/thsrs.do?thsrs_srch="+spt,"ThsrsSrch"," scrollbars=yes, height=500 ,width=600");
    }   
}



/*우선권 주장번호 입력안내 DIV 표시 by Jak 2013.07.10*/
function RDinfoDivDisplay(state){
    if(state == "open"){
        $("#inputExplain").show();
    } else if(state == "close"){
        $("#inputExplain").hide();
    } else if (state == undefined) {
        $("#inputExplain").toggle();
    }
}