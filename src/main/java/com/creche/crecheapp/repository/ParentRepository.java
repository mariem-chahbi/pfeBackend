package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
    List<Parent> findAll();
}
