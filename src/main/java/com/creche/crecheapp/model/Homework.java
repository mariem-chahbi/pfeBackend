package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private HomeworkType type;
    private String description;
    private String image;
    private String text;
    @JsonIgnoreProperties("Homework")
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;



}
