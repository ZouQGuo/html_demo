package com.zouquanguo.web.filter;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")//过滤所有
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //强转一下
        HttpServletRequest req = (HttpServletRequest) request;

        // 把与登录和注册 有关的资源放到数组 通通放行
        String[] urls ={"/login.jsp","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet","/selectUserNameServlet","/*.js","/register_vue.jsp"};
        //获取当前访问路径
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)){
                //找到了 直接放行 无需在判断
                chain.doFilter(request,response);
                return;
            }
        }

        // 1 判断session中是否有user（是否登录）
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            //没有登录 存入提示信息  跳转到登录
            req.setAttribute("login_msg","您还未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }else {
            //登录过了
            //放行
            chain.doFilter(request, response);
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
