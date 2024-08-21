package com.aksahi.patientMicroService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private Long id;

   @Size(min=3,max=100)
    private String firstName;

    @Size(min=3,max=100)
    private String LastName;

    @Size(min=10,max=10)
    private String phoneNumber;

    private Date dateOfBirth;

    @Email
    private String email;

    private String address;

    private String gender;
}
