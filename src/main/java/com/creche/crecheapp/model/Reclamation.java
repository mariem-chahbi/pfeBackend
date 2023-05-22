package com.creche.crecheapp.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reclamation")
public class Reclamation {
    @Id
    @GeneratedValue
    private Integer id;
    private String title ;
    private String text ;

    public Reclamation() {
    }

    public Reclamation(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
