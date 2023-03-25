<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form action="login-servlet" method="post">
        <h1>Sign in</h1>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Username or Email" name="email" id="email" required> <br><br>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Password" name="psw" id="psw" required><br><br>

        <input type="submit" value="Sign In">
        <button><a href="registerPage.jsp" type="submit">Register</a></button>

</form>
