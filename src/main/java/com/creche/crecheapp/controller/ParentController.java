package com.creche.crecheapp.controller;

import com.creche.crecheapp.model.Parent;
import com.creche.crecheapp.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parent")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return ResponseEntity.ok(parents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Integer id) {
        Parent parent = parentService.getParentById(id);
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Integer id, @RequestBody Parent parent) {
        Parent updatedParent = parentService.updateParent(id, parent);
        if (updatedParent != null) {
            return ResponseEntity.ok(updatedParent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Integer id) {
        boolean deleted = parentService.deleteParent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
