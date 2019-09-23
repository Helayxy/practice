package cn.lynu.user.controller;

import cn.lynu.user.pojo.User;
import cn.lynu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@RestController=@Controller+@ResponseBody
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //这里的id用于在url地址中输入
    @ResponseBody
    @GetMapping("{id}")
    //@PathVariable：次注解用于获取url地址中的参数
    public User findUserById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }

    @GetMapping("allUser")
    public String all(Model model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("allUser", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

    @ResponseBody
    @GetMapping("hello")
    public String test() {
        return "hello ssm";
    }

}
