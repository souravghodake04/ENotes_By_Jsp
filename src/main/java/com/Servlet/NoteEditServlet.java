package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;

import com.db.DBConnect;
import com.DAO.*;
@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");
			String dateStr = request.getParameter("pdate");

			Timestamp pdate = null;

			if (dateStr != null && !dateStr.isEmpty()) {
			    dateStr = dateStr.replace("T", " ") + ":00";
			    pdate = Timestamp.valueOf(dateStr);
			}
			PostDAO dao = new PostDAO(DBConnect.getConn());
			boolean f=dao.PostUpdate(noteid, Title, Content);
			
			if (f) {
				System.out.println("DATA UPDATED");
				
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg","Notes Update Sucessfully");
				response.sendRedirect("showNotes.jsp");
				
				
			} else {
				System.err.println("Not " );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
