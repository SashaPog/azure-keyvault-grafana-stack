package demoapp.azuredemokv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AzureDemoKvApplication {
    public static void main(String[] args) {
        SpringApplication.run(AzureDemoKvApplication.class, args);
    }
}
