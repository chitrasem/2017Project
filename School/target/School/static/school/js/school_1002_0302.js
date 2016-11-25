var school_1002_0302 = {};
/**
 * When Form is loaded
 */
$(document).ready(function(){
	school_1002_0302.loadData();
	var file = $('[name="file"]');
    var imgContainer = $('#imgContainer');
    
    $('#btnUpload').on('click', function() {
        var filename = $.trim(file.val());
        
        if (!(isJpg(filename) || isPng(filename))) {
            alert('Please browse a JPG/PNG file to upload ...');
            return;
        }
        
        $.ajax({
            url: '/School/upload/test',
            type: "POST",
            data: new FormData(document.getElementById("fileForm")),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false
          }).done(function(data) {
              imgContainer.html('');
              var img = '<img src="data:' + data.contenttype + ';base64,'
                  + data.base64 + '"/>';
    
              imgContainer.append(img);
          }).fail(function(jqXHR, textStatus) {
              //alert(jqXHR.responseText);
              alert('File upload failed ...');
          });
        
    });
    
    $('#btnClear').on('click', function() {
        imgContainer.html('');
        file.val('');
    });
		
	
	
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
	var saveUpdateUrl = "";
	if(school_1002_0302.isUpdate){
		saveUpdateUrl = 'school_1002_0302_u001.chitra';
	}else{
		saveUpdateUrl = 'school_1002_0302_c001.chitra';		
	}
	$.ajax({
		type: "POST",
		data: JSON.stringify(input),
        contentType: "application/json; charset=utf-8",
		url: saveUpdateUrl,
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

	school_1002_0302.isUpdate = false;
	if(studentId.length===10){
		var studentIDHtml = '<input type="hidden" id="studentId" name="id">';
		$("#school_1002_0302_form").append(studentIDHtml);
		
		school_1002_0302.isUpdate = true;
		$.ajax({
			type: "GET",
			url: getStudentUrl,
			success: function(dat){
				$("#MEMO_RESULT").html();
				
				$("#studentId").val(dat.studentRec.id);
				$("#firstName").val(dat.studentRec.firstName);
				$("#lastName").val(dat.studentRec.lastName);
				$("#kmFirstName").val(dat.studentRec.kmFirstName);
				$("#kmLastName").val(dat.studentRec.kmLastName);
				$("#gender").val(dat.studentRec.gender);
				$("#birthDate").val(dat.studentRec.birthDate);
				$("#birthPlace").val(dat.studentRec.birthPlace);				
				$("#biography").val(dat.studentRec.biography);
				$("#phone1").val(dat.studentRec.phone1);
				$("#phone2").val(dat.studentRec.phone2);				
				$("#email").val(dat.studentRec.email);				
				$("#currentAddr").val(dat.studentRec.currentAddr);				
				$("#motherName").val(dat.studentRec.motherName);
				$("#motherPhone").val(dat.studentRec.motherPhone);
				$("#fatherName").val(dat.studentRec.fatherName);
				$("#fatherPhone").val(dat.studentRec.fatherPhone);
				if(dat.memoRec.length>0){
					$("#MEMO_TMPL").tmpl(dat.memoRec).appendTo("#MEMO_RESULT");
				}
			}
		});
	}
};
var isJpg = function(name) {
    return name.match(/jpg$/i)
};
    
var isPng = function(name) {
    return name.match(/png$/i)
};
