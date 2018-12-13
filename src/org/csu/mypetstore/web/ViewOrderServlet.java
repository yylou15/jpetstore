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
//        order=(Order)session.getAttribute("order");
//        order.setOrderId(Integer.parseInt(request.getParameter("orderId")));
//        order.setUsername(request.getParameter("username"));
//        try {
//            Date date = sdf.parse(request.getParameter("orderDate"));
//            order.setOrderDate(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        order.setShipAddress1(request.getParameter("shipAddress1"));
//        order.setShipAddress2(request.getParameter("shipAddress2"));
//        order.setShipCity(request.getParameter("shipCity"));
//        order.setShipState(request.getParameter("shipState"));
//        order.setShipZip(request.getParameter("shipZip"));
//        order.setShipCountry(request.getParameter("shipCountry"));
//        order.setBillAddress1(request.getParameter("billAddress1"));
//        order.setBillAddress2(request.getParameter("billAddress2"));
//        order.setBillCity(request.getParameter("billCity"));
//        order.setBillState(request.getParameter("billState"));
//        order.setBillZip(request.getParameter("billZip"));
//        order.setBillCountry(request.getParameter("billCountry"));
//        order.setCourier(request.getParameter("courier"));
//        BigDecimal a=new BigDecimal(request.getParameter("totalPrice"));
//        order.setTotalPrice(a);
//        order.setBillToFirstName(request.getParameter("billToFirstName"));
//        order.setBillToLastName(request.getParameter("billToLastName"));
//        order.setShipToFirstName(request.getParameter("shipToFirstName"));
//        order.setShipToLastName(request.getParameter("shipToLastName"));
//        order.setCreditCard(request.getParameter("creditCard"));
//        try {
//            Date date1 = sdf.parse(request.getParameter("exprDate"));
//            order.setOrderDate(date1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        order.setCardType(request.getParameter("cardType"));
//        order.setLocale(request.getParameter("locale"));
//        orderService.insertOrder(order);
//        session.setAttribute("order",order);

        order=(Order)session.getAttribute("order");
        orderService.insertOrder(order);
        session.setAttribute("order",order);
        request.getRequestDispatcher(ViewOrder).forward(request,response);
    }
}
