package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    Attendance findAttendanceById(Integer id);
    void deleteById(Integer Id);
}
