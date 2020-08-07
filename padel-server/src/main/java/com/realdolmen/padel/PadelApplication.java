package com.realdolmen.padel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by EXT487 on 28/02/2017.
 */

@SpringBootApplication
public class PadelApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(PadelApplication.class, args);
    }


    //this method will be called in a container to bootstrap the application
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PadelApplication.class);
    }


}
