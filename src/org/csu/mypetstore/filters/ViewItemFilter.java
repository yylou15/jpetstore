package org.csu.mypetstore.filters;

import org.csu.mypetstore.domain.Log;
import org.csu.mypetstore.service.LogService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter(filterName = "ViewItemFilter")
public class ViewItemFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpSession session = httpRequest.getSession();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        LogService logService = new LogService();
        logService.insertLog( session.getAttribute("username").toString(),"ViewItem","Item name:" + req.getParameter("itemId"), df.format(new Date()));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
