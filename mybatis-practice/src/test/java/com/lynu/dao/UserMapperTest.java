package com.lynu.dao;

import com.lynu.pojo.User;
import com.lynu.pojo.UserCustom;
import com.lynu.pojo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    public UserMapper userMapper;
    public SqlSession sqlSession;

    @Before
    public void first() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        this.sqlSession = sqlSessionFactory.openSession();
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findUserById() {
        User user = this.userMapper.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void findUserByIdCommonSql() {
        User user = this.userMapper.findUserByIdCommonSql(1);
        System.out.println(user);
    }

    @Test
    public void delUserById() {
        this.userMapper.delUserById(1);
        this.sqlSession.commit();
        this.sqlSession.close();
    }
    @Test
    public void findUserList() {
        //创建对象，设置查询条件
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setUser_sex(1);
        userCustom.setUser_name("张三");
        userQueryVo.setUserCustom(userCustom);
        //调用接口中的方法查询
        List<UserCustom> list = this.userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }
    @Test
    public void findUserCount() throws Exception {
        //创建对象，设置查询条件
        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom=new UserCustom();
        userCustom.setUser_sex(1);
        userQueryVo.setUserCustom(userCustom);
        //调用接口中的方法查询
        int i = this.userMapper.findUserCount(userQueryVo);
        System.out.println(i);
    }
    @Test
    public void findUserByIdResultMap() {
        User user = this.userMapper.findUserById(1);
        System.out.println(user);
    }
    //测试if查询sex为1的用户，如果输入了姓名，则按姓名查询
    @Test
    public void testfindUserListif() {
        List<User> list = this.userMapper.findUserListif(null);
        for(User l:list)
        System.out.println(l);
    }

    @Test
    public void findUserByNameAndSex() {
        List<User> list = this.userMapper.findUserByNameAndSex(null,1);
        for(User l:list)
            System.out.println(l);
    }



}