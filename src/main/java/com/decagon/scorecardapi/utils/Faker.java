package com.decagon.scorecardapi.utils;

import org.springframework.context.annotation.Bean;


public class Faker {
    @Bean
    static Faker getInstance(){
      return   new Faker();
    }
}
