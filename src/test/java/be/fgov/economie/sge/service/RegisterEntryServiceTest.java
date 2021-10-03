package be.fgov.economie.sge.service;

import be.fgov.economie.sge.model.RegisterEntry;
import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RegisterEntryServiceTest {
    @Autowired
    RegisterEntryService registerEntryService;
    @Test
    void getRegisterEntries() {

        //Iterable<RegisterEntryDto> registerEntriesIterable = registerEntryService.getRegisterEntries();

    }
}
