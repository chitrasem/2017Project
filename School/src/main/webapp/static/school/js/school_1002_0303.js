var school_1002_0303 = {};
$(document).ready(function(){
	school_1002_0303.loadData();
});
var school_1002_0303 = {};
$("#btnEdit").click(function(){
	$("#school_1002_0302_form").submit();
});
$("#btnBack").click(function(){
	$("#school_1002_0301_form").submit();	
});
school_1002_0303.loadData = function(input){
	
	if(!input) var input = {};
	
	$.ajax({
		url: viewURL,
		success: function(resp){
			console.log(resp)
			if(resp.studentRec.length>0){
				console.log(resp)
			}
		}
	});
	
	
};