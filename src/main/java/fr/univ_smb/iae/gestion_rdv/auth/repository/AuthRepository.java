package fr.univ_smb.iae.gestion_rdv.auth.repository;

import fr.univ_smb.iae.gestion_rdv.auth.AuthModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<AuthModel, String> {
    // Find a user by role and email
    AuthModel findByRoleAndEmail(String role, String email);

    // Find a user by email
    AuthModel findByEmail(String email);
}
