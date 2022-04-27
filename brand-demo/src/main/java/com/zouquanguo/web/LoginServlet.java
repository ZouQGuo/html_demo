package com.zouquanguo.web;

import com.zouquanguo.pojo.User;
import com.zouquanguo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService service = new UserService();

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = service.login(username, password);
        //获取复选框数据
        String remember = request.getParameter("remember");
        if (user==null){
            //登录失败
            //存储错误的用户信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            //跳回登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            //将登录成功后的user对象存到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //如果选择记住密码 将密码存到cookie
            if ("1".equals(remember)){
                //创建cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                //设置存活时间 一周
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //登录成功  跳转到查询所有brand
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
