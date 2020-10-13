package com.example.demoforuniapp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: simon
 * @Date: 2020/10/13 12:59
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;
}
