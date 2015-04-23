package net.evdokimov.spring.dao;

import net.evdokimov.spring.bean.User;


import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements org.springframework.jdbc.core.RowMapper<net.evdokimov.spring.bean.User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getString("login"), rs.getString("password"), rs.getString("email"));
    }
}
