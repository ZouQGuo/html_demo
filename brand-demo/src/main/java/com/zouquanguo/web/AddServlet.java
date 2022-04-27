package com.zouquanguo.web;

import com.zouquanguo.pojo.Brand;
import com.zouquanguo.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    /**
     * 添加品牌
     */
    private BrandService service =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求乱码问题
        request.setCharacterEncoding("utf-8");

        //1  接收表单提交的数据 封装成一个Brand对象
        String brandName = request.getParameter("brandName");
        String CompanyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        //封装brand
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(CompanyName);
        brand.setOrdered(Integer.parseInt(ordered));//注意
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        // 2 调用service 完成添加
        service.add(brand);

        //3 转发到查询所有
        request.getRequestDispatcher("selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
