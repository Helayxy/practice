package cn.lynu.xy.ioc.statisfactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticFactoryTest {

    @Test
    public void createService() {
        //指定配置文件路径
        String xmlPath= "beans.xml";
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //这一步表示从工厂得到了对象
        UserService userService = applicationContext.getBean("staticFactory", UserService.class);
        //对象调用方法
        userService.addUser();
    }
}