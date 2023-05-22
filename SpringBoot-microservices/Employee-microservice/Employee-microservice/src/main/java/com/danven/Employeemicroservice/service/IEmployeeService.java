package com.danven.Employeemicroservice.service;

import com.danven.Employeemicroservice.dto.ApiResponseDto;
import com.danven.Employeemicroservice.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long employeeId);
}
