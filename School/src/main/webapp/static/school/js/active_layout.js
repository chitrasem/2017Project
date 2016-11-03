/**
 * <pre>
 * COOCONBILL PROJECT
 * @COPYRIGHT (c) 2009-2012 WebCash, Inc. All Right Reserved.
 *
 * @File Name        : template_layout.js
 * @File path    	 : COOCONBILL_PT_STATIC/web/js/cooconbill
 * @author       	 : Neng Channa ( sjdecode@gmail.com )
 * @Description      : template_layout
 * @History      	 : 20160810140840, Neng Channa
 * </pre>
 **/

var template_layout = {};
$(document).ready(function(){
	//template_layout.getDynamicMenu();
});

template_layout.getFilenameOfUrl = function(url){
	if(url == undefined){
		url = window.location.pathname;
	}
	url = url.substring(url.lastIndexOf("/")+ 1);
    return (url.match(/[^.]+(\.[^?#]+)?/) || [])[0];
};

template_layout.setSelectedMenu = function(pathName){
	
//	var elemParent = $("#sidebar-menu  ul");
	//var elemChild  = $("li.has_sub ul li");
/*	var elemParent = $(".com_list .com_list_box .com_item .group_name");
	var elemChild = $("ul.group_name2 li");*/
	//$(elemChild).find("li > a[href$='"+pathName+"']").parent.addClass("active");
	//$(elemChild).find(">a[href$='"+pathName+"']").addClass("active").parent().parent().siblings().find(">a").css("background","red");
	
	

	
/*	$(elemParent).find(" > a[href$='"+pathName+"']").addClass("on").parent().siblings().find(">a").removeClass("on");
	$(elemChild).find("a[href$='"+pathName+"']").parent().addClass("on").siblings().removeClass("on");
	$(elemChild).find("a[href$='"+pathName+"']").closest("div.group_name").find(">a").addClass("on");
	$(elemChild).find("a[href$='"+pathName+"']").addClass("on");
	
	if(elemParent.find(" > a[href$='"+pathName+"']").attr("href") == undefined){
		$(elemParent).closest("div.group_name").find(">a.diff").removeClass("on");
	}else{
		$(elemChild).closest("ul.group_name2 li").find(">a.diff").removeClass("on");
	}
	
	//In case subMenu
	var elemMenuUrl = $("[data-sub-menu*='"+pathName+"']");
	if(!elemMenuUrl.hasClass("on")){
		$(elemChild).find("a[href$='"+elemMenuUrl.attr("href")+"']").closest("div.group_name").find(">a").addClass("on");
		$(elemChild).find("a[href$='"+elemMenuUrl.attr("href")+"']").addClass("on");
	}*/
	
	
};


template_layout.getDynamicMenu = function(){
	var fileName = template_layout.getFilenameOfUrl();
	template_layout.setSelectedMenu(fileName);
	
};