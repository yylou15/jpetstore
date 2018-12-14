package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    private static String MY_ORDER ="/WEB-INF/jsp/order/ListOrders.jsp";
    private String userId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        OrderService orderService=new OrderService();
        userId=request.getParameter("userId");
        List<Order> orderList=orderService.getOrdersByUsername(userId);

        session.setAttribute("orderList",orderList);
        request.getRequestDispatcher(MY_ORDER).forward(request,response);
    }
}

