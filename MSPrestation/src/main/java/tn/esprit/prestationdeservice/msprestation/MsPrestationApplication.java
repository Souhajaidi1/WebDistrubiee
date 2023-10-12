package tn.esprit.prestationdeservice.msprestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsPrestationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPrestationApplication.class, args);
    }

}
