package com.java.repo;

import com.java.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRep extends JpaRepository<Department,Long> {
    Department findByDepartmentId(Long departmentId);
}
