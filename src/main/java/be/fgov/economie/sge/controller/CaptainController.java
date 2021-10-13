package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.dto.CaptainDto;
import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import be.fgov.economie.sge.service.CaptainService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class CaptainController {
    private final CaptainService captainService;

    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }


    @GetMapping(value = "/captains2/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Captain>getCaptainByNameTest(@PathVariable("name") String name) {
        return ResponseEntity.ok(this.captainService.getCaptainByNameTest(name));
    }

    @GetMapping(value = "/captains/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CaptainDto>getCaptainByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(this.captainService.getCaptainByName(name));
    }

    @GetMapping(value = "/captains", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CaptainDto>> getCaptains() {
        return ResponseEntity.ok(this.captainService.getCaptains());
    }

}
