package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.model.Model;

public class Registration extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneno = request.getParameter("phoneno");
		String password = request.getParameter("password");
		System.out.println("registration.java");
		try {
			Model m= new Model();
			m.setName(name);
			m.setUserid(userid);
			m.setEmail(email);
			m.setPhoneno(phoneno);
			m.setPassword(password);
			boolean b = m.Registration();
			if(b) {
				response.sendRedirect("/LibraryManagement/Destop.html");
			}
			else {
				response.sendRedirect("/LibraryManagement/fail.com");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}

	}

}
