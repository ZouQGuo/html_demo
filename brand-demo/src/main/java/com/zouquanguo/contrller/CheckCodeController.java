package com.zouquanguo.contrller;

import com.zouquanguo.util.CheckCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CheckCodeController {
    @RequestMapping("/CheckCode")
    public void check(HttpServletRequest req, HttpServletResponse rep, HttpSession session) throws Exception{
        //生成验证码
        ServletOutputStream os = rep.getOutputStream();
        String verifyImage = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        //将生成的验证码存入session
        session.setAttribute("checkCodeGen",verifyImage);

    }
}
