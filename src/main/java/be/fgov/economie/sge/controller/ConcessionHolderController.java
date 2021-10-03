package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import be.fgov.economie.sge.service.ConcessionHolderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcessionHolderController {
    private final ConcessionHolderService concessionHolderService;

    public ConcessionHolderController(ConcessionHolderService concessionHolderService) {
        this.concessionHolderService = concessionHolderService;
    }

    @GetMapping(value = "/concession-holders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseDto<ConcessionHolderDto>> getConcessionHolders() {
        return ResponseEntity.ok(this.concessionHolderService.getConcessionHolders());
    }

}
