package com.jpa.service;

import com.jpa.DAO.JPADAO;
import com.jpa.entity.User;

import java.util.Optional;

public class UserService extends JPADAO<User> {

    public User join(User user){
        return create(user);
    }

    public Optional<User> findById(User user){
        return find(User.class,user.getId());
    }

}
