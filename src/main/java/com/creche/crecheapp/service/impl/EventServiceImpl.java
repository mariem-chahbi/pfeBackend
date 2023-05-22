package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Event;
import com.creche.crecheapp.repository.EventRepository;
import com.creche.crecheapp.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EventServiceImpl implements EventService {
    private EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

@Override

    public Event createEvent(Event c) {
        return repository.save(c);
    }

@Override
    public List<Event> findAllEvents() {
        return repository.findAll();
    }

@Override
    public Event updateEvent(Event c) {
        return repository.save(c);
    }

@Override
    public Event findEventById(Integer id) {
        return repository.findEventById(id);
    }

@Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
