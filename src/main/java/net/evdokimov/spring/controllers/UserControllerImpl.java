package net.evdokimov.spring.controllers;


import net.evdokimov.spring.bean.User;
import net.evdokimov.spring.dao.UserDao;
import net.evdokimov.spring.validate.UserValidator;

import java.util.List;
import java.util.Map;

public class UserControllerImpl implements UserController {

    private UserValidator validator;
    private UserDao dao;

    public void setValidator(UserValidator validator) {
        this.validator = validator;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void register(String login, String password, String email) {
        User user = new User(login, password, email);
        Map<String, String> errorMap = validator.validate(user);
        if(errorMap.isEmpty()) {
            dao.insert(user);
            System.out.println("redirect to OK.jsp");
        } else {
            System.out.println(errorMap);
            System.out.println("redirect to ERROR.jsp");
        }
    }

    @Override
    public List<User> showAll() {
        return dao.selectAll();
    }
}
