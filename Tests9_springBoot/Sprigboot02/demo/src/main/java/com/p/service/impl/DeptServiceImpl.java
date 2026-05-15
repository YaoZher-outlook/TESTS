package com.p.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.entity.Dept;
import com.p.mapper.DeptMapper;
import com.p.service.DeptService;


@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
