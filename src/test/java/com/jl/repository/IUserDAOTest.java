package com.jl.repository;

import com.jl.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
class IUserDAOTest {
    @Autowired
    IUserDAO dao;

    @Test
    void add() {
    }

    @Test
    void findOne() {
        User user=new User();
        user.setUname("jl");
        user.setUpwd("a");
        user=dao.findOne(user);
        System.out.println(user);
    }

    @Test
    void updateUser() {
    }

    @Test
    void findMany() {
    }
}