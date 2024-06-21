<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="CSS/userregister.css">
</head>
<body>
	<jsp:include page="index.html"></jsp:include>
	<br>
	<div class="container">
		<h2>Registration Form</h2>
		<form name='frm' action="userReg" method="post">
			<label for="name">Name:</label> <input type="text" id="name"
				name="name" required> <label for="gmail">Gmail:</label> <input
				type="gmail" id="gmail" name="gmail" required> <label
				for="contact">Contact Number:</label> <input type="text"
				id="contact" name="contact" required> <label for="username">Username:</label>
			<input type="text" id="username" name="username" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" required> <label
				for="confirmPassword">Confirm Password:</label> <input
				type="password" id="confirmPassword" name="confirmPassword" required>
			<button name='s' type="submit">Register</button>
		</form>
	</div>
</body>
</html>