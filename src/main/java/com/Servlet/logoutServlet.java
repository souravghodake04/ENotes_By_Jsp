package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("userD");
			
			HttpSession session2 = request.getSession();
			session2.setAttribute("logoutMeg", "Logout Sucessfully...");
			response.sendRedirect("login.jsp");
			
			/*HttpSession session = request.getSession();
			session.removeAttribute("userD");
			session.setAttribute("logoutMeg", "Logout Successfully...");
			response.sendRedirect("login.jsp");*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
