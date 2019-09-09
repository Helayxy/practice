package cn.lynu.user.service;

import cn.lynu.user.mapper.UserMapper;
import cn.lynu.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //删除主要提交事务，这里添加事务注解
    @Transactional
    public void deleteById(Long id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
