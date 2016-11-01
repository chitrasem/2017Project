
$(document).ready(function(){
	contact.list_all_students();	
});


var contact ={
		list_all_students: function(){
			console.log("List All Students");
			$.ajax({
				type: "GET",
				url: "../dashboard/contact_list",
				beforeSend: function(){
				},
				success: function(response){
					console.log(response);
					
				},
				error: function(){
					alert("Error!"); 
					
				}
					
			});
		},
		create_new_studnet: function(){
			
		},
		update_student: function(){
			
		},
		delete_student: function(){
			
		}	
		
};