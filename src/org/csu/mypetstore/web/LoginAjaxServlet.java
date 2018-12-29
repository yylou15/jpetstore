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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.csu.mypetstore.utils.VerifyUtil.checkVerify;

@WebServlet(name = "LoginAjaxServlet")
public class LoginAjaxServlet extends HttpServlet {

    AccountService accountService=new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String code = request.getParameter("code");

        Account account=accountService.getAccount(username,pwd);

        String correctCode = session.getAttribute("verifyCode").toString();

        if(!checkVerify(code,correctCode)){
            out.println("{\"status\": false,\"msg\":\"Incorrect Verify Code\"}");
        }else if(account == null){
            out.println("{\"status\": false,\"msg\":\"Invalid username or password. Signon failed.\"}");
        }else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Log loginLog = new Log();
            LogService logService = new LogService();
            logService.insertLog(username,"Log In", username + " log in!",df.format(new Date()));
            session.removeAttribute("message");
            session.setAttribute("username",username);
            session.setAttribute("password",pwd);
            session.setAttribute("account",account);

            out.println("{\"status\": true}");
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
