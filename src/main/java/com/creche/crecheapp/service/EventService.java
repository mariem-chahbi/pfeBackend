package com.creche.crecheapp.service;



import com.creche.crecheapp.model.Event;

import java.util.List;

public interface EventService {




    public Event createEvent(Event c);


    public List<Event> findAllEvents();


    public Event updateEvent(Event c);


    public Event findEventById(Integer id);


    public void deleteById(Integer id);
}
