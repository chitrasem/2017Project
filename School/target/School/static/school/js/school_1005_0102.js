var school_1005_0102 = {};

$(document).ready(function(){
	
	school_1005_0102.loadData();
	
	
	// Event
	
	$("#payType").on("change", function(){
		var _this = $(this);
		
		if(_this.val()==="income"){
			school.ui.loadPaymentMethod("#resultMethod");
		}
		
	});
});
school_1005_0102.loadData = function(input){	
	if(!input) input = {};
}