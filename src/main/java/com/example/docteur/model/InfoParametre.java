package com.example.docteur.model;

import jakarta.persistence.*;

@Entity
public class InfoParametre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_parametre")
    private Parametre parametre;
    private int etat;

    public InfoParametre() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public InfoParametre(Long id, Patient patient, Parametre parametre, int etat) {
        this.id = id;
        this.patient = patient;
        this.parametre = parametre;
        this.etat = etat;
    }

    public InfoParametre(Patient patient, Parametre parametre, int etat) {
        this.patient = patient;
        this.parametre = parametre;
        this.etat = etat;
    }
}
