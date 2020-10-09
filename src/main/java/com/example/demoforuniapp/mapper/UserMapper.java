package com.example.demoforuniapp.mapper;

import com.example.demoforuniapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
