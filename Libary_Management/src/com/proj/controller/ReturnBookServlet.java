package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;


@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReturnBookServlet() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		
		DBLogic daoobj=new DBLogic();
		int i=daoobj.returnBook(callno, studentid);
		if(i>0)
		{
			System.out.println("Book returned");
			request.setAttribute("successmsg", "Book returned successfuly");
			RequestDispatcher rd=request.getRequestDispatcher("ReturnBook.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Not returned");
			request.setAttribute("errormsg", "Invalid Callno or Student ID");
			RequestDispatcher rd=request.getRequestDispatcher("ReturnBook.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
