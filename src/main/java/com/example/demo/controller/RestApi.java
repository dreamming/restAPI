package com.example.demo.controller;

import com.example.demo.Dto.Greeting;
import com.example.demo.domain.User;
import com.example.demo.service.RestApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/restApi")
public class RestApi {

    @Resource
    private RestApiService restApiService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/getUsers")
    public List<User> getUsers() {
        return restApiService.getUser();
    }

    @RequestMapping(value = "/greetings")
    public List<Greeting> getGreeting(@RequestParam(value = "where", required = false) String where,
                                      @RequestParam(value = "action", required = false) String action) {

        if (action == null) {
            return restApiService.getAllUsers();

        }
        switch (action) {
            case "search":
                return restApiService.getUserByAny(where);
        }

        return null;

    }
}
