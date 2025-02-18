package com.servlet.ProductManagement;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String uname=req.getParameter("uname");
	String pword=req.getParameter("pword");
	AdminBean ab=new AdminLoginDAO().login(uname, pword);
	if(ab==null) 
	{
		
	}
	else
	{
		HttpSession hs=req.getSession();//Creating new Session	
		hs.setAttribute("abean",ab);
		RequestDispatcher rd=req.getRequestDispatcher("AdminLoginSuccess.jsp");
		rd.forward(req, resp);
	}
	}

}
