<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
<link href="CSS/ReturnBook.css" type="text/css" rel="stylesheet">

</head>
<body>
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">

<h1>Return Book</h1>
<div class="A">
<form action="ReturnBookServlet" method="post">

<fieldset style="width:300px">
<br/>

<label for="callno">Callno : </label>
<input type="text" id="callno" name="callno" required="required"/>
<br/><br/>
<label for="studentid">Student ID : </label>
<input type="email" id="studentid" name="studentid" required="required"/>
<br/>

</fieldset>
<br/>
<input type="submit" value="Return Book"/>

</form>
</div>
</div>
</div>
<br/><br/>
<div style=color:blue>
<div align="center">
<%
if(request.getAttribute("successmsg")!=null)
{
	out.println(request.getAttribute("successmsg"));
}
%>
</div>
</div>

<br/><br/>
<div style=color:red>
<div align="center">
<%
if(request.getAttribute("errormsg")!=null)
{
	out.println(request.getAttribute("errormsg"));
}
%>
</div>
</div>


</body>
</html>