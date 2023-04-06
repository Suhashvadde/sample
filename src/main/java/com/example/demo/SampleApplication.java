package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.respository.MovieRepository;

@SpringBootApplication
public class SampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
