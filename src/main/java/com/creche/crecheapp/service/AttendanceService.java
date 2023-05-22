package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Attendance;

import java.util.List;

public interface AttendanceService {


    public Attendance createAttendance(Attendance c);


    public List<Attendance> findAllAttendances();


    public Attendance updateAttendance(Attendance c);


    public Attendance findAttendanceById(Integer id);


    public void deleteById(Integer id);
}
