package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.model.Model;

@WebServlet("/deletebooklibrary")
public class DeleteBookLibrary extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lbookid = request.getParameter("deletebookid");
		System.out.println("delete book from library");

		try {
			Model m = new Model();
			m.setBookid(lbookid);
			boolean b = m.DeleteBookLibrary();
			if(b) {
				System.out.println("book deletated");
				response.sendRedirect(request.getContextPath() + "/bookdeletated.html");
			}
			else {
				System.out.println("book not deletated");
				response.sendRedirect(request.getContextPath() + "/booknotdeletated.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "error.html");
		}
	}

}
