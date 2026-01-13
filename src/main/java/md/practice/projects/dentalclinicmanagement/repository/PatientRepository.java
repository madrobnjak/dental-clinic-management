package md.practice.projects.dentalclinicmanagement.repository;

import md.practice.projects.dentalclinicmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

    boolean existsByJmbg(Long jmbg);
    boolean existsByEmail(String email);
}
