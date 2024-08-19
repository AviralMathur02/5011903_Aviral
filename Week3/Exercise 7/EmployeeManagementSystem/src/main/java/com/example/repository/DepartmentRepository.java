package com.example.repository;

import com.example.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Add custom queries for the Department entity if needed

}