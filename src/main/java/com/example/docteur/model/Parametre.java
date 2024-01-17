package com.example.docteur.model;

import jakarta.persistence.*;

@Entity
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom_parametre;

    public Parametre() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_parametre() {
        return nom_parametre;
    }

    public void setNom_parametre(String nom_parametre) {
        this.nom_parametre = nom_parametre;
    }

    public Parametre(Long id, String nom_parametre) {
        this.id = id;
        this.nom_parametre = nom_parametre;
    }

    public Parametre(String nom_parametre) {
        this.nom_parametre = nom_parametre;
    }
}
