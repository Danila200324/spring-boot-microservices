package com.danven.Employeemicroservice.controller;
import com.danven.Employeemicroservice.dto.ApiResponseDto;
import com.danven.Employeemicroservice.dto.EmployeeDto;
import com.danven.Employeemicroservice.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Department controller",
        description = "Department controller exposes rest api for department service"
)
@AllArgsConstructor
@RequestMapping("api/employees")
@RestController
public class EmployeeService {

    private IEmployeeService iEmployeeService;


    @Operation(
            summary = "Save employee",
            description = "Save employee rest api in the db"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(iEmployeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department by id",
            description = "Get department by id from the db"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status created"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getDepartmentByCode(@PathVariable("id") Long id){
        return new ResponseEntity<>(iEmployeeService.getEmployeeById(id), HttpStatus.OK);
    }

}
