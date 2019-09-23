package cn.lynu.xy.transfer.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void transfer() {
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("jack", "rose", 100);
    }
}