<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link href="CSS/Addbook.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="LibarianAfterLogin.jsp">Back</a>
<div class="container">
<div align="center">

<h1>Add Book</h1>

<form action="BookSaveServlet" method="post">

<fieldset style="width:300px">
<br/>
<label for ="callno">Callno : </label>
<input type="text" id="callno" name="callno" required="required"/>
<br/><br/>
<label for="name">Name : </label>
<input type="text" id="name" name="name" required="required"/>
<br/><br/>
<label for="author">Author : </label>
<input type="text" id="author" name="author" required="required"/>
<br/><br/>
<label for="publisher">Publisher : </label>
<input type="text" id="publisher" name="publisher" required="required"/>
<br/><br/>
<label for="quantity">Quantity : </label>
<input type="number" id="quantity" name="quantity" required="required"/>
<br/><br/>

</fieldset>
<br/>
<input type="submit" value="SAVE">

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


</body>
</html>