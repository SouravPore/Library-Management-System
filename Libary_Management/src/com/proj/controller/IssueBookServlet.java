package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;
import com.proj.model.IssusedBookInfo;

 
@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IssueBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		String studentname=request.getParameter("studentname");
		String sstudentmobile=request.getParameter("studentphno");
		long studentphno=Long.parseLong(sstudentmobile);
		
		DBLogic daobj=new DBLogic();
		
		IssusedBookInfo ibobj=new IssusedBookInfo(callno,studentid,studentname,studentphno);
		int i=daobj.issueBook(ibobj);
		if(i>0){
			System.out.println("Book Issused");
			request.setAttribute("successmsg", "Book issused successfully");
			RequestDispatcher rd=request.getRequestDispatcher("IssueBook.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Not Issused");
			request.setAttribute("errormsg", "This Book is NOT available right now");
			RequestDispatcher rd=request.getRequestDispatcher("IssueBook.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
