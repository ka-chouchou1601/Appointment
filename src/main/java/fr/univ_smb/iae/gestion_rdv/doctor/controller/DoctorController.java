package fr.univ_smb.iae.gestion_rdv.doctor.controller;

import fr.univ_smb.iae.gestion_rdv.doctor.DoctorModel;
import fr.univ_smb.iae.gestion_rdv.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorModel> getDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public DoctorModel addDoctor(@RequestBody DoctorModel doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping("/{id}/availability")
    public void updateAvailability(@PathVariable Long id, @RequestParam boolean availability) {
        doctorService.updateAvailability(id, availability);
    }
}
