var school_1005_0102 = {};

$(document).ready(function(){		
	school_1005_0102.loadData();
	// Event
	$(document).delegate(".CLS_REMOVE","click", function(){
		var _this = $(this);
		_this.parent().parent().remove();
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
					"PAY_DTL_DESCR" :_this.parent().parent().find(".PAY_DTL_DESCR").val(),	
					"UNIT_PRICE" :_this.parent().parent().find(".UNIT_PRICE").val(),	
					"AMT_DST" :_this.parent().parent().find(".AMT_DST").val(),	
					"AMT_TOTAL" :_this.parent().parent().find(".AMT_TOTAL").val(),					
				});
			});
		}
		$("#PAYMENT_DTL_TMPL").tmpl(dtlRec).appendTo("#PAYMENT_DTL_RESULT");	
		
		//Date picker
	    $('.datetimepicker').datetimepicker({
	        format: "YYYY-MM",
	        viewMode: "months", 
	        minViewMode: "months",
	        pickTime: false,
	        showTodayButton: true,
	    });
	    
	    //Format the currency
	    $(".currency").autoNumeric('init',{
			wEmpty: 'zero',
			lZero: 'deny',
		    aPad: false,
		    vMax: '999999999999',
		    vMin: '-999999999999'		
		});
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
school_1005_0102.check = function(traget){	
	console.log(target)
	$(target).checked = true;
}
school_1005_0102.uncheck = function(target){	
	$(target).checked = false;
	
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