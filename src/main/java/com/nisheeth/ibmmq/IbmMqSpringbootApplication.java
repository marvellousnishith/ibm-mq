package com.nisheeth.ibmmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJms
@SpringBootApplication
@EnableScheduling
public class IbmMqSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbmMqSpringbootApplication.class, args);
    }

}
