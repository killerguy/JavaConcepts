package com.mukul.utility;


import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppBeanFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    public static <T> T getBean(Class<T> clazz) {
        if (context != null)
            return context.getBean(clazz);
        return null;
    }

    public static <T> T getBean(Class<T> clazz, String className) {
        if (context != null) {
            try {
                return clazz.cast(context.getBean(className));
            } catch (NoSuchBeanDefinitionException e) {
                throw new StellarBeanFactoryException(e);
            }
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        AppBeanFactory.context = context;
    }

    public static class StellarBeanFactoryException extends RuntimeException {
        public StellarBeanFactoryException(Exception e) {
            super(e);
        }
    }
}
