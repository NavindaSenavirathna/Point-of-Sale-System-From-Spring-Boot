package com.example.deparment_service.controller;

import com.example.deparment_service.dto.DepartmentDTO;
import com.example.deparment_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO saveDepartment_here = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(saveDepartment_here, HttpStatus.CREATED);
    }

    @GetMapping(path = "{get-by-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable(value = "get-by-code")String departmentCode){
        DepartmentDTO getDepartment_here = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(getDepartment_here,HttpStatus.OK);
    }



}
