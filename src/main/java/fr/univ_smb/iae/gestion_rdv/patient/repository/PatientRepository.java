package fr.univ_smb.iae.gestion_rdv.patient.repository;



import fr.univ_smb.iae.gestion_rdv.patient.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<PatientModel, String> {
    // Custom query method
    PatientModel findByEmail(String email);
}
