package net.evdokimov.spring.validate;


import net.evdokimov.spring.bean.User;

import java.util.Map;

public interface UserValidator {
    Map<String, String> validate(User user);
}
