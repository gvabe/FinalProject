
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<h1>Hello <%=request.getParameter("firstName")%></h1>
<p>Update failed, try again</p>
<form action="userPage" method="post">
    <label for="email"><b>Update your email</b></label>
    <input type="text" placeholder="Email" name="email" id="email" ><br><br>

    <label for="psw"><b>Update your password</b></label>
    <input type="password" placeholder="Password" name="psw" id="psw" ><br><br>

    <label for="repeatPassword"><b>Enter your Password again</b></label>
    <input type="password" placeholder="Confirm Password" name="repeatPassword" id="repeatPassword" ><br><br>


    <label for="firstName"><b>Update your name</b></label>
    <input type="text" placeholder="Name" name="firstName" id="firstName"><br><br>

    <label for="surname"><b>Update your surname</b></label>
    <input type="text" placeholder="Surname" name="surname" id="surname"><br><br>

    <label for="profession"><b>Update Your Profession</b></label>
    <input type="text" placeholder="Profession" name="profession" id="profession"><br><br>


    <input type="submit" value="Update">
    <button><a href="index.jsp">Log out</a></button>
</form>

</body>
</html>
