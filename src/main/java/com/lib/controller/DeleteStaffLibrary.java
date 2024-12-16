package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.model.Model;

@WebServlet("/removeStafflibrary")
public class DeleteStaffLibrary extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lstaffid = request.getParameter("removestaffid");
		System.out.println("deleting the staff");

		try {
			Model m = new Model();
			m.setStaffid(lstaffid);
			boolean b = m.DeleteStaffLibrary();

			if(b) {
				System.out.println("staff details is delete");
				response.sendRedirect(request.getContextPath() + "/staffdeletated.html");
			}
			else {
				System.out.println("Staff details is not deletated");
				response.sendRedirect(request.getContextPath() + "/staffnotdeletated.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() +"/error.html");
		}
	}

}
