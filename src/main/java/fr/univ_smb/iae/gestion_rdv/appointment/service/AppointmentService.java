package fr.univ_smb.iae.gestion_rdv.appointment.service;

import org.springframework.stereotype.Service;
import fr.univ_smb.iae.gestion_rdv.appointment.AppointmentModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final List<AppointmentModel> appointments = new ArrayList<>();

    public List<AppointmentModel> getAllAppointments() {
        return appointments;
    }

    public AppointmentModel createAppointment(AppointmentModel appointment) {
        appointments.add(appointment);
        return appointment;
    }

    public void cancelAppointment(Long id) {
        appointments.removeIf(appointment -> appointment.getId().equals(id));
    }
}
