package cn.lynu.xy.aop.automatic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutomaticTest {

    @Test
    public void test() {
        String xmlPath="aop-automatic.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //获取目标对象userService
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
        userService.updateUser();
        userService.delUser();
    }
}