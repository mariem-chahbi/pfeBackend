package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Homework;

import java.util.List;

public interface HomeworkService {

    public Homework createHomework(Homework homework) ;


    public List<Homework> findAllHomework();

    public Homework updateHomework(Homework homework) ;



    public Homework findHomeworkById(int id);


    public void deleteById(Integer id);
    public List<Homework> getHomeworkByActivityNote(int note) ;
}
