<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDetails user2 = (UserDetails) session.getAttribute("userD");
if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please login...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>


	<%@include file="all_component/Navbar.jsp"%>
	
	<div class="container-fluid ">

		<div class="card py-4">
			<div class="card-body text-center">
				<img src="img/Pen_Paper.png" class="img-fluid mx-auto"
					style="width: 300px">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary ">Start
					Here</a>
			</div>
		</div>
	</div>
</body>
</html>