package com.twelvet.hand.ioc.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 获取工具
 */
public class ClassPathXmlApplicationContext {
    /**
     * xml配置文件的路径
     */
    private String xmlPath;

    public ClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    /**
     * 获取Bean对象
     *
     * @param beanClass
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) throws Exception {
        String beanClassName = beanClass.getName();
        // 1.读取xml配置文件
        // 1.1创建xml解析器
        SAXReader saxReader = new SAXReader();
        // 1.2读取xml配置文件
        Document read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));
        // 1.3获取xml配置文件的根节点对象（<beans></beans>）
        Element rootElement = read.getRootElement();
        //1.4获取根节点中所有的子节点对象，也就是所有bean对象(<bean></bean>)
        List<Element> beanElements = rootElement.elements();
        Object obj = null;
        for (Element beanElement : beanElements) {
            // 2.使用beanId查找bean配置，并获取配置文件中class的地址(为了与参数beanId区分开，我们命名为beanElementId)
            //2.1使用beanId查找bean配置
            String beanElementClass = beanElement.attributeValue("class");
            //如果不是当前的bean，则跳出本次循环
            if (!beanClassName.equals(beanElementClass)) {
                continue;
            }
            // 2.2获取bean对应的Class地址
            String beanClassPath = beanElement.attributeValue("class");
            // 3.使用反射实例化对象
            // 3.1获取Class对象
            Class<?> cls = Class.forName(beanClassPath);
            // 3.2实例化对象
            obj = cls.newInstance();
            // 4.获取属性配置，使用反射技术进行赋值
            // 4.1获取所有属性
            List<Element> fieldElements = beanElement.elements();
            for (Element fieldElement : fieldElements) {
                String name = fieldElement.attributeValue("name");
                String value = fieldElement.attributeValue("value");
                // 4.2使用反射api为私有属性赋值
                Field declaredField = cls.getDeclaredField(name);
                //忽略访问权限修饰符的安全检查，又称为暴力反射
                declaredField.setAccessible(true);
                declaredField.set(obj, value);
            }
        }
        //返回bean对象
        return (T) obj;
    }
}
