package com.danven.Departmentmicroservice.service;

import com.danven.Departmentmicroservice.dto.DepartmentDto;

public interface IDepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByDepartmentCode(String code);
}
