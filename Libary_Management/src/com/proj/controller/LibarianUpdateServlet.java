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


@WebServlet("/LibarianUpdateServlet")
public class LibarianUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LibarianUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic();
		LibarianInfo lobj=new LibarianInfo();
		lobj.setEmail(request.getParameter("email"));
		lobj.setName(request.getParameter("name"));
		lobj.setPassword(request.getParameter("password"));
		lobj.setMobileno(request.getParameter("mobileno"));
		
		boolean f=daoobj.LibarianUpdate(lobj);
		if(f)
		{
			System.out.println("Libarian upadated");
			request.setAttribute("smsg", "Libarian updated successfully");
			RequestDispatcher rd=request.getRequestDispatcher("LibarianEditShow");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Not updated");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
