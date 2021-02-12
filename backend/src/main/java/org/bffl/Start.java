package org.bffl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.bffl"})
public class Start {

    public static void main(String[] args) {

        SpringApplication.run(Start.class, args);

    }

}
