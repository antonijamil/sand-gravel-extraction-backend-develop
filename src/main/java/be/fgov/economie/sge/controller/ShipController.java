package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.Ship;
import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import be.fgov.economie.sge.model.dto.ShipDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import be.fgov.economie.sge.service.ShipService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipController {
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping(value = "/ships", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseDto<ShipDto>> getShips() {
        return ResponseEntity.ok(this.shipService.getShips());
    }

    @GetMapping(value = "/ship/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShipDto> getShip(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(this.shipService.getShipById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
