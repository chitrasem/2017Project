var school_1002_0302 = {};
/**
 * When Form is loaded
 */
$(document).ready(function(){
	school_1002_0302.loadData();
	$("#btnSave").click(function(){
		school_1002_0302.saveData();
		//school.ui.openWindow(url);
		
	});
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
	input["firstName"] 		= "Bota";
	input["lastName"] 		= "Bota";
	input["kmFirstName"] 	= "Bota";
	input["kmLastName"] 	= "Bota";
	input["gender"]			= "M";
	input["birthDate"]		= "2000-12-14";
	
	return input;
}
school_1002_0302.saveData = function(input){
	if(typeof input ==="undefined") input = {};
	$.extend(input, school_1002_0302.getInput());
	console.log(JSON.stringify(input));
	$.ajax({
		type: "POST",
		data: input,
		url: 'service/school_1002_0302_c001.chitra',
		success: function(dat){
			console.log(dat);
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
    $(target).closest('form').find("input[type=text], select, textarea").val("");
}
school_1002_0302.loadData = function(input){
	if(typeof input =="undefined") input = {};
	
	$("#firstName").focus();
	
	$.extend(input, school_1002_0302.getData());
	
	if(input.mode==="edit"){
		
	}
};