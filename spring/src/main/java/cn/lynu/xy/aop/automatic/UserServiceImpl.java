package cn.lynu.xy.aop.automatic;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("automatic addUser");
    }
    @Override
    public void updateUser() {
        System.out.println("automatic updateUser");
    }
    @Override
    public void delUser() {
        System.out.println("automatic delUser");
    }
}
