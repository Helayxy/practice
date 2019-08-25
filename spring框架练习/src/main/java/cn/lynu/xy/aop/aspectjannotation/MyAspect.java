package cn.lynu.xy.aop.aspectjannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/*
* 通知不要一起使用，分开测试
* */

@Component("myAspect")         //创建该类的实例，实例名写不写都可以
@Aspect     //声明切面类
public class MyAspect {
    //声明公共切入点，公共使用
    @Pointcut("execution(* cn.lynu.xy.aop.aspectjannotation.BookServiceImpl.*(..))")
    private void myPointCut(){
    }
    //前置通知,使用公共切入点
    @Before(value = "myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知"+","+"目标类方法名"+joinPoint.getSignature().getName());
    }

    //后置通知
    //@AfterReturning(value = "myPointCut()",returning = "ret")
    public void myAfterReturning(JoinPoint joinPoint, Object ret){
        System.out.println("后置通知"+","+"目标类方法名"+joinPoint.getSignature().getName()+ret);
    }
    //环绕通知
    //@Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("前方法");
        Object obj = proceedingJoinPoint.proceed(); //手动执行目标方法
        System.out.println("后方法");
        return obj;
    }
    //异常通知
    //@AfterThrowing(value = "myPointCut()",throwing = "throwable")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("目标方法方法名"+joinPoint.getSignature().getName()+","+"异常信息"+throwable.getMessage());
    }
    //最终通知，无论怎样都会执行，使用私有切入点
    //@After("execution(* cn.lynu.xy.aop.aspectjannotation.BookServiceImpl.*(..))")
    public void myAfter(JoinPoint joinPoint){
        System.out.println("最终通知"+","+"目标方法方法名"+joinPoint.getSignature().getName());
    }
}
