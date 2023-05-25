package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Parent;
import com.creche.crecheapp.repository.ParentRepository;
import com.creche.crecheapp.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Integer id) {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        return optionalParent.orElse(null);
    }

    @Override
    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent updateParent(Integer id, Parent parent) {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        if (optionalParent.isPresent()) {
            Parent existingParent = optionalParent.get();
            existingParent.setAddress(parent.getAddress());
            existingParent.setLocation(parent.getLocation());
            existingParent.setPhoneNumber(parent.getPhoneNumber());
           // existingParent.setChildren(parent.getChildren());
            // Update any other fields as needed

            return parentRepository.save(existingParent);
        }
        return null;
    }

    @Override
    public boolean deleteParent(Integer id) {
        if (parentRepository.existsById(id)) {
            parentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
