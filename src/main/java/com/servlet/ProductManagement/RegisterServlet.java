package com.servlet.ProductManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oracle.jdbc.proxy.annotation.Pre;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
			String uname=req.getParameter("uanme");
			String email=req.getParameter("email");
			String pword=req.getParameter("email");
			String city=req.getParameter("pword");
			String fname=req.getParameter("fname");
			Long phno=Long.parseLong(req.getParameter("phno"));
			Connection con=DbConnection.getCon();
			String query="Insert Into Admin79 values(?,?,?,?,?,?)";
		try 
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, pword);
			ps.setString(4, city);
			ps.setString(5, fname);
			ps.setLong(6, phno);
			int k=ps.executeUpdate();
			if(k>0) 
			{
				resp.sendRedirect("");
				
			}
			else
			{
				resp.getWriter().println("Registration Failed Due to some Issue ");
				
			}
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	
}
