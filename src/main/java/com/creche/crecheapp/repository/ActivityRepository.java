package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository  extends JpaRepository<Activity, Integer> {
    Activity findActivityById(int id);
    List<Activity> findByChildId(Integer childId);
    void deleteById(Integer Id);
    List<Activity> findAllByChildId(Integer childId);
}
