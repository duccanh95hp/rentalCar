package com.example.rentalcar;

import com.example.rentalcar.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class RentalCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalCarApplication.class, args);
    }

}
