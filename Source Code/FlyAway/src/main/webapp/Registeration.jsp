<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Registration Page</title>
</head>
<body>
<center>
	<h1>Flight Registration Page</h1>
	<hr>
	</br>
	</br>
	<form name="flightRegistraton" method="POST" action="Registeration">
		Flight ID : <input type="number" name="flightid" placeholder="12" required> <br/>
		First Name : <input type="text" name="firstname" placeholder="Tushar" required> <br/>
		Last Name : <input type="text" name="lastname" placeholder="Khillare" required> <br/>
		Email : <input type="email" name="email" placeholder="tusharkhillare2015@gmail.com" required> <br/>
		Birthday (YYYY-MM-DD) : <input type="text" name="birthdate" placeholder="1999-10-07" required> <br/>
		<br/>
		<input type="submit" value="Submit Flight Registration">
	</form>
	</center>
</body>
</html>