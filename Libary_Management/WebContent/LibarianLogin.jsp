<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libarian Login</title>
<link href="CSS/LibarianLogin.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="index.jsp">Back</a>

<div class="container">
<div align="center">
<h1>Libarian Login</h1>
<br/>

<form action="LibarianLoginCheckServlet" method="post">

<label for="email">Email ID : </label>
<input type="email" id="email" name="email" required="required" placeholder="Enter Email"/>
<br/><br/>
<label for ="password">Password : </label>
<input type="password"id="password" name="password" required="required"/>

<br/><br/><br/>

<input type="submit" value="SUBMIT"/> &nbsp;
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