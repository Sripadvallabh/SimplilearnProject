<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Insurance Web Application</title>
</head>
<body>
<h4>Welcome to Home Insurance Web Application</h4>
<div class="container"
		style="border: 2px solid black; padding: 30px; margin: 30px;">
		<form action="loginCheck.spring" method="post">
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					class="form-control" id="email" name="email"
					aria-describedby="emailHelp"> 
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="password"
					type="password" class="form-control" id="password">
			</div>

			<div class="form-group">
				<label class="form-check-label" for="flexRadioDefault1">Type
					Of User</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="typeOfUser"
						id="typeOfUser1" value="customer" checked> <label
						class="form-check-label" for="typeOfUser1"> Customer </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="typeOfUser"
						id="typeOfUser2" value="admin"> <label
						class="form-check-label" for="typeOfUser2"> Admin</label>
				</div>
			</div>
			<input type="submit" class="btn btn-primary " value="Sign In" /> <input
				type="reset" class="btn btn-secondary" value="Reset" />
				<a href="csu.spring" class="btn btn-primary " >Sign Up</a>
		</form>
		<div>
			<span style="color: red">${requestScope.msg}</span>
		</div>
		<div>
			<span style="color: red">${message}</span>
		</div>
	</div>
</body>
</html>