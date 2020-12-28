package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;
import com.proj.model.BookInfo;

@WebServlet("/BookSaveServlet")
public class BookSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		
		BookInfo bobj=new BookInfo(callno,name,author,publisher,quantity);
		DBLogic daoobj=new DBLogic();
		boolean f=daoobj.SaveBook(bobj);
		
		if(f)
		{
			System.out.println("Book Inserted");
			request.setAttribute("successmsg", "Book Saved successfully");
			RequestDispatcher rd=request.getRequestDispatcher("AddBook.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Book Not Inserted");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
