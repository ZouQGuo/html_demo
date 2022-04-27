package com.zouquanguo;

import com.zouquanguo.bean.Exam;
import com.zouquanguo.mapper.ExamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class myBatisDemo7 {
    /**
     * 通过id修改
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //用户输入
        String name = "李元芳";//姓关的同学
        Double chinese = 88.0;
        Double math = 69.0;
        Double english = 76.0;
        int id = 10;

        Exam exam = new Exam();
        exam.setName(name);
        exam.setChinese(chinese);
        exam.setMath(math);
        exam.setEnglish(english);
        exam.setId(id);
        //加载mybatis 的核心配置文件  获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2  获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3 执行sql
//        List<Exam> exams = sqlSession.selectList("test.selectAll");
        //获取examMapper接口的代理对象
        ExamMapper mapper = sqlSession.getMapper(ExamMapper.class);
        int updateById = mapper.updateById(exam);
        System.out.println(updateById);

        sqlSession.close();
    }
}
