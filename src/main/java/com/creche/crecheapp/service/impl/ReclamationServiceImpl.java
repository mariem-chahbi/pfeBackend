package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Reclamation;
import com.creche.crecheapp.repository.ReclamationRepository;
import com.creche.crecheapp.service.ReclamationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ReclamationServiceImpl implements ReclamationService {

    private ReclamationRepository repository;



    public ReclamationServiceImpl(ReclamationRepository repository) {
        this.repository = repository;
    }

    @Override

    public Reclamation createReclamation(Reclamation c) {
        return repository.save(c);
    }

    @Override
    public List<Reclamation> findAllReclamations() {
        return repository.findAll();
    }

    @Override
    public Reclamation updateReclamation(Reclamation c) {
        return repository.save(c);
    }

    @Override
    public Reclamation findReclamationById(Integer id) {
        return repository.findReclamationById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
