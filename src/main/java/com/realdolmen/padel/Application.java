package com.realdolmen.padel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Created by EXT487 on 28/02/2017.
 */

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //this method will be called in a container to bootstrap the application
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(Application.class);
    }




}
