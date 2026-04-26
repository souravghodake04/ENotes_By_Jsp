package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.db.DBConnect;
import com.DAO.*;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer noteid = Integer.parseInt(request.getParameter("note_id"));
		PostDAO dao = new PostDAO(DBConnect.getConn());
		HttpSession session = null;
		boolean f = dao.DeleteNotes(noteid);
		if (f) {
			session = request.getSession();
			session.setAttribute("updateMsg", "Notes Deleted Sucessfully");
			response.sendRedirect("showNotes.jsp");
		} else {
			session.setAttribute("wrongMsg", "Wrong Message");
			response.sendRedirect("showNotes.jsp");
		}
	}

}
