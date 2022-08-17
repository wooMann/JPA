package com.jpa.service;

import com.jpa.entity.User;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    public void userJoinSuccess(){
        User user = new User();
        user.setEmail("woo@naver.com");
        user.setPassword("123");
        user.setName("우광우");
        User result =  userService.join(user);
        assertEquals(User.class,user.getClass());
        assertEquals(user,result);
    }

    @Test
    public void userJoinFail(){
        User user = new User();
        user.setEmail("woo@naver.com");

        user.setName("우광우fail");
        User result =  userService.join(user);
        assertEquals(User.class,user.getClass());
        assertEquals(user,result);
    }

    @Test
    public void findByIdSuccess(){
        User user = new User();
        user.setId(1);
        Optional<User> result = userService.findById(user);
        assertTrue(result.isPresent());
    }

    @Test
    public void findByIdFail(){
        User user = new User();
        user.setId(5565);
        Optional<User> result = userService.findById(user);
        assertFalse(result.isPresent());
    }




}