package cn.lynu.xy.ioc.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 实例工厂测试
 * */
public class InstanceFactoryTest {
    //这是自定义工厂的方式
    @Test
    public void createService01() {
        //创建工厂
        InstanceFactory instanceFactory = new InstanceFactory();
        //工厂实例调用创建对象的方法获得对象
        UserService userService = instanceFactory.createService();
        //对象调用方法
        userService.addUser();
    }
    //这是使用spring工厂的方式
    @Test
    public void createService02(){
        String xmlPath="beans.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userServiceId", UserService.class);
        userService.addUser();
    }

}