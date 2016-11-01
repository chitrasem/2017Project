var school_1002_03_02 = {};
$(document).ready(function(){
	$("#btnSave").click(function(){
		school.ui.sweetConfrim("Save student",function(dat){
			console.log(dat);
		});
		
		
	});
});