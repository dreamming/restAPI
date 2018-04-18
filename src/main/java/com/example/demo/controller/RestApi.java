package com.example.demo.controller;

import com.example.demo.Dto.Greeting;
import com.example.demo.Dto.Response;
import com.example.demo.domain.User;
import com.example.demo.service.RestApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/restApi")
public class RestApi {

    private static final Logger logger = LoggerFactory.getLogger(RestApi.class);

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
    public Response getGreeting(@RequestParam(value = "where", required = false) String where,
                                @RequestParam(value = "action", required = false) String action) {

        Response response = new Response();
        List<Greeting> greetings = null;
        if (action == null) {
            greetings = restApiService.getAllUsers();

        }
        switch (action) {
            case "search": greetings = restApiService.getUserByAny(where);
        }

        response.setGreetings(greetings);

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        response.setLink(uri);

        return response;

    }
}
