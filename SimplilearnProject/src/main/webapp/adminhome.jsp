<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Insurance Admin Homepage</title>
</head>
<body>
	<h3>Welcome to Admin homepage</h3>
	<form action='searchadmin.spring' method='post'>
		<label>Search by user email:<input type="email" name="email"></label>
		<input type="submit" value="submit">
	</form>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="getstartedadmin.spring">Link to get started</a></li>
		<li class="nav-item"><a class="nav-link" href="logout.spring">Logout</a>
		</li>
	</ul>

	<div class="container">
		<span style="color: red">${requestScope.msg} </span>
	</div>
</body>
</html>