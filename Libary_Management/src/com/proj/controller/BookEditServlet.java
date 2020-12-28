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


@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic();
		BookInfo bobj=new BookInfo();
		bobj.setCallno(request.getParameter("callno"));
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		bobj.setQuantity(quantity);
		
		boolean f=daoobj.BookUpdate(bobj);
		
		if(f)
		{
			System.out.println("Book Upadated");
			request.setAttribute("smsg", "Book updated successfuly");
			RequestDispatcher rd=request.getRequestDispatcher("EditBookShow");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Book not updated");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
