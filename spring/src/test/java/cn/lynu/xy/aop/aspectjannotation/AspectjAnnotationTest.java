package cn.lynu.xy.aop.aspectjannotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjAnnotationTest {
    @Test
    public void test() {
        String xmlPath = "aspectjannotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        bookService.addBook();
        bookService.updateBook();
        bookService.delBook();

    }

}