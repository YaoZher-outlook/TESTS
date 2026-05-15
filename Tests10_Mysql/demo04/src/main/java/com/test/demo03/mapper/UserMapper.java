package com.test.demo03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.test.demo03.entity.User;

@Mapper
public interface UserMapper {

    User findById(int id);

    User findByName(String username);
}