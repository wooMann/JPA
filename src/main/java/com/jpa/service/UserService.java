package com.jpa.service;

import com.jpa.DAO.JPADAO;
import com.jpa.entity.User;

public class UserService extends JPADAO<User> {

    public User join(User user){
        return create(user);
    }

}
