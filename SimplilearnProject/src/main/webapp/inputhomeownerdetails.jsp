<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input home owner details page</title>
</head>
<body>
<h4>Input Home Owner Details:</h4>
	<form action="homeownerinputdetail.spring" method="post">
		<div class="form-group">
			<label>First Name<input type="text" name="fname" required></label>
		</div>
		<div class="form-group">
			<label>Last Name<input type="text" name="lname" required></label>
		</div>
		<div class="form-group">
			<label>DOB<input type="date" name="dob" pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" required>
		</label> 
		</div>
		<div class="form-group">
			<label>Retired Status</label>
			<label>Yes<input type="radio" name="rs" value="yes" required></label>
			<label>No<input type="radio" name="rs" value="no" required></label>
		</div>
		<div class="form-group">
			<label>SSN<input type="text" name="ssn" pattern="[0-9]{9}" required></label>
		</div>
		<div class="form-group">
			<label>Password<input type="password" name="password" required></label>
		</div>
		<input type="submit" class="btn btn-primary " value="Submit" /> <input
			type="reset" class="btn btn-secondary" value="Reset" /> 
	</form>
	<div>
		<span style="color: red">${requestScope.msg}</span>
	</div>
</body>
</html>