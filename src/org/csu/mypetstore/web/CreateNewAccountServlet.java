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

@WebServlet(name = "CreateNewAccountServlet")
public class CreateNewAccountServlet extends HttpServlet {
    private static final String EDIT_ACCOUNT_FORM = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String NEW_ACCOUNT_FORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    Account account=new Account();
    AccountService accountService=new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String password1=request.getParameter("password");
        String password2=request.getParameter("repeatedPassword");
        String username=request.getParameter("username");
        if(password1==password2&&accountService.getAccount(username)==null&&username!=""&&password1!=""){
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
            session.setAttribute("account",account);
            session.setAttribute("username",account.getUsername());
            request.getRequestDispatcher(EDIT_ACCOUNT_FORM).forward(request,response);
        }
        else if(username==""){
            session.setAttribute("message","The username is null,please enter your username");
            request.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(request,response);
        }
        else if(accountService.getAccount(username)!=null){
            session.setAttribute("message","The username has been registered,please change one.");
            request.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(request,response);
        }
        else if(password1==""){
            session.setAttribute("message","The password is null,please enter your password");
            request.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(request,response);
        }
        else if(password1!=password2){
            session.setAttribute("message","Please make sure the passwords you entered twice are the same");
            request.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(request,response);
        }
    }
}
