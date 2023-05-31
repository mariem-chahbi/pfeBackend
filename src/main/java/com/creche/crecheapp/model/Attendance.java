package com.creche.crecheapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
@Data
@NoArgsConstructor


@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne( targetEntity =Child.class ,cascade = CascadeType.ALL)
    private Child child;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;



    private boolean present =false;

    public Attendance(Integer id, Child child, Date creationDate, boolean present) {
        this.id = id;
        this.creationDate = creationDate;
        this.present = present;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
