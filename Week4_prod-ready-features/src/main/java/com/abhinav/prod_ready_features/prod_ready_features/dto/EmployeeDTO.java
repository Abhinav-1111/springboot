package com.abhinav.prod_ready_features.prod_ready_features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String role; // ADMIN OR USER

    private Double Salary;

    private LocalDate dateOfJoining;

    private Boolean isActive;
}
