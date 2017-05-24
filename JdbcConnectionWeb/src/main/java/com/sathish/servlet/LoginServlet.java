package com.sathish.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathish.util.ConnectionUtil;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String sql="select * from data where email='"+email+"' and password='"+password+"'";
		try {
			Connection con=ConnectionUtil.getConnection();
			  PreparedStatement pst = con.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();
		        while(rs.next())
		        {
		        	String emailId=rs.getString("email");
		        	String Passwords=rs.getString("password");
		        	if(email.equals(emailId) && password.equals(Passwords))
		        	{
		        		response.sendRedirect("newfile.jsp");
		        	}
		        	else
		        	{
		        		response.sendRedirect("fail.jsp");
		        	}
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(email);
	}

}
