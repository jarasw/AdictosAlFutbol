package com.dwes.adictosalfutbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApostaServicio {

    private static ApostaServicio instance;
    private List<Aposta> apostes;

    ApostaServicio() {
        apostes = new ArrayList<>();
        apostes.add(new Aposta(1, "Joan", "Madrid vs Betis","La Liga", 2, 1, LocalDate.of(2024, 12, 19), 50.0,"1"));
    }

    public static ApostaServicio getInstance() {
        if (instance == null) {
            instance = new ApostaServicio();
        }
        return instance;
    }

    public List<Aposta> getApostes() {
        return apostes;
    }

    public List<Aposta> getApostesByNomUsuari(String nomUsuari) {
    List<Aposta> filteredApostes = new ArrayList<>();
    for (Aposta aposta : apostes) {
        if (aposta.getNomUsuari().equalsIgnoreCase(nomUsuari)) {
            filteredApostes.add(aposta);
        }
    }
    return filteredApostes;
}

    public Aposta getApostaById(int id) {
        for (Aposta aposta : apostes) {
            if (aposta.getId() == id) {
                return aposta;
            }
        }
        return null;  // Si no troba la aposta
    }

    public void addAposta(Aposta aposta) {
        aposta.setId(apostes.size() + 1);  // Assignar un ID automàticament
        apostes.add(aposta);
    }

    public void deleteAposta(int id) {
        apostes.removeIf(aposta -> aposta.getId() == id);
    }

    public void updateAposta(Aposta aposta) {
        Aposta apostaExistent = getApostaById(aposta.getId());
        if (apostaExistent != null) {
            apostaExistent.setNomUsuari(aposta.getNomUsuari());
            apostaExistent.setEnfrontament(aposta.getEnfrontament());
            apostaExistent.setCompeticio(aposta.getCompeticio());
            apostaExistent.setGolsEquip1(aposta.getGolsEquip1());
            apostaExistent.setGolsEquip2(aposta.getGolsEquip2());
            apostaExistent.setDataPartit(aposta.getDataPartit());
            apostaExistent.setApostaEconomica(aposta.getApostaEconomica());
            apostaExistent.setApostaEconomica(aposta.getApostaGuanyada());
        }
    }
}
