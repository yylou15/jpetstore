package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    private static String MY_ORDER ="/WEB-INF/jsp/order/ListOrders.jsp";
    Order order=new Order();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        order=(Order)session.getAttribute("order");

        request.getRequestDispatcher(MY_ORDER).forward(request,response);
    }
}
