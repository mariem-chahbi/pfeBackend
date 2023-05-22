package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Attendance;
import com.creche.crecheapp.repository.AttendanceRepository;
import com.creche.crecheapp.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class AttendanceServiceImpl implements AttendanceService{

    private AttendanceRepository repository;

    public AttendanceServiceImpl(AttendanceRepository repository) {
        this.repository = repository;
    }

    @Override

    public Attendance createAttendance(Attendance c) {
        return repository.save(c);
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
