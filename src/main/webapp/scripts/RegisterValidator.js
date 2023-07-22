function validate(){
	let error ="";
	let u = document.forms["register"]["username"].value;
	let pw = document.forms["register"]["password"].value;
	let cpw = document.forms["register"]["confirmPassword"].value;
	let success = true;
	if(!u.match(/^\w+$/)){
		success = false;
		error+="Username deve contentere solo caratteri alfanumerici.<br>";
	}	
	if(pw!=cpw){
		success = false;
		error+="Conferma Password non valida.<br>";
	}
	document.getElementById("errorBox").innerHTML = error;
	return success;
}