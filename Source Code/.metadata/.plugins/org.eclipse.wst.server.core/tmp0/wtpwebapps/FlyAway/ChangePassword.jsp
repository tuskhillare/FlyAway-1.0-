<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
</head>
<body>
	<a href="Dashboard.jsp">Dashboard</a>
	
	<h1>Change Password</h1>
	<form name="change password" method="POST" action="ChangePassword">
		New Password : <input type="password" name="password"> <br/>
		Confirm New Password: <input type="password" name="confirmpassword"> <br/>
		<br/>
		<input type="submit" value="Change password">
	</form>
	
</body>
</html>