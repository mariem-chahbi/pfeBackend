package com.creche.crecheapp.controller;

import com.creche.crecheapp.dto.ReclamationDto;
import com.creche.crecheapp.model.Reclamation;
import com.creche.crecheapp.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reclamation")
public class ReclamationController {

    private final ReclamationService reclamationService;

    @Autowired
    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping("/add")
    public ReclamationDto addReclamation(@RequestBody ReclamationDto reclamationDto) {
        Reclamation reclamation = ReclamationDto.toEntity(reclamationDto);
        Reclamation createdReclamation = reclamationService.createReclamation(reclamation);
        return ReclamationDto.fromEntity(createdReclamation);
    }

    @GetMapping("/{id}")
    public ReclamationDto getReclamationById(@PathVariable Integer id) {
        Reclamation reclamation = reclamationService.findReclamationById(id);
        return ReclamationDto.fromEntity(reclamation);
    }

    @GetMapping("/all")
    public List<ReclamationDto> getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.findAllReclamations();
        return reclamations.stream()
                .map(ReclamationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public ReclamationDto updateReclamation(@PathVariable Integer id, @RequestBody ReclamationDto reclamationDto) {
        Reclamation reclamation = ReclamationDto.toEntity(reclamationDto);
        reclamation.setId(id);
        Reclamation updatedReclamation = reclamationService.updateReclamation(reclamation);
        return ReclamationDto.fromEntity(updatedReclamation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReclamation(@PathVariable Integer id) {
        reclamationService.deleteById(id);
    }
}
