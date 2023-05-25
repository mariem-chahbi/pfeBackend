package com.creche.crecheapp.dto;

import com.creche.crecheapp.model.Child;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ChildDto {
    private Integer id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String image;

    private int age;
    private boolean is_present;




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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIs_present() {
        return is_present;
    }

    public void setIs_present(boolean is_present) {
        this.is_present = is_present;
    }

    public static ChildDto fromEntity(Child child) {
        if (child == null) {
            return null;
        }
        return ChildDto.builder()
                .id(child.getId())
                .firstname(child.getFirstname())
                .lastname(child.getLastname())
                .dateOfBirth(child.getDateOfBirth())
               // .image(child.getImage())
                .age(child.getAge())
                .build();

    }

    public static Child toEntity(ChildDto childDto) {
        if (childDto == null) {
            return null;
        }
        Child child = new Child();
        child.setId(childDto.getId());
        child.setFirstname(childDto.getFirstname());
        child.setLastname(childDto.getLastname());
        child.setDateOfBirth(childDto.getDateOfBirth());
       // child.setImage(childDto.getImage());
        //child.setAge(childDto.getAge());
        return child;
    }
}


