package com.creche.crecheapp.controller;

import com.creche.crecheapp.dto.ActivityDto;
import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Activity getActivityById(@PathVariable Integer id) {
        return activityService.getActivityById(id);
    }

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
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

    @GetMapping("/child/{childId}")
    public ResponseEntity<List<Activity>> getActivitiesByChildId(@PathVariable Integer childId) {
        List<Activity> activities = activityService.getActivitiesByChildId(childId);
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/getImageActivity/{id}")
    public List<String> getImagesByActivityId(@PathVariable Integer id) {
        Activity activity = activityService.getActivityById(id);
        String[] ids = activity.fileUrl.split(",");
        List<String> idsInt = new ArrayList<>();
        for (String s : ids) {
            idsInt.add(s);
        }
        return idsInt;
    }
}
