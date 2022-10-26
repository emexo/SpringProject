package com.bugtacking.repository;

import com.bugtacking.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByApplicationName(String name);

    @Query(value = "Select app from Application app where applicationName=:name")
    Optional<Application> findApplicationByName(@Param("name") String name);
}
