package com.creche.crecheapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


/*@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString*/
  /*  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
*/
@Entity
@Table(name = "child")
public class Child implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    //private String image;





   /* @JsonIgnoreProperties("child")
    @OneToMany(mappedBy = "child", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    /* @OneToMany(targetEntity = Child.class, cascade = CascadeType.ALL) */
   // private List<Activity> activities;


    //@JsonBackReference("parentReference")
    @JsonIgnoreProperties("child")
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

  /*  @JsonIgnoreProperties("child")
    @ManyToOne
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;*/

    public Child(Integer id, String firstname, String lastname, LocalDate dateOfBirth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        //  this.image = image;
     //   this.age = age;
      //  this.activities = activities;
    }


    public Child() {
        Integer id;
        String firstname;
        String lastname;
        LocalDate dateOfBirth;
        // String image;
        Parent parent;
      //  int age;
       // List<Activity> activities;
       // Attendance attendance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

/*    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }*/



   /* public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }*/

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

  /*  public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
<<<<<<< HEAD
    }
}
=======
    }*/
}
