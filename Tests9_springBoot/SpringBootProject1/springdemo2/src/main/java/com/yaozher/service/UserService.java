package com.yaozher.service;

import com.yaozher.pojo.User;
import com.yaozher.dao.UserDao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ObjectMapper objectMapper;

    public List<User> listUsers() {
        String raw = userDao.readRaw();
        try {
            return objectMapper.readValue(raw, new TypeReference<List<User>>() {});
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
