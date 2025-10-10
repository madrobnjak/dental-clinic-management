package md.practice.projects.dentalclinicmanagement.dto;

import java.time.LocalDateTime;

import java.util.Map;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        Map<String, String> errors,
        String path
) {
}
