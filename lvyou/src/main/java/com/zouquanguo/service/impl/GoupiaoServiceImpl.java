package com.zouquanguo.service.impl;

import com.zouquanguo.mapper.GoupiaoMapper;
import com.zouquanguo.pojo.Goupiao;
import com.zouquanguo.pojo.Page;
import com.zouquanguo.service.GoupiaoService;
import com.zouquanguo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GoupiaoServiceImpl implements GoupiaoService {
    //创建SQLSessionFactory工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactoryUtils();
    @Override
    //查询所有
    public List<Goupiao> selectAll() {
        // 2获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //3 获取mapper
        GoupiaoMapper mapper = sqlSession.getMapper(GoupiaoMapper.class);
        //4 调用方法
        List<Goupiao> goupiaos = mapper.selectAll();
        //5释放资源
        sqlSession.close();

        return goupiaos;
    }

    @Override
    //单个删除
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        GoupiaoMapper mapper = sqlSession.getMapper(GoupiaoMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    //修改
    public void updateById(int id) {
        SqlSession sqlSession = factory.openSession();
        GoupiaoMapper mapper = sqlSession.getMapper(GoupiaoMapper.class);
        mapper.updateById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    //分页查询
    public Page<Goupiao> selectByPage(int currentPage, int size) {
        SqlSession sqlSession = factory.openSession();
        GoupiaoMapper mapper = sqlSession.getMapper(GoupiaoMapper.class);

        //计算起始索引
        int begin = (currentPage-1)*size;
        List<Goupiao> goupiaos = mapper.selectByPage(begin, size);
        int total = mapper.selectTotal();
        Page<Goupiao> goupiaoPage = new Page<>(goupiaos, total);
        sqlSession.close();
        return goupiaoPage;
    }

    @Override
    //批量删除
    public void deleteByIds(int[] ids){
        //接受id数组
        //获取SqlSession
        SqlSession SqlSession = factory.openSession();
        //获取mapper
        GoupiaoMapper mapper = SqlSession.getMapper(GoupiaoMapper.class);
        mapper.deleteByIds(ids);
        //提交事务
        SqlSession.commit();
        //释放资源
        SqlSession.close();
    }
}
