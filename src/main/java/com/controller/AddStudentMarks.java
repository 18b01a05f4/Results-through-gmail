package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudentDAO;
import com.model.StudentDTO;
import com.model.StudentMarkDTO;

@WebServlet("/AddStudentMarks")
public class AddStudentMarks extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String RegNumber = request.getParameter("regnum");
		int dwdm = Integer.parseInt(request.getParameter("dwdm"));
		int infosec = Integer.parseInt(request.getParameter("infosec"));
		int wt = Integer.parseInt(request.getParameter("wt"));
		int cc = Integer.parseInt(request.getParameter("cc"));
		int ajp = Integer.parseInt(request.getParameter("ajp"));
		int ecom = Integer.parseInt(request.getParameter("ecom"));
		
		
		HttpSession session = request.getSession();
		session.setAttribute("RegistrationNumber",RegNumber);
		session.setAttribute("dwdm",dwdm);
		session.setAttribute("infosec",infosec);
		session.setAttribute("wt",wt);
		session.setAttribute("cc",cc);
		session.setAttribute("ajp",ajp);
		session.setAttribute("ecom",ecom);
		
		
		StudentMarkDTO studentmarkdto = new StudentMarkDTO();
		StudentDAO studentdao = new StudentDAO();
		int result = studentdao.insertStudentMarks(studentmarkdto);
		
		if(result > 0) {	
			out.println("<h1>Successfully added!!</h1><br><h1>Thank you....</h1><br>");
		}
		else out.println("<h1>Error</h1>");
		
	}

}
