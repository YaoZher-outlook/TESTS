package com.yaozher.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String gender;
    private String hireDate;
    private String position;
    private String phone;
    private String avatar;
    private String status;
}
