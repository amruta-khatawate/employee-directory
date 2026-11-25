package com.example.employee_directory_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NotNull
    private String firstName;
    private String lastName;
    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String phone;
    private String department;
    private String designation;
    @Positive
    private BigDecimal salary;
    private Date joinDate;
    private String status;
    private String location;
    private Integer managerId;
    private String avatar;

}
