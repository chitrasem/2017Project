var school_1002_0302 = {};
/**
 * When Form is loaded
 */
$(document).ready(function(){
	school_1002_0302.loadData();
	/**
	 * Save event ==============================================================================
	 */
	$("#btnSave").click(function(){
		var input = {};
		var memo = {};
	//	memo.content = "abc testing";
		var formData = {};
		$.each($('#school_1002_0302_form').serializeArray(), function(i, field) {			
			/*if(field.name==="firstName") field.value = field.value + "APPLE";*/
			formData[field.name] = field.value;
			if(field.name==="content"){
				memo.content = field.value;
			}
		});		
		delete formData.content;
		input.student = formData;
		input.memo = memo;
		
		school_1002_0302.saveData(input);
		
	});
	//==================================End Save==================================================
	$("#btnCancel").click(function(){
		school.ui.openWindow(url);
	});
	$("#btnClear").click(function(){
		school_1002_0302.clearData(this);
	});
});
school_1002_0302.getInput = function(){
	var input = {};
/*	input["stuId"]			= "20001214S0005";*/
	/*input["firstName"] 		= "Bota";
	input["lastName"] 		= "Ang";
	input["kmFirstName"] 	= "បុត្តា";
	input["kmLastName"] 	= "អាង";
	input["gender"]			= "M";
	input["birthDate"]		= "2000-12-14";*/
	
	return input;
}
school_1002_0302.saveData = function(input){
	if(typeof input ==="undefined") input = {};
	$.extend(input, school_1002_0302.getInput());
	$.ajax({
		type: "POST",
		data: JSON.stringify(input),
        contentType: "application/json; charset=utf-8",
		url: 'service/school_1002_0302_c001.chitra',
		success: function(dat){
			if(dat.success){
				school.ui.openWindow(url);
			}
		}
	});
}
/**
 * get data
 */
school_1002_0302.getData = function(){
	var input = {};
	input["mode"] = "edit";

	return input;
};
/**
 * load data
 */

school_1002_0302.clearData = function(target){
    $(target).closest('form').find("input[type=text] ,select, textarea").val("");
}
school_1002_0302.loadData = function(input){
	if(typeof input =="undefined") input = {};
	
	$("#firstName").focus();
	
	$.extend(input, school_1002_0302.getData());
	
	if(input.mode==="edit"){
		
	}
};