package com.zouquanguo.contrller;

import com.zouquanguo.pojo.Brand;
import com.zouquanguo.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//Spring-mvc 入门
public class AddController {
    BrandService service = new BrandService();
    @RequestMapping("/BrandAdd")
    public String addMethod(HttpServletRequest req, HttpServletResponse rep, Brand brand){
        service.add(brand);
        return "selectAllServlet";
    }
}
