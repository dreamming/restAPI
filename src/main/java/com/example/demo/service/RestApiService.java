package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestApiService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUser() {

        return userMapper.selectAll();
    }
}
