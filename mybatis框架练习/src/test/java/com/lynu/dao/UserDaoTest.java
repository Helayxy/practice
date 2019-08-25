package com.lynu.dao;

import com.lynu.daoimpl.UserDaoImpl;
import com.lynu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    //@Before注解，在执行测试用例之前执行
    @Before
    public void setFirst() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件流
        InputStream is = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory工厂（这是一个接口）
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 通过工厂获取sqlSession,SqlSession也是一个接口
        sqlSession = sqlSessionFactory.openSession();
        //拿接口new实现，把sqlSession作为参数传入，通过sqlSession操作CRUD
        this.userDao = new UserDaoImpl(sqlSession);

    }

    @Test
    public void findUserById() {
        User user = this.userDao.findUserById(4);
        System.out.println(user);
    }

    @Test
    public void findAllUser() {
        List<User> list = this.userDao.findAllUser();
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUser_name("aazz");
        user.setUser_age(12);
        user.setUser_sex(1);
        user.setRole_id(1);
        this.userDao.addUser(user);
        this.sqlSession.commit();//提交事务
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUser_id(1);
        user.setUser_name("hahahahh");
        user.setUser_age(10);
        user.setUser_sex(1);
        user.setRole_id(1);
        this.userDao.updateUser(user);
        this.sqlSession.commit();

    }

    @Test
    public void delUserById() {
        this.userDao.delUserById(13);
        this.sqlSession.commit();//一定记得提交事务
    }

}