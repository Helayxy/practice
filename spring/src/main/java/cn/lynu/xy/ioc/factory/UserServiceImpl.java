package cn.lynu.xy.ioc.factory;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("static factory add user");
    }
}
