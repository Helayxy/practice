package cn.lynu.xy.aop.aspectjannotation;

import org.springframework.stereotype.Service;
//创建该类的实例，service层使用注解@Service，实例名为bookService
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Override
    public void addBook() {
        System.out.println("aspectjannotation   addBook");
    }
    @Override
    public void updateBook() {
        System.out.println("aspectjannotation   updateBook");
    }
    @Override
    public void delBook() {
        System.out.println("aspectjannotation   delBook");
    }
}
