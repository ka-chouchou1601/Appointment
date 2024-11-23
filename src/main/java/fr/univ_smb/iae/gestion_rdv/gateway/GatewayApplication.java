package fr.univ_smb.iae.gestion_rdv.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * Configures routing for the API Gateway.
     * This method defines routes for the different services in the application.
     */
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route to Appointment Service
                .route("appointment-service", r -> r.path("/appointments/**")
                        .uri("http://localhost:8081")) // Replace with actual service URL

                // Route to Doctor Service
                .route("doctor-service", r -> r.path("/doctors/**")
                        .uri("http://localhost:8082")) // Replace with actual service URL

                // Route to History Service
                .route("history-service", r -> r.path("/history/**")
                        .uri("http://localhost:8083")) // Replace with actual service URL

                // Route to Authentication Service
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("http://localhost:8084")) // Replace with actual service URL

                .build();
    }
}
