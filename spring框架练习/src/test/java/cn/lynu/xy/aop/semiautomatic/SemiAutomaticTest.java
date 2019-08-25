package cn.lynu.xy.aop.semiautomatic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SemiAutomaticTest {

    @Test
    public void test() {
        String xmlPath = "aop-semi-automatic.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //proxyService：代理对象，因为这里的代理对象将目标对象和通知对象融合了
        UserService proxyService = applicationContext.getBean("proxyService", UserService.class);
        proxyService.addUser();
        proxyService.updateUser();
        proxyService.delUser();
    }
}