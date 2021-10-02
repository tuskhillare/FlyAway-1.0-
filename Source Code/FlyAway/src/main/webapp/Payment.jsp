<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
</head>
<body>
	<h1>Enter Payment Details</h1>
	<form name="paymentDetails" method="POST" action="PayOnline">	
		First Name On Card : <input type="text" name="firstname" placeholder="Tushar" required> <br/>
		Last Name On Card : <input type="text" name="lastname" placeholder="Khillare" required> <br/>
		Card Number: <input type="text" name="cardnumber" placeholder="1234 1234 4321 9123" required> <br/>
		Expire Date (yyyy-MM-dd) : <input type="date" name="expiration" placeholder="2027-10-31"  required> <br/>
		Security Code : <input type="number" name="securitycode" placeholder="987" required> <br/>
		<br/>
		<input type="submit" value="Pay Ticket">
	</form>	
</body>
</html>