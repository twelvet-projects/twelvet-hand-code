package com.twelvet.hand;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author twelvet
 */
public class IocTest {

    @Test
    public void test() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application-context.xml");
        applicationContext.refresh();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);

        }

    }

}
