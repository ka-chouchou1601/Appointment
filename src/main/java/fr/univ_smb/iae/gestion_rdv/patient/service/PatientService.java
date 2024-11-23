package fr.univ_smb.iae.gestion_rdv.patient.service;

import fr.univ_smb.iae.gestion_rdv.patient.PatientModel;
import fr.univ_smb.iae.gestion_rdv.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientModel getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public PatientModel createPatient(PatientModel patient) {
        return patientRepository.save(patient);
    }

    public PatientModel updatePatient(String id, PatientModel updatedPatient) {
        PatientModel existingPatient = getPatientById(id);
        if (existingPatient != null) {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
            return patientRepository.save(existingPatient);
        }
        return null;
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
