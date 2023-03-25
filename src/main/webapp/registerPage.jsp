<%--
  Created by IntelliJ IDEA.
  User: gvabski
  Date: 3/14/2023
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
<h1>Registration</h1>

<form action="registration-servlet" method="post">
<label for="email"><b>Enter your username or email</b></label>
<input type="text" placeholder="Username/E-Mail" name="email" id="email" required><br><br>

<label for="psw"><b>Enter your password</b></label>
<input type="password" placeholder="Password" name="psw" id="psw" required><br><br>

<label for="repeatPassword"><b>Enter your Password again</b></label>
<input type="password" placeholder="Confirm Password" name="repeatPassword" id="repeatPassword" required><br><br>


<label for="firstName"><b>Enter your name</b></label>
<input type="text" placeholder="Name" name="firstName" id="firstName" required><br><br>

<label for="surname"><b>Enter your surname</b></label>
<input type="text" placeholder="Surname" name="surname" id="surname" required><br><br>

<label for="profession"><b>Enter Your Profession</b></label>
<input type="text" placeholder="Profession" name="profession" id="profession" required><br><br>


<input type="submit" value="Register">
<p>Already haven an account?<a href="index.jsp"><b>Sign In</b></a></p>
</form>

</body>
</html>
