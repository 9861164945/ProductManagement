package com.servlet.ProductManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductServlet  extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			
		}
		else
		{
			ArrayList<ProductBean>al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			String pc=req.getParameter("pcode");
			Iterator<ProductBean>it=al.iterator();
			while(it.hasNext()) 
			{
				ProductBean pb=(ProductBean)it.next();
				if(pc.equals(pb.getCode()))
				{
					req.setAttribute("pbean", pb);
					req.getRequestDispatcher("EditProduct.jsp").forward(req, resp);
					break;
					
				}
				
				
			}
			
		}
	
	}
	

}
