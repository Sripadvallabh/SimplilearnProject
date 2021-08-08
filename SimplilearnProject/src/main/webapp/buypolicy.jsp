<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Policy Page</title>
</head>
<body>
	<h3>Buy Policy Page</h3>
	<div>Quote Id: ${sessionScope.qid}</div>
	<form action="confirmpolicy.spring" method="post">
		<div><label>Enter
			your Policy Start Date<input type="date" name="policystartdate" required>
			<small>Policy start date should not be more than 60 days from today</small>
		</label></div> <div><label>Enter your Policy End Date<input type="date"
			name="policyenddate" required></label></div> <div><input type="submit" value="submit"></div> 
	</form>

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