package cn.lynu.xy.ioc.lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void addUser() {
        //默认从src下找
        String xmlPath="beans.xml";
        //ApplicationContext是一个接口，ClassPathXmlApplicationContext是该接口的一个实现类
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserService userService1 = applicationContext.getBean("userService1", UserService.class);
        userService1.addUser();
        /*
          容器（applicationContext）必须close，销毁方法才能这执行此方法ApplicationContext接口中
          没有定义，实现类中有，所以上面的代码中，applicationContext返回的类型改为实现类的类型，
          即ClassPathXmlApplicationContext
            */
        applicationContext.close();
    }
}