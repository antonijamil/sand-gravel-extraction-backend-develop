package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import be.fgov.economie.sge.model.dto.response.RegisterEntryResponseDto;
import be.fgov.economie.sge.service.RegisterEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class RegisterEntryController {

    private final RegisterEntryService registerEntryService;
    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_SORT_ORDER = "tripNumber";

    @Autowired
    public RegisterEntryController(RegisterEntryService registerEntryService) {
        this.registerEntryService = registerEntryService;
    }

    @GetMapping(value = "/register-entries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterEntryDto> getRegisterEntry(@PathVariable("id") Integer id
    ) throws ResponseStatusException {
        RegisterEntryDto result = registerEntryService.getRegisterEntryById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/register-entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterEntryResponseDto> getAllRegisterEntries(

            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT_ORDER) String sort,

            @RequestParam(value = "id", required = false) Integer registerEntryId,
            @RequestParam(value = "tripNumber", required = false) Long tripNumber,
            @RequestParam(value = "shipId", required = false) Integer shipId,
            @RequestParam(value = "concessionHolderNumber", required = false) Integer concessionHolderNumber,
            @RequestParam(value = "loadingSiteId", required = false) Integer loadingSiteId,
            @RequestParam(value = "startDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(value = "stopDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime stopDateTime,
            @RequestParam(value = "loadedQuantity", required = false) Integer quantity,
            @RequestParam(value = "deviantVolume", required = false) String deviantVolume,
            @RequestParam(value = "destinationCountry", required = false) String destinationCountry,
            @RequestParam(value = "destination", required = false) String destination,
            Principal principal

    ) {

        RegisterEntryResponseDto response = registerEntryService.getRegisterEntriesByParams(registerEntryId,
                tripNumber, shipId, principal.getName(), concessionHolderNumber, loadingSiteId, startDateTime,
                stopDateTime,
                quantity, deviantVolume, destination, destinationCountry,  page, pageSize, sort);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register-entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterEntryDto> saveRegisterEntry(@RequestBody RegisterEntryDto registerEntryDto) {
        RegisterEntryDto createdRegisterEntryDto = registerEntryService.saveRegisterEntry(registerEntryDto);
        return ResponseEntity.ok(createdRegisterEntryDto);

    }

}


