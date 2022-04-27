package com.zouquanguo.mapper;

import com.zouquanguo.bean.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ExamMapper {
    List<Exam> selectAll();
    Exam selectById();

    List<Exam> selectByCondition(@Param("name") String name,@Param("chinese") double chinese);
    List<Exam> selectByCondition1(Exam exam);
    List<Exam> selectByCondition2(Map map);

    List<Exam> selectBySingle(Exam exam);
    void add(Exam exam);

    int update(Exam exam);
    int updateById(Exam exam);
    void deleteByIds(@Param("ids") ArrayList ids);

    @Select("select * from exam where id = #{id}")//通过注解的方式写SQL
    int updateById1(Integer id);




}
