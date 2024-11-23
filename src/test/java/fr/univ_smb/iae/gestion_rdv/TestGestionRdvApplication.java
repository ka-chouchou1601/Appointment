package fr.univ_smb.iae.gestion_rdv;

import org.springframework.boot.SpringApplication;

public class TestGestionRdvApplication {

	public static void main(String[] args) {
		SpringApplication.from(GestionRdvApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
