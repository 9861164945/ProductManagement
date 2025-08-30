package com.servlet.ProductManagement;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();

        CustomerBean cb = new CustomerBean();
        cb.setCfname(req.getParameter("cfname"));
        cb.setClname(req.getParameter("clname"));
        cb.setCemail(req.getParameter("cemail"));
        cb.setCphno(Long.parseLong(req.getParameter("cphno")));
        cb.setAddress(req.getParameter("address"));
        cb.setCpword(req.getParameter("cpword"));
        cb.setCuname(req.getParameter("cuname"));

        ResgisterDao dao = new ResgisterDao();
        int result = dao.insert(cb);

        if (result > 0) 
        {
            session.setAttribute("cbean", cb);
            req.setAttribute("msg", "Registration Successful!");
            req.getRequestDispatcher("CustomerRegisterSuccess.jsp").forward(req, resp);
        } else 
        {
            req.setAttribute("msg", "Registration Failed due to something went Worng!");
            req.getRequestDispatcher("Msg.jsp").forward(req, resp);
        }
    }
}
