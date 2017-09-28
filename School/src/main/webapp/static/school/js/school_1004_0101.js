//Classroom

var school_1004_0101 			= {};
	school_1004_0101.target 	= "";
	school_1004_0101.pagination = "";
	school_1004_0101.studentUrl = $("#STUDENT-URL").val();
	school_1004_0101.clsroomId  = "";
	
$(document).ready(function(){
	
	//Load Data;
	school_1004_0101.loadData();
	$("#addGrade").click(function(){
		school_1004_0101.openModal("#classroom_modal");
		school_1004_0101.listGrade();
	});
	$(document).delegate(".list-students","click", function(){
		var input = {};
		var _this = $(this);
		var upAndDown = _this.find("span");		
		if(upAndDown.hasClass("ion-chevron-down")){			
			upAndDown.removeClass("ion-chevron-down").addClass("ion-chevron-up");	
			// Show students						
			school_1004_0101.clsroomId 		    = _this.parent().parent().find("td.CLSROOM-ID").text();			
			school_1004_0101.target 			= _this.parent().parent().next("tr.show-students").find("td .STUDENTS-RESULT");
			school_1004_0101.pagination 		= _this.parent().parent().next("tr.show-students").find("td .STUDENTS-PAGING");
			
			school_1004_0101.showStudents(input);
			_this.parent().parent().next("tr.show-students").show();
			
		}else{			
			upAndDown.removeClass("ion-chevron-up").addClass("ion-chevron-down");
			_this.parent().parent().next("tr.show-students").hide();
		}
	});
	
});
school_1004_0101.openModal = function(modalId){
	$(modalId).modal({
		backdrop	: 'static', 
		keyboard	: false,
	});	
}
school_1004_0101.listGrade = function(){
	$("#GRADE_RESULT").empty();
	$.ajax({
		url : "school_1004_0101_r001.chitra",
		success: function(resp){
			if(resp.success){
				$("#GRADE_TMPL").tmpl(resp.GradeRec).appendTo("#GRADE_RESULT")
			}else{
				
			}
		},
		error: function(e){
			console.log("e",e);
		}
	});
	
}
school_1004_0101.getData = function(){
	var input = {};
	/*var payment = {};
	var paymentDetail = {};
	
	input.payment;
	input.paymentDetail;*/
	
	return input;
}
school_1004_0101.loadData = function(input){
	if(typeof input === undefined) input = {};
	$.extend(input, school_1004_0101.getData());
	
	$.ajax({
		type: "get",
		url: "school_1004_0101_r001.chitra",
		success: function(dat){
			if(dat.SUCCESS){	
				$("#CLSROOM-TMPL").tmpl(dat.clsRoomRec).appendTo("#CLSROOM-RESULT")
			}
			
		}
	});
	
	
};
school_1004_0101.getStudentData = function(){
	
	var input = {};
	
	
	return input;
}
school_1004_0101.showStudents = function(input){
	
	if(!input) input = {};
	
	
	input.clsroomId = school_1004_0101.clsroomId;

	if(!input.pageCount || !input.pageCount === null) input.pageCount = 1;
	input.numberOfRecord = 1;
	
	$(school_1004_0101.target).html("");
	$("tfoot").hide();
	
	$.ajax({
		url: school_1004_0101.studentUrl+"/",
		data: input,
		tye: "GET",
		success: function(dat){
			if(dat.SUCCESS && dat.studentRec.length>0){
				$("tfoot").hide();
				$("#STUDENTS_TMPL").tmpl(dat.studentRec).appendTo(school_1004_0101.target);
				school.ui.createPagination(school_1004_0101.pagination, dat.totalStudent, input.numberOfRecord, input.pageCount, school_1004_0101.showStudents);
				
			}else{
				$("tfoot").show();				
			}
		}
	});
	
	
};
