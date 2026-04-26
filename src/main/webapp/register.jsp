<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/Navbar.jsp"%>
	<div class="container-fluid test-bg">
		<%-- background color is not proper --%>
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>


					<%
					String regmes = (String) session.getAttribute("reg-sucess");
					if (regmes != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regmes%> Login<a
							href="login.jsp"> Cilck Here</a>
					</div>
					<%
					session.removeAttribute("reg-sucess");
					}
					%>

					<%
					String FailMsg = (String) session.getAttribute("failed-msg");
					if (regmes != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=FailMsg%></div>
					<%
					session.removeAttribute("failed-msg");
					}
					%>


					<div class="card-body">
						<form action="UserServlet" method="post">
							<label>Enter Full Name</label>
							<div class="mb-2">
								<input type="text" class="form-control" name="fname">

							</div>
							<label>Enter Email</label>
							<div class="mb-2">
								<input type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label ">Enter
									Password</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="upass">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block ">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>