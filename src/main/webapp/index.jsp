<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
.back-img {
	background: url("img/Pen_book_1.jpg");
	min-height: 100vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="all_component/allCss.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.db.DBConnect"%>
</head>
<body>
	<%@include file="all_component/Navbar.jsp"%>

	<%
	Connection con = DBConnect.getConn(); 
	System.out.println(con);
	%>


	<div class="container-fluid back-img ">
		<div class="text-center">
			<h1 class="text-white">
				<i class="fa fa-book" aria-hidden="true"></i>EduNotes: Smarter Way
				to Learn"
			</h1>
			<a href="login.jsp" class="btn btn-light"><i
				class="fa fa-sign-in" aria-hidden="true"></i>Login</a> <a
				href="register.jsp" class="btn btn-light"><i
				class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
		</div>
	</div>
	<div class="container-fluide bg-dark">
<p class="text-center text-white">“© 2026 E-Notes. All rights reserved.”<br>
“E-Notes – Your Digital Learning Companion.”</p>
</div>
	</div>
</body>
</html>