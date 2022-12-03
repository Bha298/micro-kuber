package com.java.controller;

import com.java.entity.Department;
import com.java.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("save department inside departmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable("id") Long departmentId){
        log.info("FindDepartment inside DepartmentController");
        return departmentService.findDepartment(departmentId);
    }

}
