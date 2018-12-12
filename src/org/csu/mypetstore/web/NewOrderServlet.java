package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "NewOrderServlet")
public class NewOrderServlet extends HttpServlet {
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String  SIGNON_FORM= "/WEB-INF/jsp/account/SignonForm.jsp";
    AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Cart cart=(Cart)session.getAttribute("cart");
        String username=(String)session.getAttribute("username");
        if(username==null){
            session.setAttribute("message","You must sign on before attempting to check out.  Please sign on and try checking out again.");
            request.getRequestDispatcher(SIGNON_FORM).forward(request,response);
        }
        else if(cart!=null){
            Order order=new Order();
            order.initOrder(accountService.getAccount(username),cart);
            session.setAttribute("order",order);
            request.getRequestDispatcher(NEW_ORDER).forward(request,response);
        }
        else {
            session.setAttribute("message","An order could not be created because a cart could not be found.");
            request.getRequestDispatcher(ERROR).forward(request,response);
        }
    }
}
