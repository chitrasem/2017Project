$(document).ready(function(){
	users.getUserProfiles();
	
});
var users ={
		
		getUserProfiles: function(){
			$.ajax({
				type: "GET",
				url : "http://localhost:8080/LMSAPP/action/service/userProfiles",
				success : function(response){
					console.log(response);
				}
			});
		}
}