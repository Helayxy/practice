package cn.lynu.xy.ioc.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSetter {
    @Test
    public void test(){
        String xmlPath= "setter.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
