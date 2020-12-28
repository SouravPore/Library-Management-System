package com.proj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proj.model.LibarianInfo;


@WebServlet("/ViewLibarianID")
public class ViewLibarianID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewLibarianID() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		LibarianInfo lobj=(LibarianInfo)session.getAttribute("linfo");
		request.setAttribute("lib", lobj);
		RequestDispatcher rd=request.getRequestDispatcher("LibarianAccount.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
