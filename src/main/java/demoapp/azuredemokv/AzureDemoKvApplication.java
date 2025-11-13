package demoapp.azuredemokv;

import demoapp.azuredemokv.properties.TestProperties;
import demoapp.azuredemokv.properties.TestPropertyEnv;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class AzureDemoKvApplication {
    private final TestPropertyEnv testPropertyEnv;
    private final TestProperties testProperties;

    public static void main(String[] args) {
        SpringApplication.run(AzureDemoKvApplication.class, args);
    }

    @PostConstruct
    public void logSecret() {
        log.info("Secret from KV = {}", testPropertyEnv.getSecret());
        log.info("Secret name = {}", testProperties.getName());
    }
}
