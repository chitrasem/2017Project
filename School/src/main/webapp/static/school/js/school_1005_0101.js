
var school_1005_0101 = {};

$(document).ready(function(event){
	school_1005_0101.loadData();	
	school.ui.appendAction("#actionPayment");	
	$("#btnAddPayment").click(function(e){
		e.preventDefault();
		$("#school_1005_0101_form").submit();		
	});
	
});
school_1005_0101.getData = function(){
	var input = {};
	return input;
}
school_1005_0101.loadData = function(input){
	if(!input) input = {};
	var url = 'school_1005_0102_r001.chitra';
	$.ajax({
		url: url,
		success: function(resp){
			$("#PAYMENT_TMPL").tmpl(resp.PAYMENT_REC).appendTo("#PAYMENT_RESULT");
			//school.ui.createPagination("#pagination", dat.totalStudent, input.numberOfRecord, input.pageCount, school_1002_0301.loadData);
		}
	
	});
	
}