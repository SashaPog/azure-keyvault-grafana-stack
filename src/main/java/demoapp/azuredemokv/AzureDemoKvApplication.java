package demoapp.azuredemokv;

import demoapp.azuredemokv.properties.TestProperties;
import demoapp.azuredemokv.properties.TestPropertyEnv;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class AzureDemoKvApplication {
//    @Autowired
//    private Environment env;
//    private final TestProperties testProperties;
    private final TestPropertyEnv testPropertyEnv;
//    @Value("${greencity.secret.name}")
//    private String secretName;

    public static void main(String[] args) {
        SpringApplication.run(AzureDemoKvApplication.class, args);
    }

    @Scheduled(fixedRate = 3000)
    public void logSecret() {
        log.info("Secret from KV = {}", testPropertyEnv.getSecret());
    }
}
