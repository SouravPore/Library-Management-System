<%@ page import ="com.proj.model.BookInfo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Edit</title>
<link href="CSS/BookEdit.css" type="text/css" rel="stylesheet">

</head>

<a href="FetchBookServlet">Back</a>
<body>
<div class="container">
<div align="center">
<h1>Edit Book</h1>
<%
if(request.getAttribute("blist")!=null)
{
	List<BookInfo> ilist=(List<BookInfo>)request.getAttribute("blist");
	for(BookInfo bobj:ilist)
	{
		%>
		<form action="BookEditServlet" method="post">
		<fieldset style="width:300px">
		<div align="center">
		
		<label for="callno">Callno : </label><%= bobj.getQuantity() %>
		<br/><br/>
		<label for="name">Name : </label><%= bobj.getName() %>
		<br/><br/>
		<label for="quantity">Quantity :</label>
		<input type="number" id="quantity" name="quantity" value='<%= bobj.getQuantity() %>'/>
		<br/><br/>
		</div>
		</fieldset>
		<br/><br/>
		<input type="hidden" name="callno" value="<%=bobj.getCallno()%>">
						<input type="submit" value="UPDATE"	class="btn btn-danger">	
					
					</form>	
<% 	
	}
}
%>

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