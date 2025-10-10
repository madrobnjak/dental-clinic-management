package md.practice.projects.dentalclinicmanagement.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import md.practice.projects.dentalclinicmanagement.validation.ValidBirthDate;
import md.practice.projects.dentalclinicmanagement.validation.ValidJmbg;
import md.practice.projects.dentalclinicmanagement.validation.ValidPatientData;
import md.practice.projects.dentalclinicmanagement.validation.ValidPhone;

import java.time.LocalDate;
@ValidPatientData(jmbg = "jmbg",birthDate = "birthDate",message = "Birthdate and date from JMBG is not equeal")
public record PatientDTO(
        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String lastName,

        @ValidJmbg
        String jmbg,

        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be in the past")
        @ValidBirthDate
        LocalDate dateOfBirth,

        @NotBlank(message = "Phone is required")
        @ValidPhone
        String phone,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        String address,

        @Size(max = 1000, message = "Medical history must be less than 1000 characters")
        String medicalHistory
) {
}
