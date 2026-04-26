package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");

		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(pass);

		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(us);
		
		HttpSession session;
		if (f) {
			session=request.getSession();
			session.setAttribute("reg-sucess", "Registration Sucessfully");
			response.sendRedirect("register.jsp");
		} else {
			session=request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on server");
			response.sendRedirect("register.jsp");
		}
	}
}
