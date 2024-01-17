package com.example.docteur.controller;

import com.example.docteur.model.InfoParametre;
import com.example.docteur.model.Maladie;
import com.example.docteur.model.Parametre;
import com.example.docteur.model.Patient;
import com.example.docteur.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class Control {

    @Autowired
    ParametreRepository parametreRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InfoParametreRepository infoParametreRepository;
    @Autowired
    private InfoMaladieRepository infoMaladieRepository;
    @Autowired
    private MaladieRepository maladieRepository;


    @GetMapping("/insertPatient")
    public String home(Model model){
        model.addAttribute("listParametres", parametreRepository.findAll());
        return "InsertPatient";
    }

    @PostMapping("/patientpost")
    public String ajouterClient(@RequestParam String nom, @RequestParam int age, @RequestParam Map<String, String> params,Model model) {
        // Traitez l'ajout du client et de ses paramètres ici en utilisant les paramètres de la requête
        // Assurez-vous d'avoir un service pour gérer l'ajout des clients et des InfoParametres

        // Exemple : Création d'un client
        Patient patient = new Patient(nom, age);
        // Enregistrement du client
        patient = patientRepository.save(patient);

        // Parcours des paramètres pour créer les InfoParametres
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("etat_")) {
                Long parametreId = Long.parseLong(entry.getKey().replace("etat_", ""));
                int etat = Integer.parseInt(entry.getValue());

                // Exemple : Création d'un InfoParametre
                Parametre parametre = parametreRepository.getById(parametreId);
                InfoParametre infoParametre = new InfoParametre(patient, parametre, etat);
                infoParametreRepository.save(infoParametre);

                // Enregistrement de l'InfoParametre
                // Assurez-vous d'avoir un service pour gérer l'ajout des InfoParametres
                // infoParametreService.enregistrerInfoParametre(infoParametre);
            }
        }

        return "patientDetails";
    }

    @GetMapping("/insertConsultation")
    public String consult(Model model){
        model.addAttribute("listPatients", patientRepository.findAll());
        return "InsertConsultation";
    }

    @PostMapping("/consultationpost")
    public RedirectView consultationPost(@RequestParam("patient") Long patientId) {
        Optional<Patient>patientOptional=patientRepository.findById(patientId);
        Patient patient=null;
        if(patientOptional.isPresent())
        {
            patient=patientOptional.get();
        }
        Maladie maladie=new Maladie();
        List<Maladie> maladieList=maladie.getMaladies(patient,infoParametreRepository,infoMaladieRepository,maladieRepository);
        for (int i = 0; i <maladieList.size() ; i++) {
            System.out.println("maladies:" + maladieList.get(i).getNom_maladie());
        }
        return new RedirectView("/page-de-redirection", true);

    }
}
