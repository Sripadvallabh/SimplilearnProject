<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Property details page</title>
</head>
<body>
	<h4>Input your Property Details:</h4>
	<form action="propertyinputdetail.spring" method="post">
		<div class="form-group">
			<label>Market Value of your home:<input type="text"
				name="mv" required></label>
		</div>
		<div class="form-group">
			<label>Year of construction<input type="text" name="yr"
				pattern="[0-9]{4}" required></label>
		</div>
		<div class="form-group">
			<label>Square Footage<input type="text" name="sf" required></label>
		</div>
		<div class="form-group">
			<label for="ds">Choose a Dwelling Style:</label> <select name="ds" id="ds">
				<option value="1 Storey">1 Storey</option>
				<option value="1.5 Storey">1.5 Storey</option>
				<option value="2 Storey">2 Storey</option>
				<option value="2.5 Storey">2.5 Storey</option>
				<option value="3 Storey">3 Storey</option>
			</select>
		</div>
		<div class="form-group">
			<label for="rm">Choose a Roof Material:</label> <select name="rm" id="rm">
				<option value="Concrete">Concrete</option>
				<option value="Clay">Clay</option>
				<option value="Rubber">Rubber</option>
				<option value="Steel">Steel</option>
				<option value="Tin">Tin</option>
				<option value="Wood">Wood</option>
			</select>
		</div>
		<div class="form-group">
			<label for="tog">Choose a Type of Garage:</label> <select name="tog" id="tog">
				<option value="Attached">Attached</option>
				<option value="Detached">Detached</option>
				<option value="Basement">Basement</option>
				<option value="Built-in">Built-in</option>
			</select>
		</div>
		<div class="form-group">
			<label for="Nooffullbaths">Choose the no of full baths:</label> <select name="fb" id="nofb">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="more">more</option>
			</select>
		</div>
		<div class="form-group">
			<label for="Noofhalfbaths">Choose the no of half baths:</label> <select name="hfb" id="nohb">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="more">more</option>
			</select>
		</div>
		<div class="form-group">
		<label>Does Your Home have a swimming pool</label>
		<label>Yes<input type="radio" name="pa" value="yes" required></label>
		<label>No<input type="radio" name="pa" value="no" required></label>
		</div>
		<input type="submit" class="btn btn-primary " value="Submit" /> <input
			type="reset" class="btn btn-secondary" value="Reset" />
	</form>
	<div>
		<span style="color: red">${requestScope.msg}</span>
	</div>
</body>
</html>