package bali.balisurvey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BaliSurveyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaliSurveyApplication.class, args);
    }

}
