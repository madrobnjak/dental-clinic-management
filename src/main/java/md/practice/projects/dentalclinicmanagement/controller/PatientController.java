package md.practice.projects.dentalclinicmanagement.controller;

import jakarta.validation.Valid;
import md.practice.projects.dentalclinicmanagement.dto.PatientDTO;
import md.practice.projects.dentalclinicmanagement.dto.PatientSearchDTO;
import md.practice.projects.dentalclinicmanagement.entity.Patient;
import md.practice.projects.dentalclinicmanagement.mapper.EntityMapper;
import md.practice.projects.dentalclinicmanagement.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    private final PatientService patientService;
    private final EntityMapper entityMapper;

    public PatientController(PatientService patientService, EntityMapper entityMapper) {
        this.patientService = patientService;
        this.entityMapper = entityMapper;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        Patient patient = entityMapper.mappDTOtoEntity(patientDTO);
        log.info("Creating a new patient with id {}", patient.toString());
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @GetMapping("searchBy/")
    public ResponseEntity<List<Patient>> getPatientsBy(@Valid @RequestBody PatientSearchDTO searchDTO) {
        Patient patient=entityMapper.mappDTOtoEntity(searchDTO);
        List<Patient> patients=patientService.searchPatients(patient);
        return ResponseEntity.ok(patients);
    }

}
