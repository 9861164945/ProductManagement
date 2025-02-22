package com.servlet.ProductManagement;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/clogout")
public class CustomerLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession(false); // Get session without creating a new one

        if (hs == null) {
            req.setAttribute("msg", "Logout Failed");
        } else {
            hs.removeAttribute("cbean"); // Remove user session data
            hs.invalidate(); // Invalidate session
            req.setAttribute("msg", "Customer Logout Successfully"); // Set message in request scope
        }

        req.getRequestDispatcher("CustomerLogout.jsp").forward(req, resp);
    }
}
