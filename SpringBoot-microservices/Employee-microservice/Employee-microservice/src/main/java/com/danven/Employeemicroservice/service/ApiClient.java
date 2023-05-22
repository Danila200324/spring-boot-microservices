package com.danven.Employeemicroservice.service;

import com.danven.Employeemicroservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
