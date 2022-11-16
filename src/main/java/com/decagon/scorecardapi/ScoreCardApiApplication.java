package com.decagon.scorecardapi;

import com.btmatthews.springboot.memcached.EnableMemcached;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableMemcached
public class ScoreCardApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreCardApiApplication.class, args);
    }


}
