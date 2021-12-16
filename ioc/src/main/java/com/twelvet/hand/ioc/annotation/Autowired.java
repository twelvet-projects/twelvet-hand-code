package com.twelvet.hand.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author twelvet
 * <p>
 * 自动装配注解(注解解析：https://www.twelvet.cn/news/12.html)
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    /**
     * 是否依赖
     *
     * @return
     */
    boolean required() default true;

}
