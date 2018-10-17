$(document).ready(function(){
	var regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
	var email = $("#myEmail").val();

	if (regEmail.test(email)) {
		console.log("Email correcto");
	} else {
		console.log("Email incorrecto");
	}

});