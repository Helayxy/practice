package cn.lynu.xy.aop.aspectjxml;

public class BookServiceImpl implements BookService {
    @Override
    public void addBook() {
        System.out.println("aspectjxml  addBook");
    }

    @Override
    public String updateBook() {
        System.out.println("aspectjxml  updateBook");
        int i=3/0;
        return "阳志就是吊";
    }

    @Override
    public void delBook() {
        System.out.println("aspectjxml  delBook");
    }
}
