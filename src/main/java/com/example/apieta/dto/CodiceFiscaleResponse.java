package com.example.apieta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CodiceFiscaleResponse {
    private String codiceFiscale;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascita;
    private int eta;

    public CodiceFiscaleResponse() {}

    public CodiceFiscaleResponse(String codiceFiscale, LocalDate dataNascita, int eta) {
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
        this.eta = eta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
