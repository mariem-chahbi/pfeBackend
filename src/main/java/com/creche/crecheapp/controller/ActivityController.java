package com.creche.crecheapp.controller;

import com.creche.crecheapp.dto.ActivityDto;
import com.creche.crecheapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/add")

    public ActivityDto createActivity(@RequestBody ActivityDto activityDto) {
        return activityService.saveActivity(activityDto);
    }

    @GetMapping("/{id}")
    public ActivityDto getActivityById(@PathVariable Integer id) {
        return activityService.getActivityById(id);
    }

    @GetMapping("/all")
    public List<ActivityDto> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PutMapping("/update/{id}")
    public ActivityDto updateActivity(@PathVariable Integer id, @RequestBody ActivityDto activityDto) {
        activityDto.setId(id);
        return activityService.saveActivity(activityDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
    }



}
