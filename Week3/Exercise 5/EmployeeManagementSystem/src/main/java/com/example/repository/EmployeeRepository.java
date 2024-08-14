package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department name
    List<Employee> findByDepartmentName(String departmentName);

    // Find an employee by email
    Employee findByEmail(String email);

    // Custom query to find employees by partial name
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findByNameContaining(@Param("name") String name);

    // Named query to find employees by department ID
    @Query(name = "Employee.findByDepartmentId")
    List<Employee> findByDepartmentId(@Param("deptId") Long deptId);

    // Named query to find employee by email
    @Query(name = "Employee.findByEmail")
    Employee findEmployeeByEmail(@Param("email") String email);
}
