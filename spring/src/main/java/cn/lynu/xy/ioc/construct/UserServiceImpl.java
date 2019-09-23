package cn.lynu.xy.ioc.construct;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("a_ioc add user");
    }
}
