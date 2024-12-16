package com.lib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.model.Model;

@WebServlet("/staffdeatails")
public class StaffDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("StaffAvailable");
		try {
			Model m = new Model();
			List<Model> staffs = m.getAllstaffs();

			if (!staffs.isEmpty()) {
				System.out.println("trueStaff");
				session.setAttribute("staffs", staffs);
				response.sendRedirect("/LibraryManagement/StaffAvailable.jsp");
			} else {
				System.out.println("falseStaff");
				response.sendRedirect("/LibraryManagement/StaffAvailable.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}
	}
}
