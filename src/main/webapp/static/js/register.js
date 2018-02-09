/**
 * 
 */
$(function(){
	$("input").each(function(i){
		$(this).blur(function(){
			if(i==4){
				var val = $(this).val(); 
				if($(this).val().length>3||!/^\d+$/.test(val)){
					$(this).next().text("年龄不正常");
				}
			}
			
		});
	});
});
$(function(){
	$("input").each(function(i){
		$(this).focus(function(){
			if(i==4){					
					$(this).next().text("");				
			}
			
		});
	});
});