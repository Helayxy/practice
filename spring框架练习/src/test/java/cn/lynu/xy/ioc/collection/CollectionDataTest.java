package cn.lynu.xy.ioc.collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionDataTest {
    @Test
    public void test(){
        String xmlPath= "collection.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        CollectionData collectionData = applicationContext.getBean("collectionData", CollectionData.class);
        System.out.println(collectionData);
    }
}