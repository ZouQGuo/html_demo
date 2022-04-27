package com.zouquanguo.web;

import com.alibaba.fastjson.JSON;
import com.zouquanguo.pojo.Brand;
import com.zouquanguo.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet_vue")
public class SelectAllServlet_vue extends HttpServlet {
    private BrandService service = new BrandService();

    /**
     * 查询所有品牌
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用brandService 完成查询

        List<Brand> brands = service.selectAll();
        System.out.println(brands);
//        //存入request域中
//        request.setAttribute("brands",brands);
//        //转发到brand.jsp
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);

        //2 将集合转换为json数据 这一步叫 序列化
        String jsonString = JSON.toJSONString(brands);
        System.out.println(jsonString);
        //3 将字符串响应到页面
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
