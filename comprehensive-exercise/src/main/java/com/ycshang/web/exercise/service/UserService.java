package com.ycshang.web.exercise.service;

import com.ycshang.web.exercise.entity.User;
import com.ycshang.web.exercise.mapper.UserMapper;
import com.ycshang.web.exercise.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @program: java-web-learning
 * @description: 用户服务类
 * @author: ycshang
 * @create: 2022-02-28 16:08
 **/
public class UserService {
    /**
     * 1、获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //    2、获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //    3、获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //    调用方法
        User user = mapper.findUser(username, password);
        //释放资源
        sqlSession.close();
        return user;
    }


    public boolean register(User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //    判断用户是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            //    用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }
}