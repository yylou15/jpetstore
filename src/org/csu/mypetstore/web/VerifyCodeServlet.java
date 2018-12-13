package org.csu.mypetstore.web;

import org.csu.mypetstore.utils.VerifyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.awt.image.RenderedImage;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        Map<String,Object> map = VerifyUtil.generateCodeAndPic();
        //图片内容放输出流中
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", response.getOutputStream());

        //session添加一个code属性用于验证
        HttpSession session=request.getSession();
        session.setAttribute("verifyCode",map.get("code"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
