package com.example.docteur.model;

import jakarta.persistence.*;

@Entity
public class InfoMaladie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_parametre")
    private Parametre parametre;
    @ManyToOne
    @JoinColumn(name = "id_maladie")
    private Maladie maladie;

    private int etatDebut;
    private int etatFin;
    private int ageDebut;
    private int ageFin;

    public InfoMaladie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public int getEtatDebut() {
        return etatDebut;
    }

    public void setEtatDebut(int etatDebut) {
        this.etatDebut = etatDebut;
    }

    public int getEtatFin() {
        return etatFin;
    }

    public void setEtatFin(int etatFin) {
        this.etatFin = etatFin;
    }

    public int getAgeDebut() {
        return ageDebut;
    }

    public void setAgeDebut(int ageDebut) {
        this.ageDebut = ageDebut;
    }

    public int getAgeFin() {
        return ageFin;
    }

    public void setAgeFin(int ageFin) {
        this.ageFin = ageFin;
    }

    public InfoMaladie(Long id, Parametre parametre, Maladie maladie, int etatDebut, int etatFin, int ageDebut, int ageFin) {
        this.id = id;
        this.parametre = parametre;
        this.maladie = maladie;
        this.etatDebut = etatDebut;
        this.etatFin = etatFin;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
    }

    public InfoMaladie(Parametre parametre, Maladie maladie, int etatDebut, int etatFin, int ageDebut, int ageFin) {
        this.parametre = parametre;
        this.maladie = maladie;
        this.etatDebut = etatDebut;
        this.etatFin = etatFin;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
    }
}
