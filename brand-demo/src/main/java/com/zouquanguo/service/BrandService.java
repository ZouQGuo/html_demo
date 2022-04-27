package com.zouquanguo.service;

import com.zouquanguo.mapper.BrandMapper;
import com.zouquanguo.pojo.Brand;
import com.zouquanguo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactoryUtils();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        //调用mapper.selectAll

        //获取sqlSession
        SqlSession sqlSession = factory.openSession(true);
        //获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        //调用mapper.add
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.add(brand);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Brand selectBrandById(Integer id){
        //调用mapper.selectBrandById
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectBrandById(id);
        sqlSession.commit();
        sqlSession.close();
        return brand;
    }

    /**
     * 根据id修改
     * @param brand
     */
    public void updateById(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateById(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(Integer id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

}
