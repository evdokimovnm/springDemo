package net.evdokimov.spring.controllers;


import net.evdokimov.spring.bean.User;

import java.util.List;

public interface UserController {

    void register(String login, String password, String email);
    List<User> showAll();
}
