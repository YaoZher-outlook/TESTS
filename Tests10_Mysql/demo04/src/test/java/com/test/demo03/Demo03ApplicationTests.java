package com.test.demo03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.demo03.entity.User;
import com.test.demo03.mapper.UserMapper;

@SpringBootTest
class Demo03ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
    private UserMapper userMapper;

    @Test
    void testFindById() {
        User user = userMapper.findById(1);
        if (user != null) {
            System.out.println("Connected, found user with username: " + user.getUsername());
        } else {
            System.out.println("Connected, but no user found with id 1.");
        }
    }

    @Test
    void testQuery() {
        User user = userMapper.findByName("jiang_yunyao");
        System.out.println("query result: " + user);
    }
}
