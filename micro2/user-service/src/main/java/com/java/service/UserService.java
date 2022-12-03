package com.java.service;

import com.java.entity.User;
import com.java.repo.UserRep;
import com.java.vo.Department;
import com.java.vo.ResponseTemplateView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

@Autowired
    private UserRep userRep;

@Autowired
private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("saveUser inside userService");
        return userRep.save(user);
    }



    public ResponseTemplateView getUserWithDepartment(Long userId) {
        log.info("getUserWithDepartment inside userService");
        ResponseTemplateView vo=new ResponseTemplateView();
        User user=userRep.findByUserId(userId);

        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;



    }
}
