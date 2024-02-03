<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style>
body {
	 background-color: black; 
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

h2{
	color: red ;
}

header{
	background-color: black;
	color: white;
	text-align: center;
	padding: 3px; /* Adjusted padding */
	width: 100%;
	box-sizing: border-box;
	position: fixed;
	top: 0;
}

footer {
	background-color: black;
	color: white;
	text-align: center;
	padding: 3px; /* Adjusted padding */
	width: 100%;
	box-sizing: border-box;
	position: fixed;
	bottom: 0;
}

.login-box {
	background-color: black;
	color : white ;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
	margin-top: 40px;
}

input {
	width: 100%;
	padding: 8px;
	margin: 8px 0;
	box-sizing: border-box;
}

.success {
	font-size : 150%;
	font-weight : bold;
    color: green;
}

.failure {
	font-size : 150%;
	font-weight : bold;
    color: red;
}

button {
	background-color: #008000;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.goRegister {
	color:white;
    text-align: center;
    margin-top: 20px;
}

.goRegister a {
    color: blue;
    text-decoration: none;
    font-weight: bold;
}

</style>

<script>
	function validateForm() {
		var email = document.getElementById("email").value;
		var emailError = document.getElementById("email-error");

		// Simple email validation
		var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (!emailPattern.test(email)) {
			emailError.textContent = "Invalid email address";
			return false;
		} else {
			emailError.textContent = "";
			return true;
		}
	}
</script>
</head>
<body>
	<header>
		<h5></h5>
	</header>
	<div class="login-box">
		<h1>Login</h1>
		<form action="${pageContext.request.contextPath}/loginForm" method="post" id="loginForm"
			onsubmit="return validateForm()">
			<label for="email">Email:</label> <input type="text" name="email"
				id="email" placeholder="Enter your email" required> <span
				id="email-error"></span> <label for="password">Password:</label> <input
				type="password" name="password" id="password"
				placeholder="Enter your password" required>

			<button type="submit">Login</button>
		</form>
	</div>
	<div class="goRegister">
        <p>Have not registered? <a href="register">Register</a></p>
        <a href="forgetPassword">Forget Password</a>
    </div>
    
   <h2>${invalid}</h2> 
	<footer>
		<h5></h5>
	</footer>
</body>
</html>
