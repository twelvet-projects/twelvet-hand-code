package com.twelvet.hand;

import com.twelvet.hand.annotation.Autowired;
import com.twelvet.hand.service.TwelvetService;
import com.twelvet.hand.service.impl.TwelvetServiceImpl;
import com.twelvet.hand.utils.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        TwelvetServiceImpl bean = application.getBean(TwelvetService.class);
        log.info("User：{}", bean);
    }

}
