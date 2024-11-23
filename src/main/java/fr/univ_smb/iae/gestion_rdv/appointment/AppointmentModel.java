package fr.univ_smb.iae.gestion_rdv.appointment;



import java.time.LocalDateTime;
import java.util.Objects;

public class AppointmentModel {
    private Long id;
    private Long doctorId;
    private LocalDateTime dateTime;
    private String patientName;
    private String status; // e.g., "Scheduled", "Cancelled"

    // Getters
    public Long getId() {
        return id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString
    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", dateTime=" + dateTime +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentModel that = (AppointmentModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, dateTime, patientName, status);
    }
}
