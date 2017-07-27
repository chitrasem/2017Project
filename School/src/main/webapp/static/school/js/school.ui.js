if(!school) school = {};
if(!school.ui) {
	school.ui = {};
	
	school.ui.openWindow = function(url){
		window.location.href = url;
	};
	/**
	 * Create Date time picker with format yyyy-mm
	 * @param target
	 */
	school.ui.datetimepickerYYYYMM = function(target){
	  $(target).datetimepicker({
	        format: "YYYY-MM",
	        viewMode: "months", 
	        minViewMode: "months",
	        pickTime: false,
	        showTodayButton: true,
	    });
	}
	school.ui.sweetConfrim = function(msg){
		var isConfirmed = false;
		swal({
			  title: "Are you sure?",
			  text: msg,
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#DD6B55",
			  confirmButtonText: "Yes, save it!",
			  closeOnConfirm: false
			},
			function(isConfirm){
				if(isConfirm){
					swal("Save!", "New student has been save into database.", "success");	
					isConfirmed = true;
				}else{
					swal("Cancelled", "error");
					isConfirmed = false;
				}
			});
		return isConfirmed;		
	};
	school.ui.addCourseCombo = function(target,service, courseId){
		if(!courseId) var courseId = "0";
		$.ajax({
			url: service,
			type: "GET",
			success: function(dat){
				var select = "<option value='0'>Choose Course...</option>";
				for(var i = 0; i<dat.courseRec.length; i++){
					select += "<option value='"+dat.courseRec[i].id+"'>"
					+ dat.courseRec[i].course +"(" + dat.courseRec[i].academicYear.academicYear+")</option>";
				}
				
				$(target).html(select);
				$(target).val(courseId);
			}
		});
	}
	school.ui.appendAction = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:"><i>Check the select box to see more actions</i></a></li>';
		$(target).html(li);		
	};
	school.ui.loadPaymentMethod = function(target){
		var select = "<div class='col-md-6'>" +
				"<div class='form-group'>" +
				"<label class='control-label col-sm-4' for='payMethod'>Method</label>" +
				"<div class='col-sm-8'>";
		 
		select += "<select id='payMethod' class='btn btn-sm btn-purple'>" +
					"<option value=''> Choose...</option>" +
					"<option value='student'>Student School Fee</option>" +
					"<option value='book'>Buy Book</option>" +
					"<option></option>" +
					"<option></option>" +
					"<option></option>" +
				"</select>" +
				"</div>" +
				"</div>" +
				"</div>";
		
		$(target).html(select);
	}
	school.ui.appendActionView = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:" id="btnView">View</a></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.ui.appendActionMoreEdit = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.ui.checkboxAll= function(source){
	    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i] != source)
	            checkboxes[i].checked = source.checked;
	    }
	}
	school.ui.createPagination = function(target, totalRecord, numberOfRecord, pageCount, callback){
		$(target).html("");
		var input = {};
			if(totalRecord===0){
				$(target).html("");
			}else{
				var a = totalRecord % numberOfRecord; // 5				
				var numberOfPaging = Math.floor(totalRecord / numberOfRecord);
			
				if(a>0){			
					numberOfPaging += 1;			
				}
				var paging = "<ul class='pagination'>"+
								"<li class='pagePrevious disabled'><a href='javascript:' aria-label='Previous'>" +
									"<span aria-hidden='true'>&laquo;</span></a></li>";
				
				for(var i=1; i<(numberOfPaging+1);i++){
					if(i == pageCount) {
						paging += "<li class='active'><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";
						continue;
					}
					
					paging += "<li><a class='numberOfPage' href='javascript:'>"+i+"</a></li>";			
				}
				paging +='<li class="pageNext disabled"><a href="javascript:" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
				paging += "</u>";			
				$(target).html(paging);				
		
				if(pageCount == 1){
					$("ul.pagination li.pagePrevious").addClass("disabled");
				}else{
					$("ul.pagination li.pagePrevious").removeClass("disabled");
				}
				if(pageCount == numberOfPaging){
					$("ul.pagination li.pageNext").addClass("disabled");
				}else{
					$("ul.pagination li.pageNext").removeClass("disabled");				
				}
				$("li a.numberOfPage").on("click", function(){ 
						pageCount = Number($(this).text());
						if($.isFunction(callback)){
							input.pageCount = pageCount;
							callback(input);
						}
						//student.list_all_students();
				});
				$("ul.pagination li.pagePrevious").on("click", function(){
					if(pageCount == 1){
						return false;
					}else{
						pageCount -= 1;

						if($.isFunction(callback)){
							input.pageCount = pageCount;
							callback(input);
						}
					}
				});
				$("ul.pagination li.pageNext").on("click", function(){
					if(numberOfPaging == pageCount){
						return false;
					}else{
						pageCount += 1;

						if($.isFunction(callback)){
							input.pageCount = pageCount;
							callback(input);
						}
					}
				});
			};
	}
}