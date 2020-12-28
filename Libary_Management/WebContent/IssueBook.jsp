<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
<link href="CSS/IssueBook.css" rel="stylesheet" type="text/css">
</head>
<body>

<a href="LibarianAfterLogin.jsp">Back</a>

<div class="myform">
<div class="container">
<div align="center">

<h1>Issue Book</h1>

<form action="IssueBookServlet" method="post">

<fieldset style="width:400px">
<br/><br/>
<label for="callno">Book Callno : </label>
<input type="text" id="callno" name="callno" required="required"/>
<br/><br/>
<label for="studentid">Student ID : </label>
<input type="email" name="studentid" id="studentid" required="required"/>
<br/><br/>
<label for="studentname">Student Name : </label>
<input type="text" name="studentname" id="studentname" required="required"/>
<br/><br/>
<label for="studentphno">Student Phn No : </label>
<input type="number" name="studentphno" id="studentphno" required="required"/>
<br/><br/>

</fieldset>
<br/>

<input type="submit" value="Issue Book">

</form>
</div>
</div>
<br/><br/>
<div align="center">
<div style="color:blue">
<%
if(request.getAttribute("successmsg")!=null)
{
	out.println(request.getAttribute("successmsg"));
}
%>
</div>
</div>

<div align="center">
<div style="color:red">
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