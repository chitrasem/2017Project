$(document).ready(function(){
	$("ssoId").blur(function(){
		alert("How are you doing?");
		checkAvailability();
	});
	$("#account").submit(function(){
		var account = $(this).serializeObject();
		$.postJSON("account", account, function(data){
			$("#assignedId").val(data.id);
			showPopup()
		});
		return false;
	});
});

var checkAvailability = function(){
	$.getJSON("account/availability", { name: $('#name').val()}, function(availability){
		if(availability.available){
			fieldValidated("name", { valid : true });
		}else{
			fieldValidated("name", { valid : false, 
				message : $("#name").val() + "is not available, try " + availability.suggestions});
		}
	});
	
};