<%@ page import ="com.proj.model.IssusedBookInfo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issused books</title>
<link href="CSS/IssusedBook.css" type="text/css" rel="stylesheet">

</head>
<body>
	
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">
<h1>All Issused Books</h1>
<div class="A">
<font face= "comic sans ms">
	

 
    <br><br>
    
	<%
		if(request.getAttribute("iblist")!=null)
			{
		List<IssusedBookInfo> ilist=(List<IssusedBookInfo>)request.getAttribute("iblist");
		if(ilist.size()>0)
		{
	%>
			
			<table border="2">
			<tr>
				
				<th>CALLNO</th>
				<th>STUDENT ID</th>
				<th>STUDENT NAME</th>
				<th>STUDENT PHN NO</th>
				<th>ISSUE DATE</th>
				<th>RETURN STATUS</th>
				
				
			</tr>
	
	<%
	for(IssusedBookInfo ibobj:ilist)
	{
		%>
			<tr>
				<td><%= ibobj.getCallno() %></td>
				<td><%= ibobj.getStudentid() %></td>
				<td><%= ibobj.getStudentname() %></td>
				<td><%= ibobj.getStudentphno() %></td>
				<td><%= ibobj.getIssueddate() %></td>
				<td><%= ibobj.getReturnstatus() %></td>
				
				
				
		</tr>
	<% 			
			}
	%>
		</table>
		
	<% 
		    }
			else
			{
	%>
			<h2 style="color: red;">NO RECORD FOUND</h2>
	<%
			}
		}
	%>
	</font>
	</div>
</div>	
</div>

</body>
</html>