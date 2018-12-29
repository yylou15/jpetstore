package org.csu.mypetstore.web;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import static org.csu.mypetstore.utils.VerifyUtil.checkVerify;

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
        HttpSession session = request.getSession();

        username=request.getParameter("username");
        password=request.getParameter("password");
        String verifyCode = request.getParameter("verifyCode");
        Account account=accountService.getAccount(username,password);
//        System.out.println(account.getUsername());
//        System.out.println(account.getUsername()==null);

        String correctCode = session.getAttribute("verifyCode").toString();
        if(!checkVerify(verifyCode,correctCode)){
            session.setAttribute("message","Wrong VerifyCode.Try again.");
            request.getRequestDispatcher(SIGNON_FORM).forward(request,response);
        }else if(account==null){
            session.setAttribute("message","Invalid username or password. Signon failed.");
            request.getRequestDispatcher(SIGNON_FORM).forward(request,response);
        }else {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Log loginLog = new Log();
            LogService logService = new LogService();
            logService.insertLog(username,"Log In", username + " log in!",df.format(new Date()));


            session.removeAttribute("message");
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("account",account);
            request.getRequestDispatcher(MAIN).forward(request,response);


        }

    }


}
