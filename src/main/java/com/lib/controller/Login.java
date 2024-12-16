package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.model.Model;

@WebServlet("/login")
public class Login extends HttpServlet {
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		session = request.getSession(true);
		System.out.println("login.java");
		try{
			Model m = new Model();
			m.setUserid(userid);
			m.setPassword(password);
			boolean b = m.Login();
			if(b) {
				response.sendRedirect("/LibraryManagement/Destop.html");
			}
			else {
				response.sendRedirect("/LibraryManagement/fail.html");
			}

		}
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}

	}

}
