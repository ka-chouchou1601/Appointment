package fr.univ_smb.iae.gestion_rdv.auth.service;

import fr.univ_smb.iae.gestion_rdv.auth.AuthModel;
import fr.univ_smb.iae.gestion_rdv.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new user
    public AuthModel registerUser(String role, String email, String rawPassword) {
        if (authRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email is already registered");
        }
        AuthModel authModel = new AuthModel(email, passwordEncoder.encode(rawPassword), role);
        return authRepository.save(authModel);
    }

    // Login an existing user
    public AuthModel loginUser(String role, String email, String rawPassword) {
        AuthModel authModel = authRepository.findByRoleAndEmail(role, email);
        if (authModel == null || !passwordEncoder.matches(rawPassword, authModel.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return authModel;
    }
}
