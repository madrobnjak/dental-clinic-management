package md.practice.projects.dentalclinicmanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        List<String> message,
        String path
) {
}
