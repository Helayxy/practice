package cn.lynu.xy.aop.automatic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
   切面类需要实现不同的接口（通知类型）
 * 切面类中确定通知类型，本次采用环绕通知：MethodInterceptor
 * 接口就是规范，从而确定方法名
 * */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("前4");//前方法
        Object obj = mi.proceed();//手动执行目标方法
        System.out.println("后4");//后方法
        return obj;
    }
}
