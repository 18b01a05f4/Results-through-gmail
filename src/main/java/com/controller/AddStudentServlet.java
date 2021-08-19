package com.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.StudentDAO;
import com.model.StudentDTO;



@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String RegNumber = request.getParameter("regnumber");
		String mailId = request.getParameter("mail");
		
		HttpSession session = request.getSession();
		session.setAttribute("RegistrationNumber",RegNumber);
		session.setAttribute("gmail",mailId);
		
		
		StudentDTO studentdto = new StudentDTO(RegNumber,mailId);
		StudentDAO studentdao = new StudentDAO();
		int result = studentdao.insertStudent(studentdto);
		
		if(result > 0) {	
			out.println("<h1>Successfully added!!</h1><br><h1>Thank you....</h1><br>");
		}
		else out.println("<h1>Error</h1>");
		
	}

}
