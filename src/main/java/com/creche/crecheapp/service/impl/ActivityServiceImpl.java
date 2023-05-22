package com.creche.crecheapp.service.impl;

import com.creche.crecheapp.dto.ActivityDto;
import com.creche.crecheapp.exception.ResourceNotFoundException;
import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.model.Child;
import com.creche.crecheapp.repository.ActivityRepository;
import com.creche.crecheapp.repository.ChildRepository;
import com.creche.crecheapp.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final ChildRepository childRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, ChildRepository childRepository) {
        this.activityRepository = activityRepository;
        this.childRepository = childRepository;
    }

    @Override
    public ActivityDto saveActivity(ActivityDto activityDto) {
        Activity activity = ActivityDto.toEntity(activityDto);
        Child child = childRepository.findById(activityDto.getChild().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Activity not save  " + activityDto.getChild().getId()));

        activity = activityRepository.save(activity);
        return ActivityDto.fromEntity(activity);
    }

    @Override
    public List<ActivityDto> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream()
                .map(ActivityDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDto getActivityById(Integer id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id " + id));
        return ActivityDto.fromEntity(activity);
    }

    @Override
    public void deleteActivity(Integer id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id " + id));
        activityRepository.delete(activity);
    }

    @Override
    public List<Activity> getActivitiesByChildId(Integer childId) {
        return null;
    }


}
