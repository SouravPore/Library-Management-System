package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.dao.DBLogic;
import com.proj.model.LibarianInfo;
 
@WebServlet("/LibarianLoginCheckServlet")
public class LibarianLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LibarianLoginCheckServlet() {
        super();
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		DBLogic daoobj=new DBLogic();
		LibarianInfo lobj=daoobj.LibarianLogin(email,password);
		if(lobj!=null)
		{
			System.out.println("VALID");
			HttpSession session=request.getSession(true);
			session.setAttribute("linfo", lobj);
			response.sendRedirect("LibarianAfterLogin.jsp");
		}
		else
		{
			System.out.println("INVALID");
			request.setAttribute("errormsg", "Invalid Email or Password");
			RequestDispatcher rd=request.getRequestDispatcher("LibarianLogin.jsp");
			rd.forward(request, response);
			
		}
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
