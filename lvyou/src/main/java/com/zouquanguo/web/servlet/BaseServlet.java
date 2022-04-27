package com.zouquanguo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    //重写service 方法 根据请求的最后一段路径来进行方法分发


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1  获取请求路径
        String uri = req.getRequestURI();// brand-demo/brand/select
        //2 获取最后一段路径（方法名）截取uri的最后一个
        //选择截取标记（最后一个’/‘）
        int index = uri.lastIndexOf("/");//截取出来是带/的
        String methodName = uri.substring(index + 1);//从最后一个’/‘符号的的下一个开始截
        //3 执行方法
        //3.1 获取对应字节码文件（获取类对象）
        Class<? extends BaseServlet> cla = this.getClass();
        //3.2 提取该对象的方法
        try {
            Method method = cla.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //3.3 执行方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
