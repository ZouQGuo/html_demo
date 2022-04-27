package com.zouquanguo;

import com.zouquanguo.bean.Exam;
import com.zouquanguo.mapper.ExamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class myBatisDemo3 {
    /**
     * Mapper代理 条件查询
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //用户输入
        String name = "诸";//姓关的同学
        Double chinese = 90.0;//85的
        //处理
        name = name+"%";//姓关同学
        Exam exam = new Exam();
        exam.setName(name);
        exam.setChinese(chinese);
        //加载mybatis 的核心配置文件  获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2  获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3 执行sql
//        List<Exam> exams = sqlSession.selectList("test.selectAll");
        //获取examMapper接口的代理对象
        ExamMapper mapper = sqlSession.getMapper(ExamMapper.class);
        List<Exam> exams = mapper.selectByCondition1(exam);

        System.out.println(exams);

        sqlSession.close();
    }
}
