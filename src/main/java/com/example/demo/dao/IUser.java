package com.example.demo.dao;

import com.example.demo.domain.UserDocument;

import java.util.List;

public interface IUser {

    void saveUser(UserDocument userDocument);

    List<UserDocument> getUserByAny(String name, String value);

    List<UserDocument> getUsers();





}
