package com.example.repository;

import com.example.dto.DepartmentDTO;
import com.example.projection.DepartmentProjection;
import com.example.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Interface-based projection
    @Query("SELECT d.id AS id, d.name AS name FROM Department d WHERE d.id = :id")
    DepartmentProjection findDepartmentProjectionById(@Param("id") Long id);

    // Class-based projection
    @Query("SELECT new com.example.dto.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();
}
