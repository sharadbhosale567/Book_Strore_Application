package com.bridgelabz.bookstoreapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {

        SpringApplication.run(BookStoreApplication.class, args);
        System.out.println("Welcome To Book Store Application....");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
