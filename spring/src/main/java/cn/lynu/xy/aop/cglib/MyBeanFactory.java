package cn.lynu.xy.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {
    public static UserServiceImpl createUserService() {
        UserServiceImpl userService = new UserServiceImpl(); //1.目标类
        MyAspect myAspect = new MyAspect();//2.切面类
        //3.代理类，采用cglib代理，底层是创建目标类的子类
        Enhancer enhancer=new Enhancer(); //3.1.核心类
        enhancer.setSuperclass(userService.getClass()); //3.2.确定父类
        //3.3设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.before(); //前方法
                Object obj = method.invoke(userService); //执行目标法
                myAspect.after();//后方法
                return obj;
            }
        });
        UserServiceImpl proxservice = (UserServiceImpl) enhancer.create();  //3.4创建代理对象
        return proxservice;
    }
}
