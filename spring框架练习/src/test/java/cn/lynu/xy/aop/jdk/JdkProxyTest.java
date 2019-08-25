package cn.lynu.xy.aop.jdk;

import org.junit.Test;

public class JdkProxyTest {

    @Test
    public void test() {
        UserService userService = MyBeanFactory.createUserService();
        userService.addUser();
        userService.updateUser();
        userService.delUser();
    }
}