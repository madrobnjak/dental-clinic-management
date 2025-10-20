package md.practice.projects.dentalclinicmanagement.dto;

import jakarta.validation.constraints.Size;

public record PatientSearchDTO(
        String jmbg,

        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String firstName,

        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String lastName,

        String phone
) {
}
