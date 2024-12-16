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

@WebServlet("/bookavailable")
public class BookAvailable extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
        System.out.println("bookAvailable");
        try {
        	Model m = new Model();
        	List<Model> books = m.getAllBooks();

        	if (!books.isEmpty()) {
        		System.out.println("truebook");
                session.setAttribute("books", books);
                response.sendRedirect("/LibraryManagement/BookAvailable.jsp");
            } else {
            	System.out.println("falsebook");
                response.sendRedirect("/LibraryManagement/BookAvailable.jsp");
            }

        }
        catch (Exception e) {
        	e.printStackTrace();
        	response.sendRedirect(request.getContextPath() + "/error.html");
        }
	}

}
