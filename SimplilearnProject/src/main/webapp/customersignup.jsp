<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Sign Up</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>

	<div class="container"
		style="border: 2px solid black; padding: 30px; margin: 30px;">
		<form action="customersu.spring" method="post">

			<div class="form-outline mb-2">
				<label class="form-label">Email</label> <input type="email"
					name="email" class="form-control" required />
			</div>

			<div class="form-outline mb-2">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control" required />
			</div>

			<input type="submit" class="btn btn-outline-primary"
				value="Account Create" /> <input type="reset"
				class="btn btn-outline-light" value="Reset" />
		</form>
		

		<div>
			<a href="login.spring" class="link-info">Login</a>
		</div>

	</div>
	<div class="container">
		<span style="color: red">${requestScope.msg} </span>
	</div>
</body>
</html>