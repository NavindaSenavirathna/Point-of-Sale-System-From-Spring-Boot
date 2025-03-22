package com.example.deparment_service.service.implement;

import com.example.deparment_service.dto.DepartmentDTO;
import com.example.deparment_service.entity.Department;
import com.example.deparment_service.repository.DepartmentRepository;
import com.example.deparment_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentImplement implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    public DepartmentImplement(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );


        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO departmentDTO1 = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return departmentDTO1;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String Code) {
        Department departmentCode = departmentRepository.findByDepartmentCode(Code);
        DepartmentDTO departmentDTO = new DepartmentDTO(
                departmentCode.getId(),
                departmentCode.getDepartmentName(),
                departmentCode.getDepartmentDescription(),
                departmentCode.getDepartmentCode()
        );
        return departmentDTO;
    }
}
