package com.creche.crecheapp.service;

import com.creche.crecheapp.model.Parent;

import java.util.List;

public interface ParentService  {
    List<Parent> getAllParents();

    Parent getParentById(Integer id);

    Parent createParent(Parent parent);

    Parent updateParent(Integer id, Parent parent);

    boolean deleteParent(Integer id);
}
