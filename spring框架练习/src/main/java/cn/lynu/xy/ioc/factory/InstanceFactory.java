package cn.lynu.xy.ioc.factory;

public class InstanceFactory {
    public UserService createService(){
        return new UserServiceImpl();
    }
}
