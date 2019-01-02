package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "CartAjaxServlet")
public class CartAjaxServlet extends HttpServlet {
    private Cart cart;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        cart = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItems=cart.getAllCartItems();
//        int quality=Integer.parseInt((String) )

    }
}
