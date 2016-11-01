if(!school) school = {};
if(!school.ui) {
	school.ui = {};
	
	school.ui.openWindow = function(url){
		window.location.href = url;
	}
	school.ui.sweetConfrim = function(msg,callback){
		swal({
			  title: "Are you sure?",
			  text: msg,
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#DD6B55",
			  confirmButtonText: "Yes, save it!",
			  closeOnConfirm: false
			},
			function(){
			  swal("Save!", "New student has been save into database.", "success");
			});
		
		if(typeof callback === 'function' && callback()){
			callback();
		}
		
	}
		
}