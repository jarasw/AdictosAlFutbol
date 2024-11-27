package com.dwes.adictosalfutbol;

import java.time.LocalDate;

public class Aposta {

    private int id; // ID de l'aposta
    private String nomUsuari; // Nom de l'usuari que fa l'aposta
    private String enfrontament; // Equip1 - Equip2
    private int golsEquip1; // Gols apostats per a l'equip 1
    private int golsEquip2; // Gols apostats per a l'equip 2
    private LocalDate dataPartit; // Data del partit
    private double apostaEconomica; // Quantitat apostada

    public Aposta() {
    }

    public Aposta(int id, String nomUsuari, String enfrontament, int golsEquip1, int golsEquip2, LocalDate dataPartit, double apostaEconomica) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.enfrontament = enfrontament;
        this.golsEquip1 = golsEquip1;
        this.golsEquip2 = golsEquip2;
        this.dataPartit = dataPartit;
        this.apostaEconomica = apostaEconomica;
    }

    // Getters i setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEnfrontament() {
        return enfrontament;
    }

    public void setEnfrontament(String enfrontament) {
        this.enfrontament = enfrontament;
    }

    public int getGolsEquip1() {
        return golsEquip1;
    }

    public void setGolsEquip1(int golsEquip1) {
        this.golsEquip1 = golsEquip1;
    }

    public int getGolsEquip2() {
        return golsEquip2;
    }

    public void setGolsEquip2(int golsEquip2) {
        this.golsEquip2 = golsEquip2;
    }

    public LocalDate getDataPartit() {
        return dataPartit;
    }

    public void setDataPartit(LocalDate dataPartit) {
        this.dataPartit = dataPartit;
    }

    public double getApostaEconomica() {
        return apostaEconomica;
    }

    public void setApostaEconomica(double apostaEconomica) {
        this.apostaEconomica = apostaEconomica;
    }

    @Override
    public String toString() {
        return "Aposta{"
                + "id=" + id
                + ", nomUsuari='" + nomUsuari + '\''
                + ", enfrontament='" + enfrontament + '\''
                + ", golsEquip1=" + golsEquip1
                + ", golsEquip2=" + golsEquip2
                + ", dataPartit=" + dataPartit
                + ", apostaEconomica=" + apostaEconomica
                + '}';
    }
}
