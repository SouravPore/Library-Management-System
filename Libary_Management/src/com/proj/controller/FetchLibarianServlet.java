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
import com.proj.model.LibarianInfo;

 
@WebServlet("/FetchLibarianServlet")
public class FetchLibarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public FetchLibarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBLogic daoobj=new DBLogic(); 
		
		List<LibarianInfo> liblist=daoobj.fetchLibarians();
		request.setAttribute("ilist", liblist);
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllLibarian.jsp");
		rd.forward(request, response);
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
