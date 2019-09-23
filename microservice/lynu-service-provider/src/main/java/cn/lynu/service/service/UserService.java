package cn.lynu.service.service;

import cn.lynu.service.mapper.UserMapper;
import cn.lynu.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //根据id查询用户
    public User findUserById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
