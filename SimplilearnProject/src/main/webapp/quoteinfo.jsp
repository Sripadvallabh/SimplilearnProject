<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>quote info</title>
</head>
<body>
	<h3>your quote info</h3>
	
	<br /> Quote Id: ${sessionScope.QuoteDetails.quoteId}
	<br /> Monthly Premium: $${sessionScope.QuoteDetails.monthlyPremium}
	<br /> Dwelling Coverage: $${sessionScope.QuoteDetails.dwellingCoverage}
	<br /> Detached Structures: $${sessionScope.QuoteDetails.detachedStructures}
	<br /> Personal Property: $${sessionScope.QuoteDetails.personalProperty}
	<br /> Medical expense: $${sessionScope.QuoteDetails.medicalExpense}
	<br /> Additional living expense: $
	${sessionScope.QuoteDetails.additionalLivingExpense}
	<br /> Deductible: $${sessionScope.QuoteDetails.deductible}
	<br />
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