package com.example.apieta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CodiceFiscaleResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascita;
    private int eta;

    public CodiceFiscaleResponse() {}

    public CodiceFiscaleResponse(LocalDate dataNascita, int eta) {
        this.dataNascita = dataNascita;
        this.eta = eta;
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