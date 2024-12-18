package com.dwes.adictosalfutbol;

import java.time.LocalDate;

public class Aposta {

    private int id;
    private String nomUsuari;
    private String enfrontament;
    private String competicio;
    private int golsEquip1;
    private int golsEquip2;
    private LocalDate dataPartit;
    private double apostaEconomica;
    private boolean apostaGuanyada;

    // Constructor per crear aposta sense ID (per quan la creem en el formulari)
    public Aposta(String nomUsuari, String enfrontament, String competicio, int golsEquip1, int golsEquip2, LocalDate dataPartit, double apostaEconomica, boolean apostaGuanyada) {
        this.nomUsuari = nomUsuari;
        this.enfrontament = enfrontament;
        this.competicio = competicio;
        this.golsEquip1 = golsEquip1;
        this.golsEquip2 = golsEquip2;
        this.dataPartit = dataPartit;
        this.apostaEconomica = apostaEconomica;
        this.apostaGuanyada = apostaGuanyada;
    }

    // Constructor per crear aposta amb ID (per quan l'actualitzem)
    public Aposta(int id, String nomUsuari, String enfrontament, String competicio, int golsEquip1, int golsEquip2, LocalDate dataPartit, double apostaEconomica, boolean apostaGuanyada) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.enfrontament = enfrontament;
        this.golsEquip1 = golsEquip1;
        this.golsEquip2 = golsEquip2;
        this.dataPartit = dataPartit;
        this.apostaEconomica = apostaEconomica;
        this.apostaGuanyada = apostaGuanyada;
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

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public int getGolsEquip1() {
        return golsEquip1;
    }

    public void setGolsEquip1(int golsEquip1) {
        // Validació per assegurar que els gols no poden ser negatius
        if (golsEquip1 < 0) {
            throw new IllegalArgumentException("Els gols no poden ser negatius.");
        }
        this.golsEquip1 = golsEquip1;
    }

    public int getGolsEquip2() {
        return golsEquip2;
    }

    public void setGolsEquip2(int golsEquip2) {
        // Validació per assegurar que els gols no poden ser negatius
        if (golsEquip2 < 0) {
            throw new IllegalArgumentException("Els gols no poden ser negatius.");
        }
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
        // Validació per assegurar que l'aposta econòmica sigui superior a 0
        if (apostaEconomica <= 0) {
            throw new IllegalArgumentException("La quantitat apostada ha de ser superior a 0.");
        }
        this.apostaEconomica = apostaEconomica;
    }

    
    public boolean getApostaGuanyada() {
        return apostaGuanyada;
    }
    public boolean isApostaGuanyada() {
        return apostaGuanyada;
    }

    public void setApostaGuanyada(boolean apostaGuanyada) {
        this.apostaGuanyada = apostaGuanyada;
    }

    

    @Override
    public String toString() {
        return "Aposta{" + "id=" + id + ", nomUsuari=" + nomUsuari + ", enfrontament=" + enfrontament + ", competicio=" + competicio + ", golsEquip1=" + golsEquip1 + ", golsEquip2=" + golsEquip2 + ", dataPartit=" + dataPartit + ", apostaEconomica=" + apostaEconomica + ", apostaGuanyada=" + apostaGuanyada + '}';
    }

}
