package be.fgov.economie.sge.service;

import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import be.fgov.economie.sge.model.dto.ShipDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipServiceTest {
    @Autowired
    ShipService shipService;
    @Test
    void getShips() {
        SimpleResponseDto<ShipDto> shipsIterable = shipService.getShips();
    }

    void getShipById(Integer id) {
        ShipDto shipDto = shipService.getShipById(id);
    }
}
