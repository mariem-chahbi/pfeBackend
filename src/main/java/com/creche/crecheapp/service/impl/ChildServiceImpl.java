package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.model.Child;
import com.creche.crecheapp.repository.ActivityRepository;
import com.creche.crecheapp.repository.ChildRepository;
import com.creche.crecheapp.service.ChildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ChildServiceImpl implements ChildService {
    private final ActivityRepository activityRepository;

    private ChildRepository repository;

    public ChildServiceImpl(ActivityRepository activityRepository, ChildRepository repository) {
        this.activityRepository = activityRepository;
        this.repository = repository;
    }


    @Override
    public Child createChild(Child c) {
        return repository.save(c);

    }

@Override
    public List<Child> findAllChilds() {
        return repository.findAll();
    }

@Override
    public Child updateChild(Child c) {
        return repository.save(c);
    }

@Override
    public Child findChildById(Integer id) {
        return repository.findChildById(id);
    }

@Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Activity> getActivitiesByChildId(Integer childId) {
        return activityRepository.findByChildId(childId);
    }

}
