package cn.lynu.service.controller;

import cn.lynu.service.pojo.User;
import cn.lynu.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //根据id查询用户
    //这里的id用于在url地址中输入要查询的用户id
    @GetMapping("{id}")
    //@PathVariable("id")：用于获取url地址中的id值
    public User findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);

    }
}
