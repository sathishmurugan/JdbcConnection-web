package com.sathish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathish.dao.StudentDAO;
import com.sathish.model.Student;
@WebServlet("/Studentservlet")
public class Studentservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		PrintWriter out=response.getWriter();
		out.print(name);
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		StudentDAO dao=new StudentDAO();
		dao.save(student);
		response.sendRedirect("sucess.jsp");
	}

}
