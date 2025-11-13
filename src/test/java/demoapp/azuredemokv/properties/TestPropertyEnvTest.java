package demoapp.azuredemokv.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestPropertyEnvTest {

    @Mock
    private Environment environment;

    @InjectMocks
    private TestPropertyEnv testPropertyEnv;

    @Test
    void getSecret_returnsSecret_whenPropertyExists() {
        when(environment.getProperty("greencity.keyvault.secret"))
            .thenReturn("superSecret");

        String result = testPropertyEnv.getSecret();

        assertEquals("superSecret", result);
        verify(environment).getProperty("greencity.keyvault.secret");
    }

    @Test
    void getSecret_throwsException_whenPropertyMissing() {
        when(environment.getProperty("greencity.keyvault.secret"))
            .thenReturn(null);

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> testPropertyEnv.getSecret()
        );
        assertEquals("secret missing, fallback to default", ex.getMessage());
    }

    @Test
    void getSecret_throwsException_whenPropertyBlank() {
        when(environment.getProperty("greencity.keyvault.secret"))
            .thenReturn("   ");

        assertThrows(IllegalArgumentException.class, () -> testPropertyEnv.getSecret());
    }

    @Test
    void validateProperty_logsInfo_whenSecretExists() {
        when(environment.getProperty("greencity.keyvault.secret"))
            .thenReturn("validSecret");

        testPropertyEnv.validateProperty();

        verify(environment).getProperty("greencity.keyvault.secret");
    }

    @Test
    void validateProperty_throwsException_whenSecretMissing() {
        when(environment.getProperty("greencity.keyvault.secret"))
            .thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> testPropertyEnv.validateProperty());
        verify(environment).getProperty("greencity.keyvault.secret");
    }
}