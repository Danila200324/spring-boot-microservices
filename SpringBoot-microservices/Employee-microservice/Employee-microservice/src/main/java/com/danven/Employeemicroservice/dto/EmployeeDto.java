package com.danven.Employeemicroservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(
        description = "Employee"
)
public class EmployeeDto {
    @Schema(
            name = "Employee id"
    )
    private Long id;

    @Schema(
            name = "Employee first name"
    )
    private String firstName;

    @Schema(
            name = "Employee last name"
    )
    private String lastName;

    @Schema(
            name = "Employee email"
    )
    private String email;

    @Schema(
            name = "Department code"
    )
    private String departmentCode;
}
