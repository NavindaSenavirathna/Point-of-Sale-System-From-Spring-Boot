package com.example.employee_service.service;

import com.example.employee_service.dto.ApiResponseDTO;
import com.example.employee_service.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployeeById(Long id);
}
