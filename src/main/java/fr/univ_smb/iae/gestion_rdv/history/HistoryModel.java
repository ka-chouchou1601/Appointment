package fr.univ_smb.iae.gestion_rdv.history;

import java.time.LocalDateTime;
import java.util.Objects;

public class HistoryModel {
    private Long id;
    private String patientName;
    private String doctorName; // Updated to store the doctor's name
    private LocalDateTime dateTime;
    private String status; // "Completed", "Cancelled"

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // toString
    @Override
    public String toString() {
        return "HistoryModel{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryModel that = (HistoryModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, doctorName, dateTime, status);
    }
}
