var school_1002_0201 = {};
$(document).ready(function(){
	//Load data
	school_1002_0201.loadData();
	
	//Dropdown Action
	school.string.appendAction("#dropDownResult");	
	
	
	$('input[type="checkbox"]').click(function(){
		_this = this;
		school.string.checkboxAll(_this);
	});
	$(document).delegate("#btnView","click", function(){
		var checkbox = $("#STAFF_RESULT >tr").find('input[type="checkbox"]:checked');
		var studentId = checkbox.parent().find('input[type="hidden"]').val();
		$("#studentId").val(studentId);
		$("#school_1002_0201").submit();
	});
	
	$(document).delegate('input[type="checkbox"]', "click", function(){
		var dataRec =[];
		$('#STAFF_RESULT >tr').find('input[type="checkbox"]:checked').each(function(e){				
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
		school.ui.openWindow(staffFormUrl);
	});
});
school_1002_0201.getInput = function(){
	var input = {};
	return input;
}
school_1002_0201.loadData = function(input){
	if(!input) input = {};
	$.extend(input, school_1002_0201.getInput() );
	
	var url = "service/school_1002_0201_r001.chitra";
	$("#STAFF_RESULT").html();
	$.ajax({
		url: url,
		type: "get",
		success: function(dat){
			console.log(dat);
			
			if(dat.success && dat["staffRec"].length>0){
				$("#STAFF_TMPL").tmpl(dat.staffRec).appendTo("#STAFF_RESULT");
			}
		}
	});
	
}