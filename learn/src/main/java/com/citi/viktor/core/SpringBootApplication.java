package com.citi.viktor.core;


//help add  the springboot application annotation
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//add the springboot application annotation  which  helps in the creation of the springboot application
@SpringBootApplication
public class SpringBootApplication {
    //initialize the class  as  the  SpringBootApplication class
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
