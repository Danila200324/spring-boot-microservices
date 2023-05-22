package com.danven.Departmentmicroservice.controller;

import com.danven.Departmentmicroservice.dto.DepartmentDto;
import com.danven.Departmentmicroservice.service.IDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department controller",
        description = "Department controller"
)
@AllArgsConstructor
@RequestMapping("api/departments")
@RestController
public class DepartmentController {

    private IDepartmentService iDepartmentService;


    @Operation(
            summary = "Save department",
            description = "Save department in the db"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status created"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(iDepartmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department by code",
            description = "Get department by code from the db"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 OK"
    )
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code){
        return new ResponseEntity<>(iDepartmentService.getDepartmentByDepartmentCode(code), HttpStatus.OK);
    }

}
