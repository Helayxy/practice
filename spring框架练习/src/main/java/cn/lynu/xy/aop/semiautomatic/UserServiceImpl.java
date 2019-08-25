package cn.lynu.xy.aop.semiautomatic;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("semiautomatic addUser");
    }
    @Override
    public void updateUser() {
        System.out.println("semiautomatic updateUser");
    }
    @Override
    public void delUser() {
        System.out.println("semiautomatic delUser");
    }
}
