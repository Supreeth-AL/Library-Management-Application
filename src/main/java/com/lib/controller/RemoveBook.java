package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.model.Model;

@WebServlet("/removingbook")
public class RemoveBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String borBookId = request.getParameter("removebook");
		HttpSession session = request.getSession();

		System.out.println("Removing book from borrow history...");

		try {

			Model model = new Model();
			boolean isRemoved = model.RemoveBook(borBookId);

			if (isRemoved) {
				System.out.println("Book successfully removed from borrow history.");
				response.sendRedirect(request.getContextPath() + "/success.html");
			} else {
				System.out.println("Failed to remove book from borrow history.");
				response.sendRedirect(request.getContextPath() + "/fail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}
	}
}
