
var school_1005_0101 = {};

$(document).ready(function(event){
	school_1005_0101.loadData();
	$("#currKm").val( school_1005_0101.exchangeMoney("us2km") );
	$("#btnAddPayment").click(function(e){
		e.preventDefault();
		//$("#school_1005_0101_form").submit();		
	});
	$("#qty, #unitPrc, #excRate, #currKm, #currUs").autoNumeric('init',{
		wEmpty: 'zero',
		lZero: 'deny',
	    aPad: false,
	    vMax: '999999999999',
	    vMin: '-999999999999'		
	});
	$("#qty, #unitPrc").on("keyup", function(){
		var amout	 = new BigNumber(0),
		
		qty			 = school.string.removeComma( $("#unitPrc").val() ),
		unitPrc 	 = school.string.removeComma( $("#qty").val() );
		
		qty = new BigNumber(qty);
		unitPrc = new BigNumber(unitPrc);
		
		amount		 = qty.times(unitPrc);		
		$("#amount").val(school.string.numberWithComma(amount) );
	});
	$("#btnAddIncome").click(function(e){
		var formData = {};
		var input 	 = {};
		$.each($('#school_1005_0101_f001').serializeArray(), function(i, field) {	
			formData[field.name] = field.value;
		});
		input.payment = formData;
		school_1005_0101.addData(input);
	});
	$("#currKm, #currUs").on("keyup",function(){
		var thisVal = $(this).attr("name");
		var status = "km2us";
		if(thisVal=="currUs"){	
			status = "us2km";
		}		
		var target = "currKm";
		if(thisVal=="currKm") target = "currUs";
		$("#"+target).val(school_1005_0101.exchangeMoney(status));
	});
	
});
/**
 * excRate = Exchange Rate default = 4000
 * currKm  = Khmer Currency
 * currUs  = Dollar Currency
 */
school_1005_0101.exchangeMoney = function(status){
	var excRate = school.string.removeComma($("#excRate").val() );
	var currKm = school.string.removeComma($("#currKm").val() );
	var currUs = school.string.removeComma($("#currUs").val() );
	
	var calculation = new BigNumber(0);
	currKm = new BigNumber(currKm);
	currUs = new BigNumber(currUs);	
	
	
	if(status==="km2us"){	
		calculation = currKm.dividedBy(excRate);
	}else{
		calculation = currUs.times(excRate);
	}	
	return school.string.numberWithComma(calculation);
}
school_1005_0101.addData = function(input){
	var url = 'school_1005_0102_c001.chitra';
	$.ajax({
		data: JSON.stringify(input),
        contentType: "application/json; charset=utf-8",
		url: url,
		success	: function(resp){
			console.log(resp);
			school_1005_0101.loadData();	
		}
	});
}
school_1005_0101.getData = function(){
	var input = {};
	return input;
}
school_1005_0101.loadData = function(input){
	if(!input) input = {};
	var url = 'school_1005_0102_r002.chitra';
	$.ajax({
		url: url,
		success: function(resp){
			$("#PAYMENT_TMPL").tmpl(resp.PAYMENT_REC).appendTo("#PAYMENT_RESULT");
			//school.ui.createPagination("#pagination", dat.totalStudent, input.numberOfRecord, input.pageCount, school_1002_0301.loadData);
		}
	
	});
	
}