package com.twelvet.hand;

import com.twelvet.hand.ioc.annotation.Autowired;
import com.twelvet.hand.ioc.service.TwelvetService;
import com.twelvet.hand.ioc.service.impl.TwelvetServiceImpl;
import com.twelvet.hand.ioc.utils.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author twelvet
 */
public class SpringIocTest {

    @Autowired
    private TwelvetService twelvetService;

    private static final Logger log = LoggerFactory.getLogger(SpringIocTest.class);

    @Test
    public void testXml() throws Exception {

        //读取User的XML配置文件
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("Application-context.xml");
        //获取User的Bean对象
        TwelvetService bean = application.getBean(TwelvetServiceImpl.class);
        bean.say();


        Map<String, Object> map = new HashMap<>();

    }

}
