package com.zouquanguo.contrller;

import com.zouquanguo.pojo.User;
import com.zouquanguo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @RequestMapping("/Register")
    public String Register(HttpServletRequest req, HttpServletResponse rep, User user,String checkCode){
        //获取用户输入的验证码
        //获取程序生成的验证码
        HttpSession session = req.getSession();
        String  checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCode.equalsIgnoreCase(checkCodeGen)){
            //如果不相等 返回到注册页面 并提示验证码错误 并结束该方法
            req.setAttribute("reg_msg","验证码错误");
            return "register.jsp";
        }


        //查询是否有该用户 用户名重复否
        UserService service = new UserService();
        User username = service.selectByUsername(user.getUsername());
        if (username!=null){
            //不可以注册 将提示信息存入request域 带回注册页面
            req.setAttribute("reg_msg","用户名已被占用");
            return "register";
        }else {
            //可以注册
            service.add(user);
            //跳转到登录页面
            req.setAttribute("reg_msg","注册成功，请登录");
            return "login";
        }
    }
}
