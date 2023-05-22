package com.danven.Employeemicroservice.service;

import com.danven.Employeemicroservice.dto.ApiResponseDto;
import com.danven.Employeemicroservice.dto.DepartmentDto;
import com.danven.Employeemicroservice.dto.EmployeeDto;
import com.danven.Employeemicroservice.entity.Employee;
import com.danven.Employeemicroservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    private ApiClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        System.out.println(employeeDto.getDepartmentCode());
        System.out.println(employee.getDepartmentCode());

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultMethod")
    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:7070/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
////
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:7070/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return new ApiResponseDto(employeeDto, departmentDto);
    }

    public ApiResponseDto getDefaultDepartment(Long employeeId, Exception exception){
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("dep code");
        departmentDto.setDepartmentName("department name");
        departmentDto.setDepartmentDescription("department name");

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return new ApiResponseDto(employeeDto, departmentDto);
    }
}
