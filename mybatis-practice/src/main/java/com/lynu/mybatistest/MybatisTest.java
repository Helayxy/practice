package com.lynu.mybatistest;

import com.lynu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {

        //指定全局配置文件路径
        String resources = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resources);
        //创建sqlsessionfactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂获取sqlsesion
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlsesion操作CRUD（增删改查）
        // 第一个参数：映射文件中statementID，写法：命名空间+“.”+statementID
        // 第二个参数：映射文件中指定的类型的参数：这里是用户的id
        User user = sqlSession.selectOne("UserMapper.selectUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }
}
