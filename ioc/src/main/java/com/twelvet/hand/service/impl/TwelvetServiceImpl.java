package com.twelvet.hand.service.impl;

import com.twelvet.hand.service.TwelvetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author twelvet
 * <p>
 * 测试服务层注入
 */
@Service
public class TwelvetServiceImpl implements TwelvetService {

    private static final Logger log = LoggerFactory.getLogger(TwelvetServiceImpl.class);

    @Override
    public void say() {

        log.info("成功使用IOC访问");

    }
}
