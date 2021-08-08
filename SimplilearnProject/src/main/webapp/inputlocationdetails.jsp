<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Location Details Page</title>
</head>
<body>
<h4>Input your Location Details:</h4>
	<form action="locationinputdetail.spring" method="post">
		<div class="form-group">
			<label for="rt">Choose a Residence Type:</label> <select name="restype" id="rt">
				<option value="singlefamilyhome">single family home</option>
				<option value="condo">condo</option>
				<option value="townhouse">townhouse</option>
				<option value="rowhouse">row house</option>
				<option value="duplex">duplex</option>
				<option value="apartment">apartment</option>
			</select>
		</div>
		<div class="form-group">
			<label>Address Line 1<input type="text" name="al1" required></label>
		</div>
		<div class="form-group">
			<label>City<input type="text" name="city" required></label>
		</div>
		<div class="form-group">
			<label>State<input type="text" name="state" required></label>
		</div>
		<div class="form-group">
			<label>Zip<input type="text" name="zip" pattern="[0-9]{6}"required></label>
		</div>
		<div class="form-group">
			<label for="rs">Choose a Residence Type:</label> <select name="resuse" id="rsuse">
				<option value="primary">primary</option>
				<option value="secondary">secondary</option>
				<option value="rentalproperty">rental property</option>
				</select>
		</div>
		<input type="submit" class="btn btn-primary " value="Submit" /> <input
			type="reset" class="btn btn-secondary" value="Reset" /> 
	</form>
	<div>
		<span style="color: red">${requestScope.msg}</span>
	</div>

</body>
</html>