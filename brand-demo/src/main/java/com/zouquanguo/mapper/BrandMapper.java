package com.zouquanguo.mapper;

import com.zouquanguo.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 新增
     * @param brand
     */
    @ResultMap("brandResultMap")
    @Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) " +
            "value (#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand where id=#{id}")
    Brand selectBrandById(Integer id);

    /**
     * 通过id修改
     * @param brand
     */
    @ResultMap("BrandResultMap")
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void updateById(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(Integer id);


}

