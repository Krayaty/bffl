package org.bffl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={"org.bffl"})
public class Start extends SpringBootServletInitializer {

    public static void main(String[] args) { SpringApplication.run(Start.class, args); }

}
