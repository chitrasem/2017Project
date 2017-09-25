var school_1002_0302 = {};
var courseUrl = $("#courseUrl").val();
/**
 * When Form is loaded
 */
$(document).ready(function(e){
	$("button").click(function(e){
		e.preventDefault();
	});
	school_1002_0302.loadData("",function(dat){
		school.ui.datetimepicker(".datetimepickerYYYYMMDD",{
			"pickTime"	: false,
		});
		//$("#birthDate").datepicker();
		//school.ui.addCourseCombo("#sbCourse", courseUrl,dat.courseId);
	});
	
	// Initialize the jQuery File Upload widget:
    $('#fileupload').fileupload({
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},
        url: 'http://localhost:8080/School/upload/test',
        change: function(e, data){
        	$.each(data.files, function(index, file){
        	})
        }
    });
    $("#fileupload").bind("fileuploaddone", function(e, data){  
    	console.log(data);
    	var str = $("#imgPhoto").attr("src");
    	str  = str.substr(0, str.lastIndexOf("/static"))
    	
    	var imageUrl = data.result.path;   	
    	var imageName = data.result.name;    	
    	    imageUrl  = imageUrl.replace("\\", "/");
    	    imageUrl  = imageUrl.replace("\\", "/");
    	    imageName = imageName.replace("\\", "/");    	
    	var imgPhoto = $("#imgPhoto");       	
    	$("#uploadModal").modal("hide");  
    	var absoluteUrl = $("#absoluteUrl").val();
    	absoluteUrl = absoluteUrl.substring(0, absoluteUrl.length - 2 );
    	
    	imgPhoto.attr("src",absoluteUrl+imageUrl+imageName);
    	$("#imageName").val(imageName);
    	$("#imagePath").val(imageUrl);
    	/*
    	setTimeout(function(){        	
        	imgPhoto.attr("src",absoluteUrl+imageUrl+imageName);
        	$("#imageName").val(imageName);
        	$("#imagePath").val(imageUrl);
    	}, 3000);*/
    	
    });
    $("#fileupload").fileupload({
    	autoUpload: false,
    	downloadTemplatedId: null,
    	maxFileSize: 52428800,
    	progressall: function(e, data){
    		
    	}
    });
	/**
	 * Save event ==============================================================================
	 */
	$("#btnSave").click(function(){
		var input 		= {};
		var memo 		= {};
		var course 		= {};
		var session 	= {};
		
	//	memo.content = "abc testing";
		var formData = {};
		$.each($('#school_1002_0302_form').serializeArray(), function(i, field) {			
			/*if(field.name==="firstName") field.value = field.value + "APPLE";*/
			formData[field.name] = field.value;
			if(field.name==="content"){
				memo.content = field.value;
			}
			/*if(field.name==="courseId"){
				course.id = field.value;
			}*/
			/*if(field.name==="sessionId"){
				session.id = field.value;
			}*/
			if(field.name==="birthDate"){
				formData.birthDate = school.string.removeAllString(formData.birthDate);
			}
		});		
		
		delete formData.content;
		//delete formData.courseId;
		//delete formData.sessionId;
		
		input.student 	= formData;
		input.memo 		= memo;
		//input.course 	= course;
		//input.session 	= session;		
		swal({
			  title: "រក្សាទុក",
			  text: "តើលោកអ្នកពិតជាចង់រក្សាទុកឫ?",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#DD6B55",
			  confirmButtonText: "បាទ/ច៎ា",
			  cancelButtonText: "ទេ",
			  closeOnConfirm: false
			},
			function(isConfirm){
				if(isConfirm){
					school_1002_0302.saveData(input);
				}else{
					swal("Cancelled", "error");
				}
			});
		
	});
	//==================================End Save==================================================
	$("#btnCancel").click(function(){
		school.ui.openWindow(url);
	});
});
//Helper function for calculation of progress
function formatFileSize(bytes) {
    if (typeof bytes !== 'number') {
        return '';
    }

    if (bytes >= 1000000000) {
        return (bytes / 1000000000).toFixed(2) + ' GB';
    }

    if (bytes >= 1000000) {
        return (bytes / 1000000).toFixed(2) + ' MB';
    }
    return (bytes / 1000).toFixed(2) + ' KB';
}

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
				swal({
					title: "រកស្សាទុក!",
					text: "សិស្សឈ្មោះ "+dat.lastName+" បានរក្សាទុកក្នុងទិន្នរួចរាល់ហើយ.", 
					type: "success",
					},
					function(isConfirm){
						if(isConfirm){
							//school.ui.openWindow(studentUrlDtl);
							$("#viewStudentId").val(dat.studentId);
							$("#school_1002_0303_form").submit();
						}else{
							swal("Cancelled", "error");
						}
					});
				}else{
					console.log(dat.message)
					swal({
						title: "មិនត្រឹមត្រូវ",
						text: "សូមទំនាក់ទំនងទៅកាន់អ្នកបច្ចេកទេសដើម្បីត្រួតពិនិត្យ", 
						type: "error",
					});
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
school_1002_0302.loadData = function(input, callbackFn){
	if(typeof input =="undefined") input = {};	
	$("#firstName").focus();	
	$.extend(input, school_1002_0302.getData());
	
	var data = {};
	school_1002_0302.isUpdate = false;
	if(studentId.length===10){
		var studentIDHtml = '<input type="hidden" id="studentId" name="id">';
		$("#school_1002_0302_form").append(studentIDHtml);
		school_1002_0302.isUpdate = true;
		$.ajax({ 
			type: "GET",
			url: getStudentUrl,
			success: function(dat){
				console.log(dat);
			//	data.courseId = dat.studentRec.course.id;				
				var absoluteUrl = $("#absoluteUrl").val();
				$("#MEMO_RESULT").html();				
				$("#studentId").val(dat.studentRec.id);
				$("#firstName").val(dat.studentRec.firstName);
				$("#lastName").val(dat.studentRec.lastName);
				$("#kmFirstName").val(dat.studentRec.kmFirstName);
				$("#kmLastName").val(dat.studentRec.kmLastName);
				$("#gender").val(dat.studentRec.gender);
	        	$("#imgPhoto").attr("src",absoluteUrl+dat.studentRec.imagePath+dat.studentRec.imageName);
	        	$("#imageName").val(dat.studentRec.imageName);
	        	$("#imagePath").val(dat.studentRec.imagePath);
				$("#birthDate").val(school.string.formatBirthDate( dat.studentRec.birthDate) );			
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
				if($.isFunction(callbackFn)){
					callbackFn(data);
				}
			}
		});
	}else{
		if($.isFunction(callbackFn)){
			callbackFn(data);
		}
	}	
};
var isJpg = function(name) {
    return name.match(/jpg$/i)
};    
var isPng = function(name) {
    return name.match(/png$/i)
};
