package md.practice.projects.dentalclinicmanagement.controller;

import jakarta.validation.Valid;
import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;
import md.practice.projects.dentalclinicmanagement.entity.Patient;
import md.practice.projects.dentalclinicmanagement.mapper.EntityMapper;
import md.practice.projects.dentalclinicmanagement.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;
    private final EntityMapper entityMapper;

    public PatientController(PatientService patientService, EntityMapper entityMapper) {
        this.patientService = patientService;
        this.entityMapper = entityMapper;
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllProducts() {
        return ResponseEntity.ok(patientService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientId(id));
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        Patient patient = entityMapper.mappDTOtoEntity(patientDTO);
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateProduct(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        Patient patientDetailsNew = entityMapper.mappDTOtoEntity(patientDTO);
        return ResponseEntity.ok(patientService.updatePatient(id, patientDetailsNew));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
