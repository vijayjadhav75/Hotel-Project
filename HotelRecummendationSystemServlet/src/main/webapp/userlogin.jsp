<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user login</title>
<link rel="stylesheet" href="CSS/userlogin.css">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f2f2f2;
}

.login-container {
	width: 300px;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-container h2 {
	text-align: center;
	color: #333;
}

.input-group {
	margin-bottom: 20px;
}

.input-group label {
	display: block;
	margin-bottom: 8px;
	color: #666;
}

.input-group input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.input-group button {
	width: 100%;
	padding: 10px;
	background-color: #4caf50;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.input-group button a {
	text-decoration: none;
	color: #fff;
}

@media ( max-width : 400px) {
	.login-container {
		width: 80%;
	}
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>User Login</h2>
		<form name='frm' action='userValidate' method='POST'>
			<div class="input-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required>
			</div>
			<div class="input-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="input-group">
				<button type="submit">Login</button>
			</div>
			<div class="input-group">
				<button>
					<a href='register.jsp'>SignUp</a>
				</button>
			</div>
		</form>
	</div>
</body>
</html>