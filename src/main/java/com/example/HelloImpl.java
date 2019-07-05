package com.example;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.Hello")
public class HelloImpl implements Hello {

    @Override
    public String hello(String text) {
        System.out.println("hello called");
        return "Hello " + text;
    }
}
