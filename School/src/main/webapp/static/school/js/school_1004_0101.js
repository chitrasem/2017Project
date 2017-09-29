//Classroom

var school_1004_0101 			= {};
	school_1004_0101.target 	= "";
	school_1004_0101.pagination = "";
	school_1004_0101.studentUrl = $("#STUDENT-URL").val();
	school_1004_0101.clsroomId  = "";
	
$(document).ready(function(){	
	//Load Data;
	school_1004_0101.loadData();	
});
$("#addMultGrade").click(function(){
	const GRADE = {};
	GRADE.name 		= $("#txtGrade").val();
	GRADE.descr 	= $("#txtDescr").val();	
	GRADE.status 	= "C";
	
	console.log(GRADE)
	school_1004_0101.appendGrade(GRADE,"#APPEND_GRADE_TMPL");
});
//Show Popup and list data
$("#addGrade").click(function(){
	school_1004_0101.openModal("#classroom_modal");
	school_1004_0101.listGrade();
});
school_1004_0101.openModal = function(modalId){
	$(modalId).modal({
		backdrop	: 'static', 
		keyboard	: false,
	});
}

school_1004_0101.appendGrade = function(dat, tmpl){
	$(tmpl).tmpl(dat).appendTo("#GRADE_RESULT")
};
school_1004_0101.listGrade = function(){
	$("#GRADE_RESULT").empty();
	$.ajax({
		url : "school_1004_0101_r001.chitra",
		success: function(resp){
			if(resp.success){
				school_1004_0101.appendGrade(resp.GradeRec, "#GRADE_TMPL");
			}else{
				
			}
		},
		error: function(e){
			console.log("e",e);
		}
	});
	
}
school_1004_0101.loadData = function(input){
/*	if(typeof input === undefined) input = {};
	$.extend(input, school_1004_0101.getData());
	
	$.ajax({
		type: "get",
		url: "school_1004_0101_r001.chitra",
		success: function(dat){
			if(dat.SUCCESS){	
				$("#CLSROOM-TMPL").tmpl(dat.clsRoomRec).appendTo("#CLSROOM-RESULT")
			}			
		}
	});*/
};

