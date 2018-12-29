package org.csu.mypetstore.web;

import org.csu.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MyRecordsServlet")
public class MyRecordsServlet extends HttpServlet {
    private LogService logService = new LogService();
    private static String MY_RECORDS = "/WEB-INF/jsp/record/myRecords.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("logList",logService.getLogs());
        request.getRequestDispatcher(MY_RECORDS).forward(request,response);
    }
}
