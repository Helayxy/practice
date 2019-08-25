package cn.lynu.xy.aop.cglib;

import org.junit.Test;

public class CglibTest {

    @Test
    public void test() {
        UserServiceImpl userService = MyBeanFactory.createUserService();
        userService.addUser();
        userService.updateUser();
        userService.delUser();
    }
}