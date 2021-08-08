<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View policy page</title>
</head>
<body>
	<h3>View your policy details:</h3>
			<div>
				<br />Policy Key:${pd.policyKey} <br />
				Quote Id:${pd.quoteId} <br />Policy
				Effective Date:${pd.policyEffectiveDate} <br />Policy
				End Date:${pd.policyEndDate} <br />Policy
				Term:${pd.policyTerm} <br />Policy
				Status:${pd.policyStatus} <br />
			</div>
	
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