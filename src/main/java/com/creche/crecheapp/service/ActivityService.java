package com.creche.crecheapp.service;



import com.creche.crecheapp.dto.ActivityDto;
import com.creche.crecheapp.model.Activity;

import java.util.List;

public interface ActivityService {
    ActivityDto saveActivity(ActivityDto activityDto);
    List<ActivityDto> getAllActivities();
    ActivityDto getActivityById(Integer id);
    void deleteActivity(Integer id);
    List<Activity> getActivitiesByChildId(Integer childId);
}
