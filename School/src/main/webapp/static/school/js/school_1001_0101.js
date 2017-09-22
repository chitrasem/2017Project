var school_1001_0101 = {};
$(document).ready(function() {
	school_1001_0101.loadData();

});
school_1001_0101.loadData = function() {
	$.blockUI({ 
		css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
		},
		message: "<h1 class='khFont'>សូមមេត្តារង់ចាំ...</h1>",
        fadeIn: 1000, 
        timeout:   2000, 
        onBlock: function() {    
        	var  url = "school_1001_0101.chitra";
        	 $.ajax({
        		 url : url,
        		 success: function(dat){
        			 if(dat.success){
            			 school_1001_0101.callBack(dat);
        			 }else{
        				 alert(dat.message);
        			 }
        			 
        		 },
        	 });
        } 
    });
	
	
}
school_1001_0101.callBack = function(resp) {
	var input = {};
	var arr = [];

	arr = [ {
	    count : resp.dsRec[0].tot_user,
		name : "Users",
		classIcon : "ion-android-contacts",
		url : '../dashboard/people/school_1002_0301.act',
		classMini : "mini-stat-icon bg-danger",
	}, {
		count : resp.dsRec[0].tot_user,
		name : "Staff",
		classIcon : "ion-android-contacts",
		url : '../dashboard/people/school_1002_0301.act',
		classMini : "mini-stat-icon bg-purple",
	}, {
	    count : resp.dsRec[0].tot_stu,
		name : "Students",
		classIcon : "ion-android-contacts",
		url : '../dashboard/people/school_1002_0301.act',
		classMini : "mini-stat-icon bg-info",
	}, {
		// count : resp.dsRec[0].amt_km,
		name : "Payment",
		classIcon : "ion-social-usd",
		url : '../dashboard/people/school_1002_0301.act',
		classMini : "mini-stat-icon bg-success",
	}, {
		// count : resp.dsRec[0].amt_us,
		name : "Payment",
		classIcon : "ion-social-usd",
		url : '../dashboard/payment/school_1005_0101.act',
		classMini : "mini-stat-icon bg-success",
	} ];
	input.app = arr;
	if (input.app.length > 0) {
		$("#APP_TMPL").tmpl(input.app).appendTo("#APP_RESULT");
	}
	
};