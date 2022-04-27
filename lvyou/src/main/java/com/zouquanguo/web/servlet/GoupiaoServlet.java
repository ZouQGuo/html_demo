package com.zouquanguo.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zouquanguo.pojo.Goupiao;
import com.zouquanguo.pojo.Page;
import com.zouquanguo.service.GoupiaoService;
import com.zouquanguo.service.impl.GoupiaoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.List;

@WebServlet("/Goupiao/*")
public class GoupiaoServlet extends BaseServlet{
    private GoupiaoService goupiaoService = new GoupiaoServiceImpl();

    //查询所有
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //调用service
        List<Goupiao> goupiaos = goupiaoService.selectAll();
        //2 转为JSON字符串
        String jsonString = JSON.toJSONString(goupiaos);
        //3 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    //单个删除
    public void deleteById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        //接受要删除的id
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        Integer id = JSON.parseObject(readLine, int.class);
        goupiaoService.deleteById(id);
        resp.getWriter().write("success");
    }

    //修改数据
    public void updateById(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        //接受要修改的id
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        Integer id = JSON.parseObject(readLine, int.class);
        goupiaoService.updateById(id);
        resp.getWriter().write("success");
    }

    //分页查询
    public void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        //接收当前页和  每页显示条数
        String _currentPage = req.getParameter("currentPage");
        String _size = req.getParameter("pageSize");
        //将字符串转为Int
        int currentPage = Integer.parseInt(_currentPage);
        int size = Integer.parseInt(_size);

        Page<Goupiao> goupiaos = goupiaoService.selectByPage(currentPage, size);
        //2 转为JSON字符串
        String jsonString = JSON.toJSONString(goupiaos);
        //3 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    //批量删除
    public void deleteByIds(HttpServletRequest req,HttpServletResponse resp) throws Exception{
        //接受id数组
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();

        //转为数组对象
        int[] ids = JSON.parseObject(readLine, int[].class);
        //调用service删除
        goupiaoService.deleteByIds(ids);
        //响应成功标识
        resp.getWriter().write("success");
    }
}
