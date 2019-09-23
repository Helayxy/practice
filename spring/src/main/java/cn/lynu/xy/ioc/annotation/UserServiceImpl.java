package cn.lynu.xy.ioc.annotation;

import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("zzzzzzzzzzz");
    }
}
