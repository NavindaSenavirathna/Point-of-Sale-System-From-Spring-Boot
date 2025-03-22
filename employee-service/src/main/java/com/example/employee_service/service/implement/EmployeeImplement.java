package com.example.employee_service.service.implement;



import com.example.employee_service.dto.ApiResponseDTO;
import com.example.employee_service.dto.DepartmentDTO;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.ApiClient;
import com.example.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeImplement implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private WebClient webClient;


    //private RestTemplate restTemplate;
    private ApiClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstname(),
                employeeDTO.getLastname(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentcode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstname(),
                savedEmployee.getLastname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentcode()
        );
        return savedEmployeeDTO;
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        // Communication with rest template
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8081/api/department/"+ employee.getDepartmentcode(),DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();

        //DepartmentDTO departmentDTO = restTemplate.getForObject("http://localhost:8081/api/department/"+ employee.getDepartmentcode(),DepartmentDTO.class);

       // Communication with Api Client
        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentcode());



        // Communication with Web Client
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8081/api/department/"+ employee.getDepartmentcode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();



        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentcode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }
}
