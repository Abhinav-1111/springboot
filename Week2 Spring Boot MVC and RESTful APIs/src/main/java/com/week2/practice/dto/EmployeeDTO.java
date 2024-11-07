package com.week2.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.week2.practice.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name of the employee can not be blank")
    @Size(min = 3, max = 10 , message = "Numbers in characters in name should be in range between 3 and 10")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the Employee cannot be blank" )
    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of the Employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role; // ADMIN OR USER

    @NotNull(message = "Salary of the Employee should not be null")
    @Positive(message = "Salary of the Employee should be Positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.XX")
    @DecimalMax(value = "10000.99", message = "Salary should not be greater than XXXXX.XX")
    @DecimalMin(value = "99.99", message = "Salary should not be less than XX.XX")
    private Double Salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
