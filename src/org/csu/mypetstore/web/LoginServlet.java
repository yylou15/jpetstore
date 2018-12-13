package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String  SIGNON_FORM= "/WEB-INF/jsp/account/SignonForm.jsp";
    String username;
    String password;
    AccountService accountService=new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        username=request.getParameter("username");
        password=request.getParameter("password");
        HttpSession session=request.getSession();
        Account account=accountService.getAccount(username,password);
        if(account==null){
            session.setAttribute("message","Invalid username or password. Signon failed.");
            request.getRequestDispatcher(SIGNON_FORM).forward(request,response);
        }else {
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("account",account);
            request.getRequestDispatcher(MAIN).forward(request,response);
        }

    }
}
