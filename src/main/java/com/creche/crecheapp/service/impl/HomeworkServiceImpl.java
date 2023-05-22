package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Homework;
import com.creche.crecheapp.model.HomeworkType;
import com.creche.crecheapp.repository.HomeworkRepository;
import com.creche.crecheapp.service.HomeworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class HomeworkServiceImpl implements HomeworkService {
    private HomeworkRepository repository;
    public HomeworkServiceImpl(HomeworkRepository repository) {
        this.repository = repository;
    }



@Override
    public Homework createHomework(Homework homework) {


        return repository.save(homework);
    }

@Override
    public List<Homework> findAllHomework() {
        return repository.findAll();
    }
@Override
    public Homework updateHomework(Homework homework) {
        return repository.save(homework);
    }


@Override
    public Homework findHomeworkById(int id) {
        return repository.findHomeworkById(id);
    }

@Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Homework> getHomeworkByActivityNote(int note) {
        if (note < 10) {
            return repository.findByType(HomeworkType.FACILE);
        } else if (note >= 10 && note < 15) {
            return repository.findByType(HomeworkType.MOYEN);
        } else {
            return repository.findByType(HomeworkType.DIFICILE);
        }
    }
}
