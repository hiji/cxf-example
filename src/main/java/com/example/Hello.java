package com.example;

import javax.jws.WebService;

@WebService
public interface Hello {

    String hello(String text);
}
