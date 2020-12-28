<%@page import="com.proj.model.LibarianInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libarian After Login</title>
<link href="CSS/LibAfter.css" type="text/css" rel="stylesheet">
</head>
<body>
<div align="center">
<h1>Librarian Home</h1>
</div>
<%!LibarianInfo lobj;%>
	<%
		lobj=(LibarianInfo)session.getAttribute("linfo");
	%>
	<div class="container">
		<div align="center">
		 
		<br/> 
		<h3 style="color:blue;">   Welcome   <%= lobj.getName() %></h3>
		</div>
	</div>

<div class="container">
<div align="center">

<br/><br/>
<a href="AddBook.jsp">Add Book</a> &nbsp;&nbsp;&nbsp;
<a href="IssueBook.jsp">issue Book</a>&nbsp;&nbsp;&nbsp;
<a href="FetchBookServlet">View Book</a>&nbsp;&nbsp;&nbsp;
<a href="FetchIssueBook">View Issued Book</a>&nbsp;&nbsp;&nbsp;
<a href="ReturnBook.jsp">Return Book</a>&nbsp;&nbsp;&nbsp;
<a href="ViewLibarianID">My Account</a>&nbsp;&nbsp;&nbsp;
<a href="LibarianLogoutServlet">Log Out</a>

</div>
</div>
</body>
</html>