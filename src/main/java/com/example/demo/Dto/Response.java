package com.example.demo.Dto;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private List<Greeting> greetings;
    private String link;

    public List<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(List<Greeting> greetings) {
        this.greetings = greetings;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
