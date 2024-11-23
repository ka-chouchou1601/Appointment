package fr.univ_smb.iae.gestion_rdv.doctor.service;

import fr.univ_smb.iae.gestion_rdv.doctor.DoctorModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private final List<DoctorModel> doctors = new ArrayList<>();

    public List<DoctorModel> getAllDoctors() {
        return doctors;
    }

    public DoctorModel addDoctor(DoctorModel doctor) {
        doctors.add(doctor);
        return doctor;
    }

    public void updateAvailability(Long id, boolean availability) {
        doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .ifPresent(doctor -> doctor.setAvailable(availability));
    }
}
