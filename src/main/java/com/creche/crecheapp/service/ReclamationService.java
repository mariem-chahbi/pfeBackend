package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Reclamation;

import java.util.List;

public interface ReclamationService {

    public Reclamation createReclamation(Reclamation c);


    public List<Reclamation> findAllReclamations();


    public Reclamation updateReclamation(Reclamation c);


    public Reclamation findReclamationById(Integer id);


    public void deleteById(Integer id);
}
