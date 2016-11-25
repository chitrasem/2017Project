var school_1001_0101 = {};
$(document).ready(function(){
	
	school_1001_0101.loadData();
	
});

school_1001_0101.loadData = function(input){
	if(!input) input = {};
	$.extend(input, school_1001_0101.getData());	
	console.log(input);
	if(input.app.length>0){

		$("#APP_TMPL").tmpl(input.app).appendTo("#APP_RESULT");	
		
	}
};
school_1001_0101.getData = function(input){
	var input = {};
	var arr = [];
	
	arr = [{
		name 		: "Users",
		classIcon	: "ion-android-contacts", 
		url 		: '../dashboard/people/school_1002_0301.act',
		classMini   : "mini-stat-icon bg-danger",
	},
	{
		name 		: "Staff",
		classIcon	: "ion-android-contacts", 
		url 		: '../dashboard/people/school_1002_0301.act',
		classMini   : "mini-stat-icon bg-purple",
	},
	{
		name 		: "Students",
		classIcon	: "ion-android-contacts", 
		url 		: '../dashboard/people/school_1002_0301.act',
		classMini   : "mini-stat-icon bg-info",
	},
	{
		name 		: "Payment",
		classIcon	: "ion-social-usd",
		url 		: '../dashboard/people/school_1002_0301.act',
		classMini   : "mini-stat-icon bg-success",
	},
	{
		name 		: "Payment",
		classIcon	: "ion-social-usd",
		url 		: '../dashboard/payment/school_1005_0101.act',
		classMini   : "mini-stat-icon bg-success",
	}
	];
	input.app = arr;
	return input;
	
};