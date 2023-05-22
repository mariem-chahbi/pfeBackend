package com.creche.crecheapp.repository;


import com.creche.crecheapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer id);
    void deleteById(Integer Id);
}
