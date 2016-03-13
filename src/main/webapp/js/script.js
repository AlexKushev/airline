$(function() {

	$('#loginButton').click(function() {
		callForLogin();
	})

});

function callForLogin() {

	var userData = {
		email : $("#email").val(),
		password : $("#password").val()
	};

	$.ajax({
		url : 'rest/passenger/login',
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify(userData),
		statusCode : {
			401 : function() {
				alert("Wrong email/password");
			},
			200 : function() {
				alert("You logged in!");
				window.location.replace("home.html");
				
				var currentPassenger = null;
				
				$.getJSON('rest/passenger/current', function(data) {
					console.log(data.firstName);
					currentPassenger = data.firstName;
					alert(data.firstName);
				});
				
			}
		}
	});

}