package fr.univ_smb.iae.gestion_rdv.appointment.repository;

import fr.univ_smb.iae.gestion_rdv.appointment.AppointmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<AppointmentModel, Long> {
    // Find all appointments by doctor ID
    List<AppointmentModel> findByDoctorId(Long doctorId);

    // Find all appointments by patient name
    List<AppointmentModel> findByPatientName(String patientName);

    // Find all appointments by status
    List<AppointmentModel> findByStatus(String status);

    // Find all appointments on a specific date and time
    List<AppointmentModel> findByDateTime(LocalDateTime dateTime);

    // Find all appointments within a date range
    List<AppointmentModel> findByDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
