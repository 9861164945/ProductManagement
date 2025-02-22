package com.servlet.ProductManagement;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogoutServlet  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	HttpSession hs=req.getSession(false);
	
	if(hs==null) 
	{
req.setAttribute("msg", "Session Expired");
req.getRequestDispatcher("msg.jsp").forward(req, resp);

		
		
	}
	else 
	{
		hs.removeAttribute("abean");
		hs.removeAttribute("alist");
		hs.setAttribute("msg","Admin Logout Successfully");
		req.getRequestDispatcher("AdminLogout.jsp").forward(req, resp);
		
	}
	}

}
