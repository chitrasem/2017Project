var school_1005_0102 = {};

$(document).ready(function(){		
	school_1005_0102.loadData();
	school_1005_0102.generatDtl([1]);	
	$(document).delegate(".UNIT_PRICE, .AMT_DST","keyup",function(){
		var _this = $(this).parent().parent().parent();
		var totalAmount = new BigNumber(0);		
		var unitPrice   = school.string.removeComma(_this.find("input.UNIT_PRICE").val());
		var amtDst		= school.string.removeComma(_this.find("input.AMT_DST").val());
		var amtTotal	= _this.find("input.AMT_TOTAL");
		
		unitPrice		= new BigNumber(unitPrice);
		amtDst			= new BigNumber(amtDst);
		
		totalAmount		= unitPrice.minus(amtDst);		
		
		amtTotal.val(school.string.numberWithComma(totalAmount) );
		school_1005_0102.calculateDtl();
		
	});
	/**
	 * Remove DTL
	 */
	$(document).delegate(".CLS_REMOVE","click", function(){
		var dtlSize = $('#PAYMENT_DTL_RESULT >tr').length;
		if(dtlSize<=1){
			alert("មិនអាចលុបចោលទាំងអស់នោះទេ!");
			return false;			
		}
		var _this = $(this);
		_this.parent().parent().remove();
		school_1005_0102.calculateDtl();
	});
	/**
	 * TODO: ADD DETAIL
	 */
	$(document).delegate("#ADD_PAY_DTL","click",function(){			
		var checkRadio 	= $('#PAYMENT_DTL_RESULT >tr').find('input[type="radio"]:checked');
		var dtlRec = []
		dtlRec.push({
			"PAY_STATUS" 		: "",	
			"PAY_DTL_DESCR"		: "",	
			"UNIT_PRICE" 		: "",	
			"AMT_DST" 			: "",	
			"AMT_TOTAL" 		: "",				
		});
		if(checkRadio.length > 0){
			dtlRec = []; // empty the record
			checkRadio.each(function(e){
				var _this = $(this);
				dtlRec.push({
					"PAY_STATUS" :_this.parent().parent().find(".PAY_STATUS").val(),	
					"PAY_DTL_DT" :_this.parent().parent().find(".PAY_DTL_DT").val(),	
					"UNIT_PRICE" :_this.parent().parent().find(".UNIT_PRICE").val(),	
					"AMT_DST" :_this.parent().parent().find(".AMT_DST").val(),	
					"AMT_TOTAL" :_this.parent().parent().find(".AMT_TOTAL").val(),					
				});
			});
		}	
		school_1005_0102.generatDtl(dtlRec);
		school_1005_0102.calculateDtl();
	});
	/**
	 * TODO: RADION CLICK EVENT
	 */
	$(document).delegate(".myRadio","click",function(){	   	    
		var this_input = $(this);
        if (this_input.attr('checked1') == '11') {		
          this_input.attr('checked1', '11')	

        } else {
          this_input.attr('checked1', '22')		
        }
        $(this_input).prop('checked', false);
        if (this_input.attr('checked1') == '11') {
          this_input.prop('checked', false);
          this_input.attr('checked1', '22')
        } else {
          this_input.prop('checked', true);
          this_input.attr('checked1', '11')
        }
	});
	//TODO: Open Modal
	$("#fnPayer").click(function(){
		$("#STUDENT_LIST_RESULT").html("");
		var url 	= "school_1005_0102_r003.chitra";
		var input	= {};
		$.ajax({
			url		: url,
			data	: input,
			success : function(resp){
				console.log(resp)
				if(resp.success){
					$("#STUDENT_LIST_TMPL").tmpl(resp["STUDENT_REC"]).appendTo("#STUDENT_LIST_RESULT");
					$("#payer_modal").modal({
						backdrop	: 'static', 
						keyboard	: false,
					});						
				}				
			}
		});	
	});
	$("#chStudent").click(function(){
		var checkRadio 	= $('#STUDENT_LIST_RESULT >tr').find('input[type="radio"]:checked');
		var dataRec 	=[];
		checkRadio.each(function(e){				
			dataRec.push($(this).length);
		});		
		if( dataRec.length<= 0 ){
			alert("សូមជ្រើសរើសឈ្មោះសិស្ស")
			return false;
		}
		var stuID 		= checkRadio.parent().parent().find("td.STU_ID").text();
		var stuName 	= checkRadio.parent().parent().find("td.STU_NAME").text();
		$("#txtPayer").val(stuName)
		$("#txtPayer").attr("data-stu-id",stuID);
		$("#txtPayer").attr("data-status","1");		
		$("#payer_modal").modal('hide');
		
		
	});
	
	$("#txtPayer").click(function(){		
	});
	$("#chkPayer").click(function(){
		var _this    = $(this);
		var txtPayer = $("#txtPayer");
		var fnPayer  = $("#fnPayer");
		
		txtPayer.attr("disabled",false);
		fnPayer.css("visibility","hidden");
		txtPayer.val("");
		if(_this.is(':checked')){
			fnPayer.css("visibility","visible");
			txtPayer.attr("disabled",true);
			fnPayer.show();
		}
	});
	
	$("#payType").on("change", function(){
		var _this = $(this);		
		if(_this.val()==="income"){
			school.ui.loadPaymentMethod("#resultMethod");
		}
		
	});
}); // end Ready function
/**
 * TODO SAVE CHANGE
 */
$(document).delegate("#btnSave","click",function(){
	/**
	 * Note
	 * Pay Type 1 = Income
	 * Pay Type 2 = Expense
	 * Pay Status(1) 1 = School Fee
	 * Pay Status(1) 2 = Book Price
	 * Pay Status(1) 0 = Others
	 * Pay Status(2) 1 = Salary
	 * Pay Status(2) 2 = Electricity
	 * Pay Status(2) 0 = Others
	 */
	var student		 		= {};
	var payment		 		= {};
	var paymentDtl	 		= [];
	var input				= {};	
	student["id"]	= $("#txtPayer").attr("data-stu-id");
	payment["description"]= "បង់ថ្លៃសាលា";
	
	$("#PAYMENT_DTL_RESULT >tr").each(function(e){
		paymentDtl.push({
			"payDtlDt"		: school.string.removeAllString( $(this).find(".PAY_DTL_DT").val() ),	
			"payDtlAmtKm"		: school.string.removeAllString( $(this).find(".UNIT_PRICE").val() ),	
			"payDtlDisc" 		: school.string.removeAllString( $(this).find(".AMT_DST").val() ),			
			"pay_status"		: $("#txtPayer").attr("data-status"),
			"pay_type"			: "1",
		});
	});
	input.student		 = student;
	input.payment		 = payment;
	input.paymentDtlRec	 = paymentDtl;
	school_1005_0102.save(input)
});
/**
 *TODO FUNCTION CALCULATE Calculation of total amount
 */
school_1005_0102.calculateDtl = function(){
	var totAmt 		= new BigNumber(0);
	var totDist		= new BigNumber(0);
	var remainTotAmt	= new BigNumber(0);
	$("#PAYMENT_DTL_RESULT >tr").each(function(e){
		var _this = $(this);
		var unitPrice   = school.string.removeComma(_this.find("input.UNIT_PRICE").val());
		var amtDist		= school.string.removeComma(_this.find("input.AMT_DST").val());	
		unitPrice = new BigNumber(unitPrice);
		amtDist = new BigNumber(amtDist);
		
		totAmt = totAmt.plus(unitPrice);
		totDist = totDist.plus(amtDist)
	});	
	remainTotAmt = totAmt.minus(totDist);
	$("#TOT_UNIT_PRICE").val( school.string.numberWithComma( totAmt ) );
	$("#TOT_AMT_DST").val( school.string.numberWithComma( totDist ) );
	$("#TOT_AMT_TOTAL").val( school.string.numberWithComma (remainTotAmt) );
	
};
school_1005_0102.save = function(input){
	$.ajax({
		type: "POST",
		data: JSON.stringify(input),
        contentType: "application/json; charset=utf-8",
		url: "school_1005_0102_c001.chitra",
		success: function(resp){
			if(resp.success){
				alert("Success!");
			}else{
				alert(resp.message);
			}		
			console.log(resp)
			/*if(dat.success){
				school.ui.openWindow(url);
			}*/
		}
	});
	
};
school_1005_0102.generatDtl = function(dtlRec){
	$("#PAYMENT_DTL_TMPL").tmpl(dtlRec).prependTo("#PAYMENT_DTL_RESULT");		
	//Date picker
	school.ui.datetimepicker(".datetimepicker",{
		"format"	: "YYYY-MM",
		"viewMode"	: "months",
	});
      
    //Format the currency
    $(".currency").autoNumeric('init',{
    	emptyInputBehavior: 'zero',
		leadingZero: 'deny',
		allowDecimalPadding: false,
		maximumValue: '999999999999',
		minimumValue: '-999999999999'		
	});	
}
school_1005_0102.loadData = function(input){		
	if(!input) input = {};
/*	var date  = new Date();
	var year  = date.getFullYear();
	var month = date.getMonth();
	month +=1;
	if(month < 10) month = "0"+month;
	
	$("#txtYearMonth").val(year + "-" + month);
	
	*/
}