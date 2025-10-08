package com.example.apieta.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apieta.dto.CodiceFiscaleResponse;
import com.example.apieta.service.CodiceFiscaleService;

@RestController
@RequestMapping("/api/codice-fiscale")
public class CodiceFiscaleController {

    private final CodiceFiscaleService service;

    public CodiceFiscaleController(CodiceFiscaleService service) {
        this.service = service;
    }

    @GetMapping("/{cf}")
    public ResponseEntity<?> getInfo(
            @PathVariable("cf")
            String cf) {
        try {
            LocalDate data = service.estraiDataNascita(cf);
            int eta = service.calcolaEta(data);
            var resp = new CodiceFiscaleResponse(data, eta);
            return ResponseEntity.ok(resp);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(java.util.Map.of("error", "Errore 500"));
        }
    }
}