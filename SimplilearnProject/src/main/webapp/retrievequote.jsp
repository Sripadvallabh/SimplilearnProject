<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Quote Page</title>
</head>
<body>
	<h3>Retrieve Quote Page</h3>
	<br/>
	Quote Id: ${sessionScope.QuoteDetails.quoteId}
	<br /> Residence Type: ${sessionScope.LocationDetails.residenceType}
	<br /> Address line 1: ${sessionScope.LocationDetails.addressLine1}
	<br /> City: ${sessionScope.LocationDetails.city}
	<br /> State: ${sessionScope.LocationDetails.state}
	<br /> Zip: ${sessionScope.LocationDetails.zip}
	<br /> Residence Use: ${sessionScope.LocationDetails.residenceUse}
	<br />
	<a href="summaryquote.spring" class="btn btn-primary ">Click Here
		for summary page</a>

	
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