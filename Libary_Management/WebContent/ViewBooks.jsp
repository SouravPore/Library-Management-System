<%@ page import ="com.proj.model.BookInfo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view Books</title>
<link href="CSS/ViewBook.css" type="text/css" rel="stylesheet">
</head>
<body>
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">
<font face= "comic sans ms">
	
	<h1>All Books</h1>

    <br><br>
	<%
		if(request.getAttribute("blist")!=null)
			{
		List<BookInfo> ilist=(List<BookInfo>)request.getAttribute("blist");
		if(ilist.size()>0)
		{
	%>
			 
			<table border="1">
			<tr>
				
				<th>CALLNO</th>
				<th>NAME</th>
				<th>AUTHOR</th>
				<th>PUBLISHER</th>
				<th>QUANTITY</th>
				<th>ISSUSED</th>
				
				
			</tr>
	
	<%
	for(BookInfo bobj:ilist)
	{
		%>
			<tr>
				<td><%= bobj.getCallno() %></td>
				<td><%= bobj.getName() %></td>
				<td><%= bobj.getAuthor() %></td>
				<td><%= bobj.getPublisher() %></td>
				<td><%= bobj.getQuantity() %></td>
				<td><%= bobj.getIssued() %></td>	
				
				<td>	
				<form action="EditBookShow" method="post">
						<input type="hidden" name="callno" value="<%=bobj.getCallno()%>">
						<input type="submit" value="UPDATE"	class="btn btn-danger">					
					</form>
				</td>		
					 
				<td>
				<div class="D">	
				<form action="BookDeleteServlet" method="post">
						<input type="hidden" name="callno" value="<%=bobj.getCallno()%>">
						<input type="submit" value="DELETE"	class="btn btn-danger">					
					</form>
					</div>
				</td>		
				
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

<br/><br/>
<div align="center">
<div style="color:blue">
<%
if(request.getAttribute("smsg")!=null)
{
	out.println(request.getAttribute("smsg"));
}
%>
</div></div>


</body>
</html>