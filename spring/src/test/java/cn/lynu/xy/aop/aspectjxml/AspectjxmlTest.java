package cn.lynu.xy.aop.aspectjxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjxmlTest {
    @Test
    public void test() {
        String xmlPath="aspectjxml.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //获取目标对象userService
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        bookService.addBook();
        bookService.updateBook();
        bookService.delBook();
    }

}