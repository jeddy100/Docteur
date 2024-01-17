package com.example.docteur.repository;

import com.example.docteur.model.InfoMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoMedicamentRepository extends JpaRepository<InfoMedicament,Long> {
}
