package demoapp.azuredemokv;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
@RequiredArgsConstructor
@Getter
@Slf4j
public class KeyVaultAutoconfiguredClient {
    @Value("${greencity.keyvault.secret}")
    private String secretValue;
    @Value("${greencity.secret.name}")
    private String secretName;
}

