package com.mysqltest.demo01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mysqltest.demo01.mapper.UserMapper;
import com.mysqltest.demo01.entity.User;

@SpringBootTest
public class Demo01ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testFindById() {
        // 调用 mapper 方法
        User user = userMapper.findById(1L);

        // 打印结果
        if (user != null) {
            System.out.println("连接成功，查询到的用户名: " + user.getUsername());
        } else {
            System.out.println("连接成功，但未找到数据");
        }
    }
}