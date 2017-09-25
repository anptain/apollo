package com.xairball.apollo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommonBeanFactory implements ApplicationContextAware {

    protected static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext1) throws BeansException {
        applicationContext = applicationContext1;
    }

    public static <T> T getBean(Class<T> clzz) {
        return applicationContext.getBean(clzz);
    }

    public static <T> T getBean(String clzzName, Class<T> clzz) {
        return applicationContext.getBean(clzzName, clzz);
    }

    public static <T> T getBean(String name) {
        return (T)applicationContext.getBean(name);
    }

}
