package cn.lynu.xy.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
    public static UserService createUserService() {
        UserService userService = new UserServiceImpl(); //1.目标类
        MyAspect myAspect = new MyAspect();//2.切面类
        //3.代理类（proxService对象）
        /*
         * 3.代理类：将目标类（切入点）和切面类（通知）结合-->切面
         * 参数1：loader：类加载器，动态代理类运行时创建，任何类都需要类加载器将其加载到内存中
         *        一般写法：当前类.class.getClassLoader();
         *        其他写法：目标实例.getClass().get...
         * 参数2：interfaces：代理对象需要实现的所有接口
         *        写法1：目标实例.getClass().getInterfaces()；注意，只能获得自己的接口，不能获得父类接口
         *        写法2：new Class[]{目标类.class}
         * 参数3：InvocationHandler：处理类，是一个接口，需要实现类，实现类一般采用匿名内部类
         *        该处理类提供invoke()方法，该方法有3个参数：
         *        参数1：proxy：代理对象
         *        参数2：method：代理对象当前执行的方法的描述对象（反射知识）
         *               获得方法名：method.getName()
         *               执行方法：method.invoke（对象，实际参数）
         *        参数3：args：方法的实际参数
         * */
        UserService proxService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前执行的方法
                        myAspect.before();
                        //执行目标类的方法
                        Object obj = method.invoke(userService);
                        //后执行的方法
                        myAspect.after();
                        return obj;
                    }
                });
        return proxService;
    }


}
