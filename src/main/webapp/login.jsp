<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="all_component/allCss.jsp"%>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@include file="all_component/Navbar.jsp"%>
	<div class="container-fluid test-bg">
		<%-- background color is not proper --%>
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user fa-3x" aria-hidden="true"></i>
						<h4>Login Page</h4>
					</div>

					<%
					String invalidMes = (String) session.getAttribute("login-failed");
					if (invalidMes != null) {
					%><div class="alert alert-danger" role="alert"><%=invalidMes%></div>
					<%
					session.removeAttribute("login-failed");
					}
					%>


					<%
					String withoutLogin = (String) session.getAttribute("Login-error");
					if (withoutLogin != null) {
					%><div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
					session.removeAttribute("Login-error");
					}
					%>


					<%
					String lgMsg = (String) session.getAttribute("logoutMeg");
					if (lgMsg != null) {
					%><div class="alert alert-success" role="alert"><%=lgMsg%></div>
					<%
					session.removeAttribute("logoutMeg");
					}
					%>



					<div class="card-body">
						<form action="loginServlet" method="post">
							<label>Enter Email Id</label>
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
								class="btn btn-primary badge-pill btn-block ">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	


</body>
</html>