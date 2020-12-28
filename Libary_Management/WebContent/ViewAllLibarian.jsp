<%@ page import ="com.proj.model.LibarianInfo" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/ViewAllLib.css" type="text/css" rel="stylesheet" >
</head>
<body>

<a href="AdminAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">
<font face= "comic sans ms">
	
	<h1>All Libarians</h1>

    <br><br>
	<%
		if(request.getAttribute("ilist")!=null)
			{
				List<LibarianInfo> ilist=(List<LibarianInfo>)request.getAttribute("ilist");
				if(ilist.size()>0)
					{
	%>
			 
			<table border="1">
			<tr>
				
				<th>NAME</th>
				<th>EMAIL</th>
				<th>MOBILE NO</th>
				
			</tr>
	
	<%
	for(LibarianInfo libobj:ilist)
	{
		%>
			<tr>
				<td><%= libobj.getName() %></td>
				<td><%= libobj.getEmail() %></td>
				<td><%= libobj.getMobileno() %></td>
				
				<td>	
				<form action="LibarianDeleteServlet" method="post">
						<input type="hidden" name="email" value="<%=libobj.getEmail()%>">
						<input type="submit" value="DELETE"	class="btn btn-danger">					
					</form>
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