package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

@Entity
@Table(name = "Homework")
public class Homework implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonIgnoreProperties("Homework")
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
    private String title;
    @Enumerated(EnumType.STRING)
    private HomeworkType type;
    private String description;
    private String image;
    private String text;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public String fileUrl="";

   /* @JsonIgnoreProperties("Homework")
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;*/

    public Homework() {
    }

    public Homework(Integer id, Activity activity, String title, HomeworkType type, String description, String image, String text) {
        this.id = id;
        this.activity = activity;
        this.title = title;
        this.type = type;
        this.description = description;
        this.image = image;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HomeworkType getType() {
        return type;
    }

    public void setType(HomeworkType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
