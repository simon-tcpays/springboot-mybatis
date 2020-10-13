package com.example.demoforuniapp.mapper;

import com.example.demoforuniapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: simon
 * @Date: 2020/10/13 12:59
 */
@Mapper
public interface UserMapper {
    /**
     * 返回一个User对象
     * @param username
     * @return
     */
    User findByUsername(String username);
}
