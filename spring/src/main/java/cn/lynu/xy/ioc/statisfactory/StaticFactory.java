package cn.lynu.xy.ioc.statisfactory;
/*
* 静态工厂
* */
public class StaticFactory {
    public static UserService createService(){
        return new UserServiceImpl();
    }
}
