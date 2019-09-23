package cn.lynu.test;

import cn.lynu.dao.AccountDao;
import cn.lynu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void test01() throws Exception {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库（增删改查）
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //调用方法
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //关闭资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void test02() throws Exception {
        Account account = new Account();
        account.setUsername("mmm");
        account.setBalance(10);
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库（增删改查）
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //调用方法
        accountDao.saveAccount(account);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        inputStream.close();
    }
}
