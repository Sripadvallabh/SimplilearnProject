<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Policies view page</title>
</head>
<body>
	<h3>User Policy Details:</h3>
		<div>
			<br />Policy Key:${pd.policyKey} <br /> Quote Id:${pd.quoteId} <br />Policy
			Effective Date:${pd.policyEffectiveDate} <br />Policy End
			Date:${pd.policyEndDate} <br />Policy Term:${pd.policyTerm} <br />Policy
			Status:${pd.policyStatus} <br />
		</div>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link"
			href="renewpolicyadmin.spring">Renew Policy</a></li>
		<li class="nav-item"><a class="nav-link"
			href="cancelpolicyadmin.spring">Cancel Policy</a></li>
	</ul>

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