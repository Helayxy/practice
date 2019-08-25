package cn.lynu.xy.aop.semiautomatic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * 切面类中确定通知，需要实现不同的接口；接口就是规范，从而确定方法名
 * 采用环绕通知-->MethodInterceptor
 * */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("前方法");
        //手动执行目标方法
        Object obj = mi.proceed();
        System.out.println("后方法");
        return obj;
    }
}
