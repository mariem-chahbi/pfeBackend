package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.model.Child;

import java.util.List;

public interface ChildService {





    public Child createChild(Child c) ;


    public List<Child> findAllChilds() ;


    public Child updateChild(Child c) ;


    public Child findChildById(Integer id) ;


    public void deleteById(Integer id) ;
    public List<Activity> getActivitiesByChildId(Integer childId);

}
