<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Insurance customer Homepage</title>
</head>
<body>
	<h3>Welcome to Customer Homepage</h3>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="getquote.spring">Get Quote</a></li>
		<li class="nav-item"><a class="nav-link"
			href="retrievequote.spring">Retrive Quote</a></li>
		<li class="nav-item"><a class="nav-link"
			href="buypolicy.spring">Buy Policy</a></li>
		<li class="nav-item"><a class="nav-link"
			href="viewpolicyuser.spring">View Policy</a></li>
		<li class="nav-item"><a class="nav-link"
			href="renewpolicyuser.spring">Renew Policy</a></li>
		<li class="nav-item"><a class="nav-link"
			href="cancelpolicyuser.spring">Cancel Policy</a></li>
		<li class="nav-item"><a class="nav-link" href="logout.spring">Logout</a>
		</li>
	</ul>
	
	<div class="container">
		<span style="color: red">${requestScope.msg} </span>
	</div>
</body>
</html>