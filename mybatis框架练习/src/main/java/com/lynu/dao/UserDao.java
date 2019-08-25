package com.lynu.dao;

import com.lynu.pojo.User;

import java.util.List;

public interface UserDao {

    //根据id查询用户
    public User findUserById(int user_id);
    //查询所有用户信息
    public List<User> findAllUser();
    //添加用户
    public void addUser(User user);
    //更新用户
    public void updateUser(User user);
    //根据id删除用户
    public void delUserById(int user_id);
}
