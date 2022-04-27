package com.zouquanguo.web;

import com.zouquanguo.pojo.Brand;
import com.zouquanguo.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectBrandByIdServlet")
public class SelectBrandByIdServlet extends HttpServlet {
    BrandService service = new BrandService();

    /**
     * 根据id查询品牌信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Brand brand = service.selectBrandById(Integer.parseInt(id));
        request.setAttribute("brand",brand);
        //转发
        request.getRequestDispatcher("/updateById.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
