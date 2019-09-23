package cn.lynu.xy.ioc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void test() {
        String xmlPath="annotation.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }
}