package cn.lynu.dao;

import cn.lynu.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * 使用mapper代理开发，不需要写实现类
 * */
@Repository //此注解表示spring容器创建该类的实例对象
public interface AccountDao {
    //使用注解开发
    //查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account (username,balance) values (#{username},#{balance})")
    public void saveAccount(Account account);
}
