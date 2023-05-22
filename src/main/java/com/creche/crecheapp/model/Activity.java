package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@Table (name = "activity")
public class Activity {
    @Id
    @GeneratedValue
    private Integer id;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "creationDate", nullable = false)
    private Date date;
    private String description;
    private ActivityType activityType;
    private int rate;
   //@JsonBackReference("childReference")
    @JsonIgnoreProperties("activity")
   @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;
    private FileType fileType;
    //@JsonManagedReference
    @JsonIgnoreProperties("activity")
    @OneToMany(mappedBy= "activity",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Homework> homework = new ArrayList<>();

    public Activity() {
    }

    public Activity(Integer id, Date date, String description, ActivityType activityType, int rate, Child child, FileType fileType, List<Homework> homework) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.activityType = activityType;
        this.rate = rate;
      //  this.child = child;
        this.fileType = fileType;
        this.homework = homework;
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

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public List<Homework> getHomework() {
        return homework;
    }

    public void setHomework(List<Homework> homework) {
        this.homework = homework;
    }
}