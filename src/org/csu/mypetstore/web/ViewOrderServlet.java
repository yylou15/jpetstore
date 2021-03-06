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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
    private static final String  ViewOrder = "/WEB-INF/jsp/order/ViewOrder.jsp";
    Order order=new Order();
    OrderService orderService=new OrderService();
    private String orderId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        order=(Order)session.getAttribute("order");
        orderService.insertOrder(order);
        session.setAttribute("order",order);
        request.getRequestDispatcher(ViewOrder).forward(request,response);
    }
}
