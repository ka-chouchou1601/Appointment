package fr.univ_smb.iae.gestion_rdv.auth.controller;

import fr.univ_smb.iae.gestion_rdv.auth.AuthModel;
import fr.univ_smb.iae.gestion_rdv.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<AuthModel> registerUser(
            @RequestParam String role,
            @RequestParam String email,
            @RequestParam String password) {
        return ResponseEntity.ok(authService.registerUser(role, email, password));
    }

    // Endpoint to login a user
    @PostMapping("/login")
    public ResponseEntity<AuthModel> loginUser(
            @RequestParam String role,
            @RequestParam String email,
            @RequestParam String password) {
        return ResponseEntity.ok(authService.loginUser(role, email, password));
    }
}
