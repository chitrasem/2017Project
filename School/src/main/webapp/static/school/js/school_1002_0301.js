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
});
school_1002_0301.getInput = function(){
	var input = {};
	return input;
}
school_1002_0301.loadData = function(input){
	if(!input) input = {};
	$.extend(input, school_1002_0301.getInput() );
	
	var url = "service/school_1002_0301_r001.chitra";
	$("#STUDENT_RESULT").html();
	$.ajax({
		url: url,
		type: "get",
		success: function(dat){
			console.log(dat);
			if(dat.success && dat["StudentRec"].length>0){
				$("#STUDENT_TMPL").tmpl(dat.StudentRec).appendTo("#STUDENT_RESULT");
			}
		}
	});
	
}