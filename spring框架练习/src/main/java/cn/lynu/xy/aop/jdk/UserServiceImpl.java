package cn.lynu.xy.aop.jdk;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("addUser");
    }
    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }
    @Override
    public void delUser() {
        System.out.println("delUser");
    }
}
