package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.model.Model;

@WebServlet("/addbooklibrary")
public class AddBookLibrary extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lbookId = request.getParameter("lbookid");
		String lbookname = request.getParameter("lbookname");
		String lbookAuthor = request.getParameter("lbookauthor");
		String lbookCopies = request.getParameter("lbookcopies");
		System.out.println("inserting book into library");
		try {
			Model m = new Model();
			m.setBookid(lbookId);
			m.setBname(lbookname);
			m.setAuthor(lbookAuthor);
			m.setCopies(lbookCopies);
			boolean b = m.AddBookLibrary();

			if(b) {
				System.out.println("the book is insertated in library");
				response.sendRedirect(request.getContextPath() + "/bookinsertated.html");
			}
			else {
				System.out.println("the book is not insertated in library");
				response.sendRedirect(request.getContextPath() + "/booknotinsertated.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}


	}

}
