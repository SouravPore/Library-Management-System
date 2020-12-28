package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;


@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic();
		String callno=request.getParameter("callno");
		
		boolean f=daoobj.deleteBook(callno);
		if(f)
		{
			System.out.println("Book Deleted");
			request.setAttribute("smsg", "Book Deleted successfully");
			RequestDispatcher rd=request.getRequestDispatcher("FetchBookServlet");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Book not deleted");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
