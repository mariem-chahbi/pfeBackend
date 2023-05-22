package com.creche.crecheapp.controller;

import com.creche.crecheapp.model.Event;
import com.creche.crecheapp.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService service;

    public EventController(

      EventService service

    ) {
        this.service = service;
    }

    @PostMapping("/add")
    public Event save(
            @RequestBody Event child
    ) {
        return service.createEvent(child);
    }


    @GetMapping("/{id}")
    public Event findByEmail(
            @PathVariable("id") Integer id
    ) {
        return service.findEventById(id);
    }

    @GetMapping("/all")
    public List<Event> findAllStudents() {
        return service.findAllEvents();
    }

    @PutMapping("/update")
    public Event updateStudent(
            @RequestBody Event student
    ) {
        return service.updateEvent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable("id") Integer id
    ) {
        service.deleteById(id);
    }

}
