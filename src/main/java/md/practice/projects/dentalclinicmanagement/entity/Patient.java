package md.practice.projects.dentalclinicmanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, length = 13)
    private Long jmbg;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    private String address;
    @Column(length = 1000)
    private String medicalHistory;

    public Patient(Long id, String firstName, String lastName, Long jmbg, LocalDate dateOfBirth, String phone, String email, String address, String medicalHistory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.medicalHistory = medicalHistory;
    }

    public Long getJmbg() {
        return jmbg;
    }

    public void setJmbg(Long jmbg) {
        this.jmbg = jmbg;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
