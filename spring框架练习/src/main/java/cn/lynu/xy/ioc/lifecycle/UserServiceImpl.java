package cn.lynu.xy.ioc.lifecycle;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("add User...add users...");
    }
    public void myInit(){
        System.out.println("myInit...");
    }
    public void myDestroy(){
        System.out.println("myDestroy....");
    }
}
