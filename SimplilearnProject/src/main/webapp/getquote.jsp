<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>getquote page</title>
</head>
<body>
	<h3>Welcome to get quote page</h3>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="displayinputhomeownerdetails.spring">Input HomeOwner
				Details</a></li>
		<li class="nav-item"><a class="nav-link"
			href="displayinputpropertydetails.spring">Input Property Details</a></li>
		<li class="nav-item"><a class="nav-link"
			href="displayinputlocationdetails.spring">Input Location Details</a></li>
		<li class="nav-item"><a class="nav-link"
			href="displayquoteinfo.spring">Click here
				for quote info</a></li>
	</ul>
	
	<div class="container">
		<ul class="nav">
			<li class="nav-item"><a class="nav-link"
				href="customerhome.spring">Customer Home</a></li>
		</ul>
	</div>
<div class="container">
		<span style="color: red">${requestScope.msg} </span>
	</div>
	</body>
</html>