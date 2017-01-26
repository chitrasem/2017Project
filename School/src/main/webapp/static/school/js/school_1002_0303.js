$(document).ready(function(){
	school_1002_0303.loadData();
});
var school_1002_0303 = {};
$("#btnEdit").click(function(){
	$("#school_1002_0302_form").submit();
});
school_1002_0303.loadData = function(input){
	
	if(!input) var input = {};
	
	$.ajax({
		url: viewURL,
		success: function(resp){
			if(resp.studentRec.length>0){
				
			}
		}
	});
	
	
};