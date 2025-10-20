package md.practice.projects.dentalclinicmanagement.specification;

import md.practice.projects.dentalclinicmanagement.entity.Patient;

import org.springframework.data.jpa.domain.Specification;

public class PatientSpecification {
    public static Specification<Patient> hasEmail(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isEmpty()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("email"), email);
        };
    }

    public static Specification<Patient> hasJmbg(Long jmbg) {
        return (root, query, cb) -> {
            if (jmbg == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("jmbg"), jmbg);
        };
    }

    public static Specification<Patient> hasPhone(String phone) {
        return (root, query, cb) -> {
            if (phone == null || phone.isEmpty()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("phone"), phone);
        };
    }

    public static Specification<Patient> firstNameContains(String firstName) {
        return (root, query, cb) -> {
            if (firstName == null || firstName.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
        };
    }

    public static Specification<Patient> lastNameContains(String lastName) {
        return (root, query, cb) -> {
            if (lastName == null || lastName.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
        };
    }
}
