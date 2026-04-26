<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please login...");
}
%>
<%@ page import="com.DAO.PostDAO"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="java.util.List"%>
<%@ page import="com.User.Post"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/Navbar.jsp"%>
	<%
	String updMes = (String) session.getAttribute("updateMsg");
	if (updMes != null) {
	%>
	<div class="alert alert-success" role="alert"><%=updMes%></div>
	<%
	session.removeAttribute("updateMsg");
	}
	%>
	<h1 class="text-center">All Notes</h1>


	<%
	String wrgmsg = (String) session.getAttribute("wrongMsg");
	if (wrgmsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=wrgmsg%></div>
	<%
	session.removeAttribute("wrongMsg");
	}
	%>

	<div class="container">
		<div class="col-md-12">

			<%
			if (user3 != null) {
				PostDAO ob = new PostDAO(DBConnect.getConn());
				List<Post> post = ob.getData(user3.getId());

				for (Post po : post) {
			%>
			<div class="card mt-3">
				<img src="img/Pen_Paper.png" class="card-img-top mt-2 mx-auto"
					style="max-width: 100px">
				<div class="card-body p-4">




					<h5 class="card-title"><%=po.getTitle()%></h5>
					<p><%=po.getContent()%>.
					</p>

					<p>
						<b class="text-sucess">Published By: <%=user3.getName()%></b> </br> <b
							class="text-sucess"></b>
					</p>

					<p>
					
						<b class="text-sucess">Published Date: <%=po.getPdate()%>
						</b> </br> <b class="text-primary"></b>

						<%-- <input type="datetime-local" name="pdate"
							value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(po.getPdate())%>"> --%>
					</p>
					<div class="container text-center mt-2">
						<a href="deleteServlet?note_id=<%=po.getId()%>"
							class="btn btn-danger">Delete</a> <a
							href="edit.jsp?note_id=<%=po.getId()%>" class="btn btn-primary">Edit</a>

					</div>

				</div>
			</div>
			<%
			}
			}
			%>

		</div>
	</div>
</body>
</html>