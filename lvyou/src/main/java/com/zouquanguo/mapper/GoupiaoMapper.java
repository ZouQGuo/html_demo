package com.zouquanguo.mapper;

import com.zouquanguo.pojo.Goupiao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoupiaoMapper {
    //查询所有购票记录
    @Select("select * from goupiaojilu")
    List<Goupiao> selectAll();

    //单个删除数据
    @Delete("delete from goupiaojilu where id=#{id}")
    void deleteById(int id);

    //修改数据
    @Update("update goupiaojilu set jingdianmingcheng=#{jingdianmingcheng},jingdiandengji=#{jingdiandengji},suozaichengshi=#{suozaichengshi}," +
            "diliweizhi=#{diliweizhi},kaifangshijian=#{kaifangshijian},menpiaojiage=#{menpiaojiage},piaoshu=#{piaoshu},zongjia=#{zongjia},beizhu=#{beizhu}," +
            "goupiaoyonghu=#{goupiaoyonghu},addtime=#{addtime} where id=#{id}")
    void updateById(int id);

    //分页查询每页显示条数
    @Select("select * from goupiaojilu limit #{begin},#{size}")
    List<Goupiao> selectByPage(@Param("begin") int begin,@Param("size") int size);
    //分页查询之 总记录数
    @Select("select COUNT(*) from goupiaojilu")
    int selectTotal();

    //批量删除购票记录
    void deleteByIds(@Param("ids") int[] ids);
}
