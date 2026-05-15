package com.p.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.p.entity.Dept;

@Mapper
public interface DeptMapper {
    @Select("SELECT id, name, create_time AS createTime, update_time AS updateTime FROM dept ORDER BY update_time DESC")
    public List<Dept> findAll();
}
