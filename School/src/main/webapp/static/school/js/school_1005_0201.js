var school_1005_0201 = {};
$(document).ready(function(){
	school_1005_0201.loadData();
	school.ui.setYearCombo("#proYear");
});
school_1005_0201.loadData = function(input){
	if(!input) input = {};
	var url = 'school_1005_0201_r001.chitra';
	$.ajax({
		url: url,
		success: function(resp){
			$("#PAYMENT_TOT_TMPL").tmpl(resp.YEARLY_REC).appendTo("#PAYMENT_TOT_RESULT");
			$("#PAYMENT_TMPL").tmpl(resp.YEARLY_REC).appendTo("#PAYMENT_RESULT");
			//school.ui.createPagination("#pagination", dat.totalStudent, input.numberOfRecord, input.pageCount, school_1002_0301.loadData);
			school_1005_0201.generateTable();
		}
	
	});	
}
school_1005_0201.generateTable = function(){
	var table = $("#dtTable").removeAttr('width').DataTable({
		searching 		: false,
		bSort			: false,
		scrollY			: "513px",
		bInfo			: false,
		scrollX			: true,
		scrollCollapse	: true,
		paging			: false,
		paging 			: false,
		autoWidth		: false,
		fixedColumns 	: {
			leftColumns	: 4,
            heightMatch : 'none',
		}
	});
	
}