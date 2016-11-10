var school;
if(!school) school = {};
if(!school.string){
	school.string = {};
	
	school.string.formatBirthDate = function(str){
		
		return "";
	}
	
	school.string.appendAction = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:"><i>Check the select box to see more actions</i></a></li>';
		$(target).html(li);		
	};
	school.string.appendActionView = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:" id="btnView">View</a></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.string.appendActionMoreEdit = function(target){
		var li = "";
		li += '<li><a href="javascript:" id="downloadExcel">Export excel</a></li>'
			+'<li><a href="javascript:" id="addNew">New registeration</a></li>'
			+'<li class="divider"></li>'
			+'<li><a href="javascript:">Delete</i></a></li>';
		$(target).html(li);		
	};
	school.string.checkboxAll= function(source){
	    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i] != source)
	            checkboxes[i].checked = source.checked;
	    }
	}
	school.string.createPagination = function(target, totalRecord, numberOfRecord, pageCount, callback){
		$(target).html("");
		var input = {};
			/*if(totalRecord==0){
				$("#pagination").html("");
			}else{*/
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
			}
	
}