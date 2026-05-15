package com.p.controller;

import org.springframework.web.bind.annotation.RestController;

import com.p.entity.Dept;
import com.p.entity.Result;
import com.p.service.DeptService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public Result list() {
        System.out.println("Querying all departments...");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }
    
}
