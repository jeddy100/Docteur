package com.example.docteur.repository;

import com.example.docteur.model.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.LogManager;
@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Long> {
}
