package com.dwes.adictosalfutbol;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ApostaServicio {

    public List<Aposta> getApostes() {
        List<Aposta> apostes = new ArrayList<>();
        apostes.add(new Aposta(1, "Joel Espadas", "UE Sant Andreu - Betis", 0, 4, LocalDate.parse("2024-12-12"), 150));
        apostes.add(new Aposta(2, "Joel Jara", "CD Europa - UD Las Palmas", 1, 3, LocalDate.parse("2024-12-12"), 60));
        apostes.add(new Aposta(3, "Eric Sáez", "UD Barbastro - RCD Espanyol", 0, 6, LocalDate.parse("2024-12-13"), 23));
        return apostes;
    }

    public Aposta getAposta(int id) {
        Aposta aposta = null;
        switch (id) {
            case 1:
                aposta = new Aposta();
                break;
            case 2:
                aposta = new Aposta();
                break;
            case 3:
                aposta = new Aposta();
                break;
        }
        return aposta;
    }
}
