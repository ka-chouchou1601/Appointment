package fr.univ_smb.iae.gestion_rdv.patient.controller;

import fr.univ_smb.iae.gestion_rdv.patient.PatientModel;
import fr.univ_smb.iae.gestion_rdv.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientModel> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getPatientById(@PathVariable String id) {
        PatientModel patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PatientModel createPatient(@RequestBody PatientModel patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable String id, @RequestBody PatientModel updatedPatient) {
        PatientModel patient = patientService.updatePatient(id, updatedPatient);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
