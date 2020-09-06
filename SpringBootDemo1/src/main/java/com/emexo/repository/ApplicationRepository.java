package com.emexo.repository;

import com.emexo.entity.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {

    List<Application> findByName(String name);

    @Query(value = "SELECT a from Application a WHERE name = :name")
    List<Application> findByUserName(@Param("name") String name);
}
