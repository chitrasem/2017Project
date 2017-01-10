var school_1002_0301 = {};
$(document).ready(function(){
	//Load data
$("#searchName").focus();
	school_1002_0301.loadData();
	
	//Dropdown Action
	school.ui.appendAction("#dropDownResult");	
	
	
	$('input[type="checkbox"]').click(function(){
		_this = this;
		school.ui.checkboxAll(_this);
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
	
	$(document).delegate("td a.btn-view", "click", function(){
		
		var _this = $(this);
		
		var studentId = _this.parent().parent().find('input[type="hidden"]').val();
		$("#viewStudentId").val(studentId);
		$("#school_1002_0303_form").submit();
		
		
	});
	$(document).delegate("td button.btn-edit", "click", function(){
		
		var _this = $(this);
		
		var studentId = _this.parent().parent().find('input[type="hidden"]').val();
		$("#studentId").val(studentId);
		$("#school_1002_0302_form").submit();
		
	});
		
	$(document).delegate('input[type="checkbox"]', "click", function(){
		var dataRec =[];
		$('#STUDENT_RESULT >tr').find('input[type="checkbox"]:checked').each(function(e){				
			dataRec.push($(this).length);
		});	
		if(dataRec.length===0){	
			school.ui.appendAction("#dropDownResult");		
		}else if(dataRec.length===1){
			school.ui.appendActionView("#dropDownResult");
		}else{
			school.ui.appendActionMoreEdit("#dropDownResult");
		}
	})
	$(document).delegate("#downloadExcel, #btnDownload", "click", function(e){
		e.preventDefault();
		
		var input = {};
		
		$.extend(input, school_1002_0301.getInput());
		
		$("#srcStudentId").val(input.id);
		
		$("#school_1002_0301_download").submit();
		
	});
	$(document).delegate("#addNew, #btnAdd","click",function(){
		school.ui.openWindow(studentForm);
	});
	
	$("#btnSearchName").click(function(){
		school_1002_0301.loadData();
	});
	$("#searchName").on("keyup", function(e){
		if(e.keyCode===13){
			school_1002_0301.loadData();
		}
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

	input.numberOfRecord = 10;
	
	var url = "school_1002_0301_r001.chitra";
	$("#STUDENT_RESULT").html("");
	$.ajax({
		url: url,
		type: "get",
		data: input,
		success: function(dat){
			if(dat.success && dat.studentRec.length>0){
				$("#STUDENT_TMPL").tmpl(dat.studentRec).appendTo("#STUDENT_RESULT");				
				school.ui.createPagination("#pagination", dat.totalStudent, input.numberOfRecord, input.pageCount, school_1002_0301.loadData);
			}
		}
	});
	
}