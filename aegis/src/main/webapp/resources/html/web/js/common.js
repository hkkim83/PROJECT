$(document).ready(function(){ 
    $('.notice h3 a').each(function(index){
		$('.loginO').hide(); 
        $(this).click(function(){
            $('.loginLeft div').hide().eq(index).show();
			$('.loginLeft h3 a').removeClass('on');
			$(this).addClass('on');
        }); 
    });
});  
	 
//layer popup
$(document).ready(function(){

	//layer close
		$('.layerPopup .btn_close').click(function(){
			$(this).parents('.layerPopup').fadeOut(300);
		});

	//layer open
		$('.btn_open').click(function(){
			$('.openArea').show();
		});
		$('.btn_close a').click(function(){
			$('.btn_open').focus();
			$('.openArea').hide();
		});
		});

	//layer중앙에서 열기
		function showLpop(lpop){
			var top = ( $(window).scrollTop() + ($(window).height() - $(lpop).height()) / 2 );
			var left = ( $(window).scrollLeft() + ($(window).width() - $(lpop).width()) / 2 );
			$(lpop).css('top', top);
			$(lpop).css('left', left);
			$(lpop).show(); 
		}

//상품이미지확대
	$(function(){
	$("#zoomThumb a").click(function(){
		$("#zoomMain img").attr("src",$(this).attr("href"));
		return false;
	});

});


$(function(){ 
	function initTabs() {
		$('.tab a').bind('click',function(e) {
			e.preventDefault();
			var thref = $(this).attr("href").replace(/#/, '');
			$('.tab a').removeClass('on');
			$(this).addClass('on');
			$('.inb_con').removeClass('active');
			$('#'+thref).addClass('active');
		});
	}
	initTabs();
})

 