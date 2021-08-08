<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Policy Admin Page</title>
</head>
<body>
<h3>Cancel Policy Admin Page</h3>
<form action="cancelconfirmadmin.spring" method="post">
	<input type="submit" value="Are You Sure">
	</form>
	
<div class="container">
		<ul class="nav">
			<li class="nav-item"><a class="nav-link"
				href="getstartedadmin.spring">Get Started Page</a></li>
		</ul>
	</div>
<div class="container">
		<span style="color: red">${requestScope.msg} </span>
	</div>
	</body>
</html>