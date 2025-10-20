package md.practice.projects.dentalclinicmanagement.helper;

import org.springframework.stereotype.Component;

@Component
public class NormalizeEmail {
    public String doNormalize(String email) {
        if (email == null) {
            return null;
        }
        return email.trim().toLowerCase();
    }
}
