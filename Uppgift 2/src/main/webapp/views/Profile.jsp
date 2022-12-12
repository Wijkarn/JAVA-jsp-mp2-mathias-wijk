<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<%
	
	//user.getUser(username);
	if(session.getAttribute("isLoggedIn") != null){
		Bean user = (Bean) session.getAttribute("isLoggedIn");
		out.print("<h1 class=\"center\">Welcome " + user.getUser() + "</h1>");
		out.print("<form action=\"" + request.getContextPath() + "/RemoveSessionServlet\" method=\"POST\">");
		out.print("<input type=\"submit\" value=\"Log out\"/>");
		out.print("</form>");
	}
	else{
		response.sendRedirect("index.jsp");
	}
	/*request.getParameter("username")*/
	%>
</body>
</html>