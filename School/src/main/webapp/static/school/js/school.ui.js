if(!school) school = {};
if(!school.ui) {
	school.ui = {};
	
	school.ui.openWindow = function(url){
		window.location.href = url;
	};
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
		
}