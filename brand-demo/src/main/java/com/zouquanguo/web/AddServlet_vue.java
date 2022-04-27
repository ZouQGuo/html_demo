package com.zouquanguo.web;

import com.alibaba.fastjson.JSON;
import com.zouquanguo.pojo.Brand;
import com.zouquanguo.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet_vue")
public class AddServlet_vue extends HttpServlet {
    /**
     * 添加品牌
     */
    private BrandService service =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求乱码问题
//        request.setCharacterEncoding("utf-8");

        //1  接收表单提交的数据 封装成一个Brand对象
//        String brandName = request.getParameter("brandName");
//        String CompanyName = request.getParameter("companyName");
//        String ordered = request.getParameter("ordered");
//        String description = request.getParameter("description");
//        String status = request.getParameter("status");
//        //封装brand
//        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setCompanyName(CompanyName);
//        brand.setOrdered(Integer.parseInt(ordered));//注意
//        brand.setDescription(description);
//        brand.setStatus(Integer.parseInt(status));

        //获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        System.out.println(params);


        //将JSON字符串转为java对象
        Brand brand = JSON.parseObject(params,Brand.class);

        // 2 调用service 完成添加
        service.add(brand);
        //响应成功标识
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
