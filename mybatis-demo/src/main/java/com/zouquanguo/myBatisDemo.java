package com.zouquanguo;

import com.zouquanguo.bean.Exam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myBatisDemo {
    /**
     * myBatis 快速入门
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //加载mybatis 的核心配置文件  获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2  获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3 执行sql
        List<Exam> exams = sqlSession.selectList("test.selectAll");

        System.out.println(exams);

        sqlSession.close();
    }
}
