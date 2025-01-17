package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getHelloWorld() {
        String url = "http://localhost:8080/hello"; // First application's endpoint
        return restTemplate.getForObject(url, String.class);
    }
}
