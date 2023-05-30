package com.creche.crecheapp.controller;

import com.creche.crecheapp.model.Attendance;
import com.creche.crecheapp.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(

            AttendanceService service

    ) {
        this.service = service;
    }

    @PostMapping("/add")
    public Attendance save(
            @RequestBody Attendance child
    ) {
        return service.createAttendance(child);
    }


    @GetMapping("/{id}")
    public Attendance findByEmail(
            @PathVariable("id") Integer id
    ) {
        return service.findAttendanceById(id);
    }

    @GetMapping("/all")
    public List<Attendance> findAllStudents() {
        return service.findAllAttendances();
    }

    @PutMapping("/update/{id}")
    public Attendance updateStudent(
            @RequestBody Attendance student
    ) {
        return service.updateAttendance(student);
    }

    @DeleteMapping("delete/{id}")
    public void delete(
            @PathVariable("id") Integer id
    ) {
        service.deleteById(id);
    }

}
