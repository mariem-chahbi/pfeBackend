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
@AllArgsConstructor

@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    @CreationTimestamp
    @JsonIgnore
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;
    @JsonIgnoreProperties("attendance")
    //@JsonManagedReference
    @OneToMany(targetEntity = Child.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)

    private List<Child> children;
    private boolean present =false;

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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
