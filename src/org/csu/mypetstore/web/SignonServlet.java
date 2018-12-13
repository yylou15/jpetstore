package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignonServlet")
public class SignonServlet extends HttpServlet {
    private static final String SIGNON_FORM="/WEB-INF/jsp/account/SignonForm.jsp";
    AccountBean accountBean = new AccountBean();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountBean.setAuthenticated(true);
        request.getRequestDispatcher(SIGNON_FORM).forward(request,response);
    }
}
