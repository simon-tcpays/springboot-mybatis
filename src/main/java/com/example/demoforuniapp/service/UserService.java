package  com.example.demoforuniapp.service;

import com.example.demoforuniapp.entity.User;
import com.example.demoforuniapp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: simon
 * @Date: 2020/10/13 12:59
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findOne(String username){
        return userMapper.findByUsername(username);
    }
}
