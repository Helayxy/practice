package cn.lynu.xy.ioc.construct;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceTest {

    @Test
    public void test() {
        String xmlPath= "beans.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.addBook();
    }
}