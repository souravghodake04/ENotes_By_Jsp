package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");

		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPassword(pass);

		UserDAO dao = new UserDAO(DBConnect.getConn());
		UserDetails user = dao.loginUser(us);

		if (user!=null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "Invalid UserName and Password");
			response.sendRedirect("login.jsp");
		}
	}

}
