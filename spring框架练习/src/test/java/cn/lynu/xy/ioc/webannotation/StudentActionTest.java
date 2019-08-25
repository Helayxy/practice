package cn.lynu.xy.ioc.webannotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentActionTest {


    @Test
    public void execute() {
        String xmlPath = "webannotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        StudentAction studentAction = applicationContext.getBean("studentAction", StudentAction.class);
        studentAction.execute();
    }
}