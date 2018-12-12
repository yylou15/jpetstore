package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveAccountInfomationServlet")
public class SaveAccountInfomationServlet extends HttpServlet {
    Account account = new Account();
    AccountService accountService = new AccountService();
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        account.setUsername(request.getParameter("username"));
        account.setCity(request.getParameter("city"));
        account.setPhone(request.getParameter("phone"));
        account.setCountry(request.getParameter("country"));
        account.setPassword(request.getParameter("password"));
        account.setEmail(request.getParameter("email"));
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setStatus(request.getParameter("status"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setState(request.getParameter("state"));
        account.setZip(request.getParameter("zip"));
        account.setBannerOption(true);
        account.setListOption(true);
        account.setStatus(request.getParameter("status"));
        account.setLanguagePreference("languagePreference");
        account.setBannerName(request.getParameter("bannerName"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
        accountService.insertAccount(account);

        request.getRequestDispatcher(MAIN).forward(request,response);
    }
}
