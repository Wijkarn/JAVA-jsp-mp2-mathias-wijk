<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<%
		if(session.getAttribute("isLoggedIn") != null){
			response.sendRedirect("views/Profile.jsp");
		}
	%>
	<form action="<%=request.getContextPath()%>/SessionServlet" method="POST">
	<p>Username:</p>
	<input type="text" name="username" required/>
	<p>Password:</p>
	<input type="password" name="password" required/><br>
	<input type="submit" value="Login"/>
	</form>
</body>
</html>