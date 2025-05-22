package nym.nym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NymApplication {

    public static void main(String[] args) {
        SpringApplication.run(NymApplication.class, args);
    }

}
