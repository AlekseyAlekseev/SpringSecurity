package ru.netology;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringSecurityApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
