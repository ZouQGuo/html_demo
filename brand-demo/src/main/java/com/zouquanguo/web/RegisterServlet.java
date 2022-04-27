package com.zouquanguo.web;

import com.zouquanguo.pojo.User;
import com.zouquanguo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userName = service.selectByUsername(username);
        //判断验证码是否正确
        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");
        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String  checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCode.equalsIgnoreCase(checkCodeGen)){
            //如果不相等 返回到注册页面 并提示验证码错误 并结束该方法
            request.setAttribute("reg_msg","验证码错误");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        if (userName==null){
            //可以注册
            service.add(user);
            //跳转到登录页面
            request.setAttribute("reg_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //不可以注册 将提示信息存入request域 带回注册页面
            request.setAttribute("reg_msg","用户名已被占用");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
