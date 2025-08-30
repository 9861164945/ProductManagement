package com.servlet.ProductManagement;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet  extends HttpServlet
{ @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{

	HttpSession hs=req.getSession();//accessing Existing Session

	if(hs==null) 
	{
		req.setAttribute("msg","Session Expired...<br>");
		req.getRequestDispatcher("msg.jsp").forward(req, resp);
		
	}
	else
	{
		ProductBean pb=new ProductBean();//Bean created
		pb.setPcode(Integer.parseInt(req.getParameter("pcode")));
		pb.setPname(req.getParameter("pname"));
		pb.setPprice( Float.parseFloat(req.getParameter("pprice")));
		pb.setPqty(Integer.parseInt(req.getParameter("pqty")));
		
		int k= new AddProductDAO().insert(pb);
		if(k>0) 
		{
			req.setAttribute("msg","Product Added Successfully");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Product Added Failed");
			System.err.println("Something Went Wrong While Insertion");
		}

	
	}
}
	

}
