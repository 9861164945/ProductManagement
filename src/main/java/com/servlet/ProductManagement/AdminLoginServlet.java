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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	String un=req.getParameter("uname");
	String pw=req.getParameter("pword");
	System.out.println("Received username: " + un);
    System.out.println("Received password: " + pw);

	AdminBean ab=new AdminLoginDAO().login(un, pw);
	if(ab==null) 
	{
		 req.setAttribute("msg", "Invalid username or password...<br>");
          req.getRequestDispatcher("Msg.jsp").forward(req, resp);
	}
	else
	{
		HttpSession hs=req.getSession();//Creating new Session	but there is some issue can happen like Session Expired  like something
		hs.setAttribute("abean",ab);
		RequestDispatcher rd=req.getRequestDispatcher("AdminLoginSuccess.jsp");
		rd.forward(req, resp);
	}
	}

}
