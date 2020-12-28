package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;
import com.proj.model.LibarianInfo;

 
@WebServlet("/AddLibarianServlet")
public class AddLibarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddLibarianServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		LibarianInfo lobj=new LibarianInfo();
		lobj.setName(request.getParameter("name"));
		lobj.setEmail(request.getParameter("email"));
		lobj.setPassword(request.getParameter("password"));
		lobj.setMobileno(request.getParameter("mobileno"));
		
		DBLogic daoobj=new DBLogic();
		boolean f=daoobj.LibarianInfoStoreInDB(lobj);
		
		if(f)
		{
			request.setAttribute("successmsg", "Libarian Added");
			System.out.println("Record Inserted");
			RequestDispatcher rd=request.getRequestDispatcher("AddLibarian.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Record not Inserted");
		}
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
