package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;


@WebServlet("/LibarianDeleteServlet")
public class LibarianDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LibarianDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic();
		String email=request.getParameter("email");
		boolean f=daoobj.deleteLibarian(email);
		
		if(f)
		{
			System.out.println("Libarian deleted successfully");
			request.setAttribute("smsg", "Libarian Deleted successfully");
			RequestDispatcher rd=request.getRequestDispatcher("FetchLibarianServlet");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Not deleted");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
