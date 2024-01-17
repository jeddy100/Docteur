package com.example.docteur.model;

import jakarta.persistence.*;

@Entity
public class InfoMedicament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_parametre")
    private Parametre parametre;
    @ManyToOne
    @JoinColumn(name = "id_medicament")
    private Medicament medicament;

    private int efficacite;

    public InfoMedicament() {

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

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(int efficacite) {
        this.efficacite = efficacite;
    }

    public InfoMedicament(Long id, Parametre parametre, Medicament medicament, int efficacite) {
        this.id = id;
        this.parametre = parametre;
        this.medicament = medicament;
        this.efficacite = efficacite;
    }

    public InfoMedicament(Parametre parametre, Medicament medicament, int efficacite) {
        this.parametre = parametre;
        this.medicament = medicament;
        this.efficacite = efficacite;
    }
}
