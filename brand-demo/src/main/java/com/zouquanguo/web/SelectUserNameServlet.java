package com.zouquanguo.web;

import com.zouquanguo.pojo.User;
import com.zouquanguo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectUserNameServlet")
public class SelectUserNameServlet extends HttpServlet {
    /**
     * 查询用户是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1 接受用户名
        String username = request.getParameter("username");
        //2获取UserService
        UserService service = new UserService();
        //3 调用service里的查询用户名的方法
        User user = service.selectByUsername(username);
        //判断用户名是否存在
        boolean flag;
        if (user==null){
            //如果没有改用户 可以注册 返回true
            flag=true;
        }else {
            flag=false;
        }
        //标记响应
        response.getWriter().write(""+flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
