package com.creche.crecheapp.controller;

import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.model.Child;
import com.creche.crecheapp.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/child" ,consumes = MediaType.APPLICATION_JSON_VALUE)
public class ChildController {
    private final ChildService service;
    @Autowired
    public ChildController(

           ChildService service



    ) {
        this.service = service;
    }

    @PostMapping("/add")



    public Child save(
            @RequestBody Child child
    ) {
        return service.createChild(child);
    }


    @GetMapping(value = "/{id}")
    public Child findChildById(
            @PathVariable("id") Integer id
    ) {
        return service.findChildById(id);
    }

    @GetMapping ("/all")

    public List<Child> findAllChilds() {
        return service.findAllChilds();
    }

    @PutMapping("/update/{id}")
    public Child updateChild(@PathVariable("id") Integer id, @RequestBody Child child) {
        child.setId(id); // Assuming the child object has an ID field
        return service.updateChild(child);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable("id") Integer id
    ) {
        service.deleteById(id);
    }

    @GetMapping("/childActivity/{id}")
    public List<Activity> getActivitiesByChildId(@PathVariable Integer id) {
        return service.getActivitiesByChildId(id);
    }
    @GetMapping(value = "/name/{id}")
    public ResponseEntity<String> getChildName(@PathVariable("id") Integer id) {
        Child child = service.findChildById(id);
        if (child != null) {
            String fullName = child.getFirstname() + " " + child.getLastname();
            return ResponseEntity.ok(fullName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}