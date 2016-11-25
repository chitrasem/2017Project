
var school_1002_0101 = {};
$(document).ready(function(){
	school_1002_0101.loadData();
});
school_1002_0101.getInput = function(){
	var input = {};
	return input;
}
school_1002_0101.loadData = function(input){
	if(!input) input = {};
	var actionService = "service/school_1002_0101_r001.chitra";
	
	$("#USER_RESULT").html();
	
	$.ajax({
		type: "GET",
		url: actionService,
		success: function(dat){
			if(dat.success && dat["UserRec"].length>0){
				$("#USER_TMPL").tmpl(dat.UserRec).appendTo("#USER_RESULT");
			}
			
		}
	});
	
}