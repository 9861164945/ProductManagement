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
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            req.setAttribute("msg", "Session expired. Please log in again.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        String pcodeStr = req.getParameter("pcode");
        ArrayList<ProductBean>productlist=(ArrayList<ProductBean>)session.getAttribute("alist");
        
        if(productlist==null) 
        {
        	req.setAttribute("msg","No product list found insession");
        	req.getRequestDispatcher("Msg.jsp").forward(req, resp);
        	return;
        	
        }

        if (pcodeStr == null || pcodeStr.isEmpty()) {
            req.setAttribute("msg", "Invalid request. Product Code is missing.");
            req.getRequestDispatcher("viewallproducts.jsp").forward(req, resp);
            return;
        }

        try {
            int pcode = Integer.parseInt(pcodeStr);

            // Call DAO to delete the product
            Iterator<ProductBean>it=productlist.iterator();
            while(it.hasNext()) 
            {
            	ProductBean product=it.next();
            	if(pcode==product.getPcode()) 
            	{
            		int result=new DeleteProductDao().delete(product);
            		if(result>0) 
            		{
            			req.setAttribute("msg","product Dleted Successfully");
            			
            		}
            		else {
            			req.setAttribute("msg", "Unable to delete ");
            		}
            	}
            	
            }
        } catch (NumberFormatException e)
        {
            req.setAttribute("msg", "Invalid Product Code. Enter a valid number.");
        }

        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, resp);
    }
}
