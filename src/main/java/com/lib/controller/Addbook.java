package com.lib.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.model.Model;

@WebServlet("/addingbook")
public class Addbook extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookid");
		HttpSession session = request.getSession();

		System.out.println("Adding book to borrow history.");

		try {
			Model model = new Model();

			// Check if the book is already in the borrow history
			boolean isBookAlreadyInHistory = model.isBookInHistory(bookId);

			if (isBookAlreadyInHistory) {
				System.out.println("Book is already in the borrow history.");
				//session.setAttribute("message", "The book is already borrowed.");
				response.sendRedirect(request.getContextPath() + "/alreadythere.html");
				return;
			}

			// Fetch book details
			LinkedList<String> bookDetails = model.fetchBookDetails(bookId);

			if (!bookDetails.isEmpty()) {
				System.out.println("Book Details:");
				System.out.println("Book ID: " + bookDetails.get(0));
				System.out.println("Book Name: " + bookDetails.get(1));
				System.out.println("Book Author: " + bookDetails.get(2));

				// Add book to history
				boolean isAdded = model.addBookToHistory(bookDetails.get(0), bookDetails.get(1), bookDetails.get(2));

				if (isAdded) {
					System.out.println("Book successfully added to borrow history!");
					response.sendRedirect(request.getContextPath() + "/success.html");
				} else {
					System.out.println("Failed to add book to borrow history.");
					response.sendRedirect(request.getContextPath() + "/fail.html");
				}
			} else {
				System.out.println("No book found with the given Book ID.");
				response.sendRedirect(request.getContextPath() + "/fail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}
	}
}
