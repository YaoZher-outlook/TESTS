package com.yaozher.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Repository
public class UserDao {

    public String readRaw() {
        try {
            ClassPathResource res = new ClassPathResource("user.txt");
            try (InputStream is = res.getInputStream()) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            // 返回空数组 JSON，Service 负责解析容错
            return "[]";
        }
    }
}
