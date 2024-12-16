package com.lib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.model.Model;

@WebServlet("/addstaff")
public class AddStaffDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addstaffid = request.getParameter("addstaffid");
		String addstaffname = request.getParameter("addstaffname");
		String addstaffemail = request.getParameter("addstaffemail");
		String addstaffaddress = request.getParameter("addstaffaddress");
		String addstaffphoneno = request.getParameter("addstaffphoneno");
		System.out.println("addstaffdetails");
		try {
			Model m = new Model();
			m.setStaffid(addstaffid);
			m.setSname(addstaffname);
			m.setSemail(addstaffemail);
			m.setSaddress(addstaffaddress);
			m.setSphoneno(addstaffphoneno);

			boolean b = m.AddStaffDetails();
			if(b) {
				System.out.println("staff details added");
				response.sendRedirect(request.getContextPath() + "/staffdetailsadded.html");
			}
			else {
				System.out.println("staff details not added");
				response.sendRedirect(request.getContextPath() + "/staffdetailsnotadded.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.html");
		}
	}

}
