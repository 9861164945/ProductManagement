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
@WebServlet("/customer")
public class CustomerLoginServlet  extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String cuname=req.getParameter("cuname");
		 String cpword=req.getParameter("cpword");
		 System.out.println("Received Username"+cuname);
		 System.out.println("received password"+cpword);
		 CustomerBean cb=new CustomerLoginDao().login(cuname, cpword);
		 if(cb==null) 
		 {
			 req.setAttribute("msg","Invalid username or password");
			 req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			 
		 }
		 else
		 {
			 HttpSession hs=req.getSession();
			 hs.setAttribute("cbean", cb);
			 RequestDispatcher rd=req.getRequestDispatcher("CustomerLoginSuccess.jsp");
			 rd.forward(req, resp);
			 
			 
		 }
		
		
	}
}
