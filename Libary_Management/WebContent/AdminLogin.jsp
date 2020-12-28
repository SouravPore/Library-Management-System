<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link href="CSS/AdminLogin.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="index.jsp">Back</a>

<div class="container">
<div align="center">
<form action="AdminLoginServlet" method="post">

<h1>Admim Login</h1>

<label for="adminid">Admin Id : </label>
<input type="text" id="adminid" name="adminid" required="required" placeholder="Enter ID"/>
<br/><br/>
<label for="adminpass">Password : </label>
<input type="password" id="adminpass" name="adminpass" required="required"/>
<br/><br/><br/>
<input type="submit" value="SUBMIT"/>&nbsp;&nbsp;
<input type="reset" value="RESET"/>

</form>

<br/><br/>
<div style="color:red" >
<%
if(request.getAttribute("errormsg")!=null)
{
	out.println(request.getAttribute("errormsg"));
}
%>
</div>
</div>
</div>


</body>
</html>