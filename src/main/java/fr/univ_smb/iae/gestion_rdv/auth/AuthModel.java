package fr.univ_smb.iae.gestion_rdv.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auth") // MongoDB collection for authentication
public class AuthModel {
    @Id
    private String id; // MongoDB-generated unique identifier
    private String email;
    private String password;
    private String role; // e.g., "DOCTOR" or "PATIENT"

    // Constructors
    public AuthModel() {}

    public AuthModel(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
