package demoapp.azuredemokv.properties;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestPropertyEnv {
    @Autowired
    private Environment env;

    public String getSecret() {
        String s = env.getProperty("greencity.keyvault.secret");
        if (s == null || s.isBlank()) {
            log.warn("secret missing, fallback to default");
            return "default-secret";
        }
        return s;
    }
}
