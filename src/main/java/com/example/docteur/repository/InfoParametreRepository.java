package com.example.docteur.repository;

import com.example.docteur.model.InfoParametre;
import com.example.docteur.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoParametreRepository extends JpaRepository<InfoParametre,Long> {
    List<InfoParametre> findByPatient(Patient patient);


}
