package org.csu.mypetstore.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "NewOrderFormServlet")
public class NewOrderFormServlet extends HttpServlet {
    private static final String CONFIRM_ORDER="/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPING_FORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String different=request.getParameter("shippingAddressRequired");
        if(different == null)
        {
            request.getRequestDispatcher(SHIPPING_FORM).forward(request,response);
        }
        else
        {
            request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
        }
    }
}
