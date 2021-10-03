package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import be.fgov.economie.sge.model.dto.LoadingSiteDto;
import be.fgov.economie.sge.service.ConcessionHolderService;
import be.fgov.economie.sge.service.LoadingSiteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadingSiteController {
    private final LoadingSiteService loadingSiteService;

    public LoadingSiteController(LoadingSiteService loadingSiteService) {
        this.loadingSiteService = loadingSiteService;
    }

    @GetMapping(value = "/loading-sites", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<LoadingSiteDto>> getLoadingSites() {
        return ResponseEntity.ok(this.loadingSiteService.getLoadingSites());
    }
}
