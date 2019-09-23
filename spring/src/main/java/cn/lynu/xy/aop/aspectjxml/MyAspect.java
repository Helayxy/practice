package cn.lynu.xy.aop.aspectjxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
* 切面类（各种通知，通知就是方法）
* */
public class MyAspect {
    //前置通知
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知"+","+"目标类方法名"+joinPoint.getSignature().getName());
    }
    //后置通知
    public void myAfterReturning(JoinPoint joinPoint,Object ret){
        System.out.println("后置通知"+","+"目标类方法名"+joinPoint.getSignature().getName()+ret);
    }
    //环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //前方法
        System.out.println("前方法");
        //手动执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        //后方法
        System.out.println("后方法");
        return obj;
    }
    //异常通知
    public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("目标方法方法名"+joinPoint.getSignature().getName()+","+"异常信息"+throwable.getMessage());
    }
    //最终通知，无论怎样都会执行
    public void myAfter(JoinPoint joinPoint){
        System.out.println("最终通知"+","+"目标方法方法名"+joinPoint.getSignature().getName());
    }
}
