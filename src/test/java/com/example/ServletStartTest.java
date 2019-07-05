package com.example;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class ServletStartTest {

    @Test
    void start() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        StandardContext ctx = (StandardContext) tomcat.addWebapp(
                "/",
                new File("src/main/webapp").getAbsolutePath());

        tomcat.getConnector();
        tomcat.start();

        // START SNIPPET: client
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "test-beans.xml" });

        Hello client = (Hello) context.getBean("helloClient");

        String response = client.hello("Hoge");
        System.out.println("Response: " + response);

        tomcat.stop();
    }
}
