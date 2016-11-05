var school;
if(!school) school = {};
if(!school.string){
	school.string = {};
	
	school.string.formatBirthDate = function(str){
		
		return "";
	}
	
	school.string.appendAction = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:"><i>Check the select box to see more actions</i></a></li>';
		$(target).html(li);		
	};
	school.string.appendActionView = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:" id="btnView">View</a></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.string.appendActionMoreEdit = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.string.checkboxAll= function(source){
	    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i] != source)
	            checkboxes[i].checked = source.checked;
	    }
	}
}