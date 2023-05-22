package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
    Reclamation findReclamationById(Integer id);
    void deleteById(Integer Id);


}
