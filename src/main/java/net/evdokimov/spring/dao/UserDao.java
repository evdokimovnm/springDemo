package net.evdokimov.spring.dao;


import net.evdokimov.spring.bean.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    List<User> selectAll();

}
