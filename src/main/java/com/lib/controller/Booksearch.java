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

@WebServlet("/booksearch")
public class Booksearch extends HttpServlet {
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bsearch = request.getParameter("bsearch");
        HttpSession session = request.getSession(true);
        System.out.println("booksearch1.java");
        try {
            Model m = new Model();
            List<Model> b = m.Booksearch(bsearch, bsearch); // Pass the same parameter for both bname and author
            if (!b.isEmpty()) {
                System.out.println("booksearch2.java");
                session.setAttribute("bsearch", b);
                response.sendRedirect(request.getContextPath() + "/BookSearched.jsp");
            } else {
                System.out.println("booksearch3.java");
                response.sendRedirect(request.getContextPath() + "/BookSearched.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
