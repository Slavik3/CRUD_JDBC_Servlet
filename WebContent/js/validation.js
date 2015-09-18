function validateForm() {	
	var name = document.forms["frm"]["name"].value;
	var surname=document.forms["frm"]["surname"].value;
	var email = document.forms["frm"]["email"].value;
	var amountOfMoney = document.forms["frm"]["amountOfMoney"].value;
	var address = document.forms["frm"]["address"].value;
	var birthday = document.forms["frm"]["birthday"].value;
	year=birthday.substring(0, 4);
	var pattern = /^[0-9]+$/;
	var patternEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	
	valid=true;	

	if (name.length == 0) {
		var input = document.getElementById('name');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (name.length != 0) {
		var input = document.getElementById('name');
		input.style.border = "";
	}
	
	if (surname.length == 0) {
		var input = document.getElementById('surname');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (surname.length != 0) {
		var input = document.getElementById('surname');
		input.style.border = "";
	}	
	
	if (email.length == 0) {
		var input = document.getElementById('email');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (email.length != 0) {
		var input = document.getElementById('email');
		input.style.border = "";
	}
	
	if (!patternEmail.test(email)) {
		var input = document.getElementById('email');
		input.style.border = "thin solid red";
		valid= false;
	}
	
	if (patternEmail.test(email)) {
		var input = document.getElementById('email');
		input.style.border = "";
	}	
	
	
	if (birthday.length == 0) {
		var input = document.getElementById('birthday');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (birthday.length != 0) {
		var input = document.getElementById('birthday');
		input.style.border = "";
	}
	if(year>2015 || year< 1895) {
		var input = document.getElementById('birthday');
		input.style.border = "thin solid red";
		valid= false;
	}
	
	if(year<2016 && year>1895) {
		var input = document.getElementById('birthday');
		input.style.border = "";
	}
	
	if (amountOfMoney.length == 0) {
		var input = document.getElementById('amountOfMoney');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (amountOfMoney.length != 0) {
		var input = document.getElementById('amountOfMoney');
		input.style.border = "";
	}
	
	if (!pattern.test(amountOfMoney)) {
		var input = document.getElementById('amountOfMoney');
		input.style.border = "thin solid red";
		valid= false;
	}
	
	if (pattern.test(amountOfMoney)) {
		var input = document.getElementById('amountOfMoney');
		input.style.border = "";
	}	
	
	
	if (address.length == 0) {
		var input = document.getElementById('address');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (address.length != 0) {
		var input = document.getElementById('address');
		input.style.border = "";
	}
	
	return valid;
	

}