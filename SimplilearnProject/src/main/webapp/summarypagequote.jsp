<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quote summary page</title>
</head>
<body>
	<h3>Quote summary page</h3>
	<h4>Location Details</h4>
	<br /> Residence Type: ${sessionScope.LocationDetails.residenceType}
	<br /> Address line 1: ${sessionScope.LocationDetails.addressLine1}
	<br /> City: ${sessionScope.LocationDetails.city}
	<br /> State: ${sessionScope.LocationDetails.state}
	<br /> Zip: ${sessionScope.LocationDetails.zip}
	<br /> Residence Use: ${sessionScope.LocationDetails.residenceUse}
	<br />
	<h4>Home Owner Details</h4>
	<br /> FirstName: ${sessionScope.HomeOwnerDetails.firstName}
	<br /> LastName: ${sessionScope.HomeOwnerDetails.lastName}
	<br /> DateofBirth: ${sessionScope.HomeOwnerDetails.dateofBirth}
	<br />Are you retired: ${sessionScope.HomeOwnerDetails.areyouretired}
	<br />SocialSecurityNumber: ${sessionScope.HomeOwnerDetails.socialSecurityNumber}
	<br />EmailAddress: ${sessionScope.HomeOwnerDetails.emailAddress}
	<br />

	<h4>Property Details</h4>
	<br />MarketValue: ${sessionScope.PropertyDetails.marketValue}
	<br /> Year: ${sessionScope.PropertyDetails.year}
	<br />SquareFootage: ${sessionScope.PropertyDetails.squareFootage}
	<br />DwellingStyle: ${sessionScope.PropertyDetails.dwellingStyle}
	<br />RoofMaterial: ${sessionScope.PropertyDetails.roofMaterial}
	<br />GarageType: ${sessionScope.PropertyDetails.garageType}
	<br />NoOfFullBaths: ${sessionScope.PropertyDetails.noOfFullBaths}
	<br />NoOfHalfBaths: ${sessionScope.PropertyDetails.noOfHalfBaths}
	<br />PoolAvailability: ${sessionScope.PropertyDetails.poolAvailable}
	<br />
	<h4>Your quote info</h4>
	<br /> Quote Id: ${sessionScope.QuoteDetails.quoteId}
	<br /> Monthly Premium: $${sessionScope.QuoteDetails.monthlyPremium}
	<br /> Dwelling Coverage: $${sessionScope.QuoteDetails.dwellingCoverage}
	<br /> Detached Structures: $${sessionScope.QuoteDetails.detachedStructures}
	<br /> Personal Property: $${sessionScope.QuoteDetails.personalProperty}
	<br /> Medical expense: $${sessionScope.QuoteDetails.medicalExpense}
	<br /> Additional living
	expense: $${sessionScope.additionalLivingExpense}
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