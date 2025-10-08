package com.example.apieta.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

@Service
public class CodiceFiscaleService {

    private static final Map<Character, Integer> MESE_MAP = Map.ofEntries(
            Map.entry('A', 1), Map.entry('B', 2), Map.entry('C', 3),
            Map.entry('D', 4), Map.entry('E', 5), Map.entry('H', 6),
            Map.entry('L', 7), Map.entry('M', 8), Map.entry('P', 9),
            Map.entry('R', 10), Map.entry('S', 11), Map.entry('T', 12)
    );

    public LocalDate estraiDataNascita(String cf) {
        if (cf == null) throw new IllegalArgumentException("Codice fiscale nullo");
        String cfTrim = cf.trim().toUpperCase();
        if (cfTrim.length() < 11) {
            throw new IllegalArgumentException("Inserire almeno 11 caratteri");
        }
        if (cfTrim.length() > 16) {
            throw new IllegalArgumentException("Inserire al massimo 16 caratteri");
        }

        String annoStr = cfTrim.substring(6, 8);
        char meseChar = cfTrim.charAt(8);
        String giornoStr = cfTrim.substring(9, 11);

        int anno = Integer.parseInt(annoStr) + 1900;
        Integer mese = MESE_MAP.get(meseChar);
        if (mese == null) throw new IllegalArgumentException("Mese non valido: " + meseChar + ". Inserire una lettera tra A e T al posto di " + meseChar);

        int giorno = Integer.parseInt(giornoStr);
        if (giorno > 40) {
            giorno -= 40;
        }

        return LocalDate.of(anno, mese, giorno);
    }

    public int calcolaEta(LocalDate dataNascita) {
        if (dataNascita == null) throw new IllegalArgumentException("Data di nascita nulla");
        return Period.between(dataNascita, LocalDate.now()).getYears();
    }
}