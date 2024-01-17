package com.example.docteur.model;

import jakarta.persistence.*;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom_medicamemt;
    private double prix;
    private int ageDebut;
    private int ageFin;

    public Medicament() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_medicamemt() {
        return nom_medicamemt;
    }

    public void setNom_medicamemt(String nom_medicamemt) {
        this.nom_medicamemt = nom_medicamemt;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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

    public Medicament(Long id, String nom_medicamemt, double prix, int ageDebut, int ageFin) {
        this.id = id;
        this.nom_medicamemt = nom_medicamemt;
        this.prix = prix;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
    }

    public Medicament(String nom_medicamemt, double prix, int ageDebut, int ageFin) {
        this.nom_medicamemt = nom_medicamemt;
        this.prix = prix;
        this.ageDebut = ageDebut;
        this.ageFin = ageFin;
    }
}
