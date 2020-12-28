<%@ page import ="com.proj.model.LibarianInfo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Your Account</title>
<link href="CSS/LibEdit.css" type="text/css" rel="stylesheet">

</head>
<body>
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">
<h1>Update Your Details</h1>
<br/>
<form action="LibarianUpdateServlet" method="post">

<fieldset style="width:300px">

<%
if(request.getAttribute("lib")!=null)
{
	LibarianInfo lobj=(LibarianInfo)request.getAttribute("lib");
%>

<br/>
<label for="name">Name : </label>
<input type="text" id="name" name="name" required="required" value='<%=lobj.getName()%>'/>
<br/><br/>
<label for="email">Email ID : </label>
<input type="email" name="email" id="email" required="required" value='<%=lobj.getEmail()%>'/>
<br/><br/>
<label for="password">Password : </label>
<input type="password" id="password" name="password" required="required" value='<%=lobj.getPassword()%>'/>
<br/><br/>
<label for="mobileno">Mobile No :  </label>
<input type="number" id="mobileno" name="mobileno" required="required" value='<%=lobj.getMobileno()%>'/>
<br/><br/>
</fieldset>
<br/>
<input type="submit" value="UPDATE"/>
</form>
<%
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