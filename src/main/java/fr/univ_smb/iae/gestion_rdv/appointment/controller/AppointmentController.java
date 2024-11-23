package fr.univ_smb.iae.gestion_rdv.appointment.controller;

import fr.univ_smb.iae.gestion_rdv.appointment.AppointmentModel;
import fr.univ_smb.iae.gestion_rdv.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentModel> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public AppointmentModel createAppointment(@RequestBody AppointmentModel appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
}
