package demoapp.azuredemokv.properties;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestPropertyEnv {
    private final Environment env;

    @PostConstruct
    public void validateProperty() {
        getSecret();
        log.info("Validating property successfully");
    }

    public String getSecret() {
        String s = env.getProperty("greencity.keyvault.secret");
        if (s == null || s.isBlank()) {
            log.warn("secret missing, fallback to default");
            throw new IllegalArgumentException("secret missing, fallback to default");
        }
        return s;
    }
}
