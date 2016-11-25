//Payment
var school_1004_0101 = {};

$(document).ready(function(){
	school_1004_0101.loadData();
	
});
school_1004_0101.getData = function(){
	var input = {};
	/*var payment = {};
	var paymentDetail = {};
	
	input.payment;
	input.paymentDetail;*/
	
	return input;
}
school_1004_0101.loadData = function(input){
	if(typeof input === undefined) input = {};
	$.extend(input, school_1004_0101.getData());
	
	
};