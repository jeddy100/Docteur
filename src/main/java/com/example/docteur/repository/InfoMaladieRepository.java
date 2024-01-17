package com.example.docteur.repository;

import com.example.docteur.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoMaladieRepository extends JpaRepository<InfoMaladie,Long> {
    List<InfoMaladie> findByParametre(Parametre parametre);

    @Query("SELECT i FROM InfoMaladie i WHERE i.parametre.id = :parametreId")
    List<InfoMaladie> findByParametreId(@Param("parametreId") Long parametreId);


    @Query("SELECT i FROM InfoMaladie i WHERE i.maladie = :maladie and :age between i.ageDebut and i.ageFin")

    List<InfoMaladie> findByMaladie(@Param("maladie") Maladie maladie,@Param("age") int age );


}
