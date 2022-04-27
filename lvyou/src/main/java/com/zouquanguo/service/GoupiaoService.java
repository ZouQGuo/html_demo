package com.zouquanguo.service;

import com.zouquanguo.pojo.Goupiao;
import com.zouquanguo.pojo.Page;

import java.util.List;

public interface GoupiaoService {
    //查询所有
    List<Goupiao> selectAll();

    //单个删除
    void deleteById(int id);

    //修改数据
    void updateById(int id);

    //分页查询
    Page<Goupiao> selectByPage(int currentPage,int size);

    //批量删除
    void deleteByIds(int[] ids);
}
