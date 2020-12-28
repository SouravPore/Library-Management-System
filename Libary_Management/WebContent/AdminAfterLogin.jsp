<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin After</title>
<link href="CSS/AdminAfter.css" type="text/css" rel="stylesheet" >
</head>
<body>

<div class="container">
<div align="center">
<h1>Admin Home</h1>
<br/>
<a href="AddLibarian.jsp">Add Libarian</a> &nbsp;&nbsp;
<a href="FetchLibarianServlet">View Libarian</a>&nbsp;&nbsp;
<a href="AdminLogoutServlet">Log Out</a>&nbsp;&nbsp;

<br/><br/><br/>
<div class="A">

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