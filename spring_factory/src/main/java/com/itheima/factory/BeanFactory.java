package com.itheima.factory;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangzeya
 * @create 2020-08-04 14:31:00
 * 一个创建bean对象的工厂
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取Properties流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化Properties失败");
        }
    }

    /**
     *
     * @param beanName
     * @return
     */
    public static getBean(String beanName){
        Object bean=null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }

        return bean;
    }
}
