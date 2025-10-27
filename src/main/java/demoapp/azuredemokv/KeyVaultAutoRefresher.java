package demoapp.azuredemokv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeyVaultAutoRefresher {
    private ContextRefresher refresher;

    @Autowired
    public void setRefresher(@Qualifier("configDataContextRefresher") ContextRefresher refresher) {
        this.refresher = refresher;
    }

    @Scheduled(fixedRate = 10000)
    public void autoRefresh() {
        refresher.refresh();
        log.info("Context refreshed successfully.");
    }
}
