package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String adminid=request.getParameter("adminid");
		String adminpass=request.getParameter("adminpass");
		
		if(adminid.equals("admin") && adminpass.equals("admin"))
		{
			System.out.println("VALID");
			request.setAttribute("successmsg", "Welcome Admin");
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminAfterLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("INVALID");
			request.setAttribute("errormsg", "Invaliv id or password");
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
		}
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
