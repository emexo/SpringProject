package com.emexo.repository;

import com.emexo.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
