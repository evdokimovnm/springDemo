package net.evdokimov.spring;


import net.evdokimov.spring.bean.User;
import net.evdokimov.spring.controllers.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserControllerExample {
    private UserController userController;

    @Before
    public void setUp() {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        this.userController = appCtx.getBean("userController", UserController.class);
    }

    @Test
    public void test() {
       userController.register("John", "password", "John@gmail.com");

       List<User> users = userController.showAll();
       for (User user : users) {
           System.out.println(user);
       }
    }



}
