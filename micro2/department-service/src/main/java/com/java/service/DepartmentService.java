package com.java.service;

import com.java.entity.Department;
import com.java.repo.DepartmentRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRep departmentRep;

    public Department saveDepartment(Department department) {
        log.info("saveDepartment inside DepartmentService");
        return departmentRep.save(department);
    }

    public Department findDepartment(Long departmentId) {
        log.info("findDepartment inside DepartmentService");
        return departmentRep.findByDepartmentId(departmentId);
    }
}
