package tn.esprit.partenariatms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PartenariatMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartenariatMsApplication.class, args);
	}

}
