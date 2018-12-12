package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.temporal.Temporal;

@WebServlet(name = "AddItemToCartServlet")
public class AddItemToCartServlet extends HttpServlet {
    private static final String VIEW_CART="/WEB-INF/jsp/cart/Cart.jsp";
    private CatalogService catalogService;//处理该请求需要的数据
    private String workingItemId;//是否需要调用业务逻辑层
    private Cart cart;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId=request.getParameter("workingItemId");

        HttpSession session=request.getSession();
        cart=(Cart) session.getAttribute("cart");

        if(cart==null){
            cart=new Cart();
        }
        if(cart.containsItemId(workingItemId)){
            cart.incrementQuantityByItemId(workingItemId);
        }
        else {
            catalogService=new CatalogService();
            boolean isInStock=catalogService.isItemInStock(workingItemId);
            Item item=catalogService.getItem(workingItemId);
            cart.addItem(item,isInStock);
        }

        session.setAttribute("cart",cart);

        request.getRequestDispatcher(VIEW_CART).forward(request,response);
    }
}
