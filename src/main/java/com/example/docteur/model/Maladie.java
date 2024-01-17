package com.example.docteur.model;

import com.example.docteur.repository.InfoMaladieRepository;
import com.example.docteur.repository.InfoParametreRepository;
import com.example.docteur.repository.MaladieRepository;
import jakarta.persistence.*;

import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom_maladie;

    public Maladie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_maladie() {
        return nom_maladie;
    }

    public void setNom_maladie(String nom_maladie) {
        this.nom_maladie = nom_maladie;
    }

    public Maladie(Long id, String nom_maladie) {
        this.id = id;
        this.nom_maladie = nom_maladie;
    }

    public Maladie(String nom_maladie) {
        this.nom_maladie = nom_maladie;
    }

    public List<Maladie> getMaladies(Patient patient, InfoParametreRepository infoParametreRepository, InfoMaladieRepository infoMaladieRepository, MaladieRepository maladieRepository) {
        List<Maladie> maladies = new ArrayList<>();
        List<Maladie> maladiesrep = new ArrayList<>();


        // Récupération des infosParametres pour le patient
        List<InfoParametre> infoParametres = infoParametreRepository.findByPatient(patient);

        // Récupération des infosMaladies correspondant aux infosParametres
        for (InfoParametre infoParametre : infoParametres) {
            int agePatient = patient.getAge();
            Long parametreId = infoParametre.getParametre().getId();

            // Récupération des infosMaladies correspondant au parametre
            List<InfoMaladie> infosMaladies = infoMaladieRepository.findByParametreId(parametreId);

            // Vérification des conditions pour chaque infoMaladie
            for (InfoMaladie infoMaladie : infosMaladies) {
                if (agePatient >= infoMaladie.getAgeDebut() && agePatient <= infoMaladie.getAgeFin()
                        && infoParametre.getEtat() >= infoMaladie.getEtatDebut() && infoParametre.getEtat() <= infoMaladie.getEtatFin()) {
                    maladies.add(infoMaladie.getMaladie());
                }
            }
            System.out.println(maladies.size());
        }
        for (Maladie maladie : maladies) {
            List<InfoMaladie> infosMaladiesForMaladie = infoMaladieRepository.findByMaladie(maladie, patient.getAge());
            System.out.println("nombre dinfomaladies pour la maladie"+maladie.getNom_maladie()+infosMaladiesForMaladie.size());
            System.out.println("comp:"+ infosMaladiesForMaladie.size()+" "+ maladies.size());
            if (infosMaladiesForMaladie.size() == maladies.size()) {
                maladiesrep.add(maladie);
            }
        }
        System.out.println("//////////////////nouvelle consultation");

        return maladiesrep;
    }



}
