package com.bespokedbikes;

import com.bespokedbikes.controller.AplicationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeSpokedBikesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BeSpokedBikesApplication.class, args);
        AplicationController bean = run.getBean(AplicationController.class);
        bean.commandLoop();
    }
}
