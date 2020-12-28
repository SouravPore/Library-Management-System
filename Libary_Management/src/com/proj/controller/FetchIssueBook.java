package com.proj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj.dao.DBLogic;
import com.proj.model.IssusedBookInfo;
 
@WebServlet("/FetchIssueBook")
public class FetchIssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchIssueBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic();
		List<IssusedBookInfo> ibobj=daoobj.fetchIssusedBook();
		
		request.setAttribute("iblist", ibobj);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewIssueBook.jsp");
		rd.forward(request, response);	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
