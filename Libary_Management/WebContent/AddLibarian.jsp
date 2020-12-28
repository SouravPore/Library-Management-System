<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Libarian</title>
<link href="CSS/AddLibarian.css" type="text/css" rel="stylesheet" >
</head>
<a href="AdminAfterLogin.jsp">Back</a>
<body>

<div class="myform">
<div align="center">
<h1>Add Libarian</h1>

<form action="AddLibarianServlet" method="post">

<fieldset style="width:300px">

<br/>
<label for="name">Name : </label>
<input type="text" id="name" name="name" required="required"/>
<br/><br/>
<label for="email">Email ID : </label>
<input type="email" name="email" id="email" required="required" placeholder="Enter email"/>
<br/><br/>
<label for="password">Password : </label>
<input type="password" id="password" name="password" required="required"/>
<br/><br/>
<label for="mobileno">Mobile No :  </label>
<input type="number" id="mobileno" name="mobileno" required="required"/>
<br/><br/>
</fieldset>
<br/>
<input type="submit" value="SUBMIT"/>

</form>
<br/><br/>
<div style="color:blue" >

<%
if(request.getAttribute("successmsg")!=null)
{
	out.println(request.getAttribute("successmsg"));
}
%>

</div>
</div>
</div>
</body>
</html>