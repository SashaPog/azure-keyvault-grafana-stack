package demoapp.azuredemokv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrintSheduler {
    private final KeyVaultAutoconfiguredClient client;

    @Scheduled(fixedRate = 5000)
    public void shaduledSecret() {
        log.info("secret, {}", client.getSecretValue());
//        log.info("Secret name = {}", secretName);
    }
}
