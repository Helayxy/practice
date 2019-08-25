package cn.lynu.xy.ioc.construct;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void test01() {
        //之前开发
        UserService userService=new UserServiceImpl();
        userService.addUser();
    }
    @Test
    public void test02() {
        //spring开发
        //获取配置文件
        String xmlPath= "ioc-beans.xml";
       //获得容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获得内容
        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.addUser();
    }


}