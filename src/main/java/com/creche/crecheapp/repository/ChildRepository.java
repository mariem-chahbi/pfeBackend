package com.creche.crecheapp.repository;

import com.creche.crecheapp.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ChildRepository extends JpaRepository<Child, Integer> {
    Child findChildById(Integer id);
    @Transactional
    @Modifying
    void deleteById(Integer Id);

    @Query("SELECT COUNT(c) FROM Child c")
    Integer countChild();


}
