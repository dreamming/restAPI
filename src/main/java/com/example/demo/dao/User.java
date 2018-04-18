package com.example.demo.dao;

import com.example.demo.domain.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;


@Repository
public class User implements IUser {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserDocument userDocument) {
        mongoTemplate.save(userDocument);
    }

    @Override
    public List<UserDocument> getUserByAny(String name, String value) {

        Query query;
        if (value.startsWith("*") || value.endsWith("*")) {
            StringBuffer buffer = new StringBuffer(value);
            buffer = buffer.insert(0, "^");
            buffer = buffer.insert(buffer.length(), "$");
            int index = buffer.indexOf("*");
            buffer = buffer.insert(index, ".");
            Pattern pattern = Pattern.compile(buffer.toString(), Pattern.CASE_INSENSITIVE);
            query = new Query(Criteria.where(name).regex(pattern));

        } else {

            query = new Query(Criteria.where(name).is(value));

        }

        List<UserDocument> users = mongoTemplate.find(query, UserDocument.class);
        return users;

    }

    @Override
    public List<UserDocument> getUsers() {
        List<UserDocument> users = mongoTemplate.findAll(UserDocument.class);
        return users;
    }
}
