package com.example.employee_service.service;

import com.example.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "http://localhost:8081", value = "Department-Service")
public interface ApiClient {

    @GetMapping(path = "api/department/{get-by-code}")
    DepartmentDTO getDepartmentByCode(@PathVariable(value = "get-by-code")String departmentCode);

}
