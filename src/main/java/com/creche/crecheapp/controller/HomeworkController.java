package com.creche.crecheapp.controller;

import com.creche.crecheapp.model.Homework;
import com.creche.crecheapp.repository.HomeworkRepository;
import com.creche.crecheapp.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/homework")
public class HomeworkController {
    private final HomeworkService service;
    @Autowired
    private HomeworkRepository repository;
    @Autowired
    public HomeworkController(
            HomeworkService service
    ) {
        this.service = service;
    }
    @PostMapping("/add")
    public Homework save(
            @RequestBody Homework homework
    ) {
        return service.createHomework(homework);
    }
    @GetMapping("/activitynote/{note}")
    public List<Homework> getHomeworkByActivityNote(@PathVariable("note") int note) {
        return service.getHomeworkByActivityNote(note);
    }
    @GetMapping("/{id_Child}")
    public Homework findHomeworkById(
            @PathVariable("id_Child") int id
    ) {
        return service.findHomeworkById(id);
    }

    @GetMapping("/all")
    public List<Homework> findAllHomeworks() {
        return service.findAllHomework();
    }

    @PutMapping
    public Homework updateHomeworks(
            @RequestBody Homework homework
    ) {
        return service.updateHomework(homework);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable("id") Integer id
    ) {
        service.deleteById(id);
    }
}
