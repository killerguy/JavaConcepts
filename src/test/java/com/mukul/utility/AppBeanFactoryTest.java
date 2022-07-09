package com.mukul.utility;

import com.mukul.java8features.lambdas.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppBeanFactoryTest {
    private ApplicationContext mockApplicationContext;
    private AppBeanFactory beanFactory;

    @Before
    public void setUp() {
        beanFactory = new AppBeanFactory();
        mockApplicationContext = mock(ApplicationContext.class);
        beanFactory.setApplicationContext(mockApplicationContext);
    }

    @Test
    public void shouldReturnBean() {
        Employee mockEmployee = mock(Employee.class);
        when(mockApplicationContext.getBean(Employee.class)).thenReturn(mockEmployee);
        assertEquals(AppBeanFactory.getBean(Employee.class), mockEmployee);
    }

    @Test
    public void shouldReturnsNullWithNoApplicationContext() {
        beanFactory.setApplicationContext(null);
        assertNull(AppBeanFactory.getBean(Employee.class));
    }

    @Test
    public void shouldReturnsBeanOnName() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerPrototype("Employee", Employee.class);

        beanFactory.setApplicationContext(applicationContext);

        assertThat(AppBeanFactory.getBean(Employee.class, "Employee"), any(Employee.class));
    }

    @Test(expected = AppBeanFactory.BeanFactoryException.class)
    public void shouldThrowsExceptionOnNameNotFound() {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerPrototype("Employee", Employee.class);

        beanFactory.setApplicationContext(applicationContext);

        AppBeanFactory.getBean(Employee.class, "something");
    }

    @Test
    public void shouldReturnsNullOnContextNotInitialized() {
        beanFactory.setApplicationContext(null);
        AppBeanFactory.getBean(Employee.class, "something");
    }

    @After
    public void tearDown() {
        mockApplicationContext = mock(ApplicationContext.class);
        beanFactory.setApplicationContext(mockApplicationContext);
    }
}
