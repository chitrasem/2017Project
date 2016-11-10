var school_1002_0301 = {};
$(document).ready(function(){
	//Load data
	school_1002_0301.loadData();
	
	//Dropdown Action
	school.string.appendAction("#dropDownResult");	
	
	
	$('input[type="checkbox"]').click(function(){
		_this = this;
		school.string.checkboxAll(_this);
	});
	$(document).delegate("#btnView","click", function(){
		var checkbox = $("#STUDENT_RESULT >tr").find('input[type="checkbox"]:checked');
		var studentId = checkbox.parent().find('input[type="hidden"]').val();
		$("#studentId").val(studentId);
		$("#school_1002_0301").submit();
	});
/*	$(document).delegate("#STUDENT_RESULT tr", "click", function(){
		var checkbox = $(this).find("input[type='checkbox']");
		if(checkbox.is(":checked")){
			checkbox.prop("checked",false);
		}else{
			checkbox.prop("checked",true);
		}
		var dataRec =[];
		$('#STUDENT_RESULT >tr').find('input[type="checkbox"]:checked').each(function(e){				
			dataRec.push($(this).length);
		});	
		if(dataRec.length===1){
			school.string.appendActionView("#dropDownResult");
		}else{
			school.string.appendActionMoreEdit("#dropDownResult");
		}
	});*/
	
	$(document).delegate('input[type="checkbox"]', "click", function(){
		var dataRec =[];
		$('#STUDENT_RESULT >tr').find('input[type="checkbox"]:checked').each(function(e){				
			dataRec.push($(this).length);
		});	
		if(dataRec.length===0){	
			school.string.appendAction("#dropDownResult");		
		}else if(dataRec.length===1){
			school.string.appendActionView("#dropDownResult");
		}else{
			school.string.appendActionMoreEdit("#dropDownResult");
		}
	})
	$(document).delegate("#downloadExcel", "click", function(){
		alert();
	});
	$(document).delegate("#addNew","click",function(){
		school.ui.openWindow(studentForm);
	});
	
	$("#btnSearchName").click(function(){
		school_1002_0301.loadData();
	});
});
school_1002_0301.getInput = function(){
	var input = {};
	input.id = $("#searchName").val();
	return input;
}
school_1002_0301.loadData = function(input){
	if(!input) input = {};
	$.extend(input, school_1002_0301.getInput() );
	if(!input.pageCount || !input.pageCount === null) input.pageCount = 1;

	input.numberOfRecord = 5;
	
	var url = "school_1002_0301_r001.chitra";
	$("#STUDENT_RESULT").html("");
	$.ajax({
		url: url,
		type: "get",
		data: input,
		success: function(dat){
			if(dat.success){
				$("#STUDENT_TMPL").tmpl(dat.studentRec).appendTo("#STUDENT_RESULT");				
				school.string.createPagination("#pagination", dat.totalStudent, input.numberOfRecord, input.pageCount, school_1002_0301.loadData);
			}
		}
	});
	
}