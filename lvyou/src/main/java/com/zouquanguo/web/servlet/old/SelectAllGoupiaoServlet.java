package com.zouquanguo.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.zouquanguo.pojo.Goupiao;
import com.zouquanguo.service.GoupiaoService;
import com.zouquanguo.service.impl.GoupiaoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllGoupiaoServlet")
public class SelectAllGoupiaoServlet extends HttpServlet {

    private GoupiaoService goupiaoService = new GoupiaoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        List<Goupiao> goupiaos = goupiaoService.selectAll();
        //2 转为JSON字符串
        String jsonString = JSON.toJSONString(goupiaos);
        //3 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
