package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "greetings")
public class UserDocument {

    private Integer userId;

    private String content;

    private String Ssid;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSsid() {
        return Ssid;
    }

    public void setSsid(String ssid) {
        Ssid = ssid;
    }


}
