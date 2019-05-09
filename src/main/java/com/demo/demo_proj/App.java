package com.demo.demo_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.demo.demo_proj"})
@SpringBootApplication
public class App 
{
    public static void main( String[] args )  {
    	SpringApplication.run(App.class, args);
    }
}
