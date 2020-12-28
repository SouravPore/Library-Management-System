<%@ page import ="com.proj.model.LibarianInfo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Account</title>
<link href="CSS/LibAcc.css" type="text/css" rel="stylesheet">

</head>
<body>
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">

<h1>Librarian Account</h1>

<%
if(request.getAttribute("lib")!=null)
{
	LibarianInfo lobj=(LibarianInfo)request.getAttribute("lib");
%>

	<table border="2">
	<tr>
		<th>NAME</th>
		<th>EMAIL ID</th>
		<th>PASSWORD</th>
		<th>MOBILE NO</th>
	</tr>
	
	<%
	
	%>
	<tr>
		<td><%=lobj.getName() %></td>
		<td><%=lobj.getEmail() %></td>
		<td><%=lobj.getPassword() %></td>
		<td><%=lobj.getMobileno() %></td>
		
		<td>
				 <form action="LibarianEditShow" method="post">
					
						<input type="hidden" name="email" value="<%=lobj.getEmail()%>">
						<input type="submit" value="EDIT"	class="btn btn-danger">	
						</form>	
				</td>	
		
	</tr>
	
	</table>
<%
}
%>

</div></div>
</body>
</html>