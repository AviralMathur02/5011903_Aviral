package com.example.repository;

import com.example.dto.EmployeeDTO;
import com.example.projection.EmployeeProjection;
import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, e.department.name AS departmentName " +
            "FROM Employee e WHERE e.id = :id")
    EmployeeProjection findEmployeeProjectionById(@Param("id") Long id);

    // Class-based projection
    @Query("SELECT new com.example.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) " +
            "FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();
}
