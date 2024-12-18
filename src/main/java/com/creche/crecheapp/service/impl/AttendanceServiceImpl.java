package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Attendance;
import com.creche.crecheapp.model.Child;
import com.creche.crecheapp.repository.AttendanceRepository;
import com.creche.crecheapp.repository.ChildRepository;
import com.creche.crecheapp.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class AttendanceServiceImpl implements AttendanceService{

    private AttendanceRepository repository;

    private final ChildRepository childRepository;

    public AttendanceServiceImpl(AttendanceRepository repository, ChildRepository childRepository) {
        this.repository = repository;
        this.childRepository = childRepository;
    }
    @Override
    public Attendance createAttendance(Attendance attendance) {
        // Fetch the child from the database using the child ID
        Child child = childRepository.findChildById(attendance.getChild().getId());
        attendance.setChild(child);
        return repository.save(attendance);
    }


    @Override
    public List<Attendance> findAllAttendances() {
        return repository.findAll();
    }

    @Override
    public Attendance updateAttendance(Attendance c) {
        return repository.save(c);
    }

    @Override
    public Attendance findAttendanceById(Integer id) {
        return repository.findAttendanceById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
