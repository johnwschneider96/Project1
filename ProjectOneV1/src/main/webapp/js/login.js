/**
 * 
 */

let loginbutton = document.getElementById("LoginButton");
loginbutton.addEventListener('click', function() {
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	localStorage.setItem('username',username);
	localStorage.setItem('password',password);
});