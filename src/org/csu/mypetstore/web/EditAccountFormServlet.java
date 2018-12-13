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

@WebServlet(name = "EditAccountFormServlet")
public class EditAccountFormServlet extends HttpServlet {
    AccountService accountService=new AccountService();
    private static final String EDIT_ACCOUNT_FORM = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private String username;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        username=request.getParameter("username");
        HttpSession session = request.getSession();
        Account account=new Account();
        account=accountService.getAccount(username);
        session.setAttribute("account",account);

        request.getRequestDispatcher(EDIT_ACCOUNT_FORM).forward(request,response);

    }
}
