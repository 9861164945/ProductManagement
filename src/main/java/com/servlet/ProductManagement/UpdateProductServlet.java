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

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			req.setAttribute("msg", "Session expired. Please log in again.");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			return;
		}

		// Retrieve product list from session
		ArrayList<ProductBean> productList = (ArrayList<ProductBean>) session.getAttribute("alist");

		if (productList == null) {
			req.setAttribute("msg", "No product list found in session.");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			return;
		}


		// ✅ Validate input before parsing
		String pcodeStr = req.getParameter("pcode");
		String ppriceStr = req.getParameter("pprice");
		String pqtyStr = req.getParameter("pqty");

		if (pcodeStr == null || pcodeStr.trim().isEmpty() || 
		    ppriceStr == null || ppriceStr.trim().isEmpty() || 
		    pqtyStr == null || pqtyStr.trim().isEmpty()) {

			req.setAttribute("msg", "Invalid input. Please fill all fields.");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, resp);
			return;
		}

		try {
			int pcode = Integer.parseInt(pcodeStr.trim());
			float price = Float.parseFloat(ppriceStr.trim());
			int qty = Integer.parseInt(pqtyStr.trim());

			boolean productFound = false;
			Iterator<ProductBean> it = productList.iterator();
			
			while (it.hasNext()) {
				ProductBean product = it.next();
				if (pcode == product.getPcode()) {
					product.setPprice(price);
					product.setPqty(qty);
					productFound = true;

					// Update product in DB
					int result = new UpdateProductDao().update(product);
					if (result > 0) {
						req.setAttribute("msg", "Product Updated Successfully.");
					} else {
						req.setAttribute("msg", "Failed to update product.");
					}

					req.getRequestDispatcher("Msg.jsp").forward(req, resp);
					return;
				}
			}

			if (!productFound) {
				req.setAttribute("msg", "Product not found.");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			}

		} catch (NumberFormatException e) {
			req.setAttribute("msg", "Invalid number format. Please enter valid numbers.");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, resp);
		}
	}
}
