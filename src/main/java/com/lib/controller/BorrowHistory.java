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

@WebServlet("/seeallbook")
public class BorrowHistory extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        System.out.println("Handling borrow history request...");
        try {
            Model m = new Model();
            List<Model> borrowhistorys = m.BorrowHistory();

            if (!borrowhistorys.isEmpty()) {
                System.out.println("Borrow history found.");
                session.setAttribute("borrowhistorys", borrowhistorys);
                response.sendRedirect(request.getContextPath() + "/borrowhistroy.jsp");
            } else {
                System.out.println("No borrow history found.");
                response.sendRedirect(request.getContextPath() + "/borrowhistroy.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
