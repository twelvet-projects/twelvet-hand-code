package com.twelvet.hand.ioc;

import com.twelvet.hand.ioc.service.TwelvetService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Application.class);
        applicationContext.refresh();
        TwelvetService bean = applicationContext.getBean(TwelvetService.class);
        bean.say();

    }

}
