package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Homework;
import com.creche.crecheapp.model.HomeworkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository  extends JpaRepository<Homework, Integer> {
    Homework findHomeworkById(int id);
    void deleteById(Integer Id);
    List<Homework> findByType(HomeworkType type);

}
