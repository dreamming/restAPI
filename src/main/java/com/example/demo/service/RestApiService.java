package com.example.demo.service;

import com.example.demo.Dto.Greeting;
import com.example.demo.dao.IUser;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.domain.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestApiService {

    @Autowired
    private IUser user;

    @Autowired
    private UserMapper userMapper;

    public List<Greeting> getUserByAny(String contents) {
        String[] el = contents.split("==");
        List<UserDocument> users = user.getUserByAny(el[0], el[1]);
        List<Greeting> userList = new ArrayList<>();
        for (UserDocument uDocument : users) {
            Greeting user = new Greeting();
            user.setUserId(uDocument.getUserId());
            user.setContent(uDocument.getContent());
            user.setSsid(uDocument.getSsid());
            userList.add(user);
        }

        return userList;
    }

    public List<Greeting> getAllUsers() {
        List<UserDocument> userDocument = user.getUsers();
        List<Greeting> userList = new ArrayList<>();
        for (UserDocument uDocument : userDocument) {
            Greeting user = new Greeting();
            user.setUserId(uDocument.getUserId());
            user.setContent(uDocument.getContent());
            user.setSsid(uDocument.getSsid());
            userList.add(user);
            }
        return userList;
    }

    public List<User> getUser() {

        return userMapper.selectAll();
    }


}
