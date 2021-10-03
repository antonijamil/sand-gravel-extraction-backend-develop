package be.fgov.economie.sge.service;

import be.fgov.economie.sge.model.dto.UnloadingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnloadingServiceTest {
    @Autowired
    UnloadingService unloadingService;
    @Test
    void getUnloadings() {
        Iterable<UnloadingDto> unloadings = unloadingService.getUnloadings();
    }
}
