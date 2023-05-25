package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.model.ActivityType;
import com.creche.crecheapp.model.FileType;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;


@Builder
@Data
public class ActivityDto {
        private Integer id;

    private Date date;
        private String description;
        private ActivityType activityType;
        private int rate;
        private ChildDto child;
       // private FileType fileType;
    public static ActivityDto fromEntity(Activity activity) {
        if (activity == null) {
            return null;
        }
        return ActivityDto.builder()
                .id(activity.getId())
                .date(activity.getDate())
                .description(activity.getDescription())
                .activityType(activity.getActivityType())
                .rate(activity.getRate())
                .child(ChildDto.fromEntity(activity.getChild()))
               // .fileType(activity.getFileType())
                .build();
    }



    public static Activity toEntity(ActivityDto activityDto) {
        if (activityDto == null) {
            return null;
        }
        Activity activity = new Activity();
        activity.setId(activityDto.getId());

        activity.setDate(activityDto.getDate());
        activity.setDescription(activityDto.getDescription());
        activity.setActivityType(activityDto.getActivityType());
        activity.setRate(activityDto.getRate());
        activity.setChild(ChildDto.toEntity(activityDto.getChild()));
       // activity.setFileType(activityDto.getFileType());
        return activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public ChildDto getChild() {
        return child;
    }

    public void setChild(ChildDto child) {
        this.child = child;
    }

   /* public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }*/
}

