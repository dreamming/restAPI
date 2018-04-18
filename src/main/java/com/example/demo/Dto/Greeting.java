package com.example.demo.Dto;

import java.io.Serializable;

public class Greeting implements Serializable {

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

    private Integer userId;
    private String content;
    private String Ssid;
}
