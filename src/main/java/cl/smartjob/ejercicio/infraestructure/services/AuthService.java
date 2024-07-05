package cl.smartjob.ejercicio.infraestructure.services;

import cl.smartjob.ejercicio.dto.requests.LoginRequest;
import cl.smartjob.ejercicio.dto.responses.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
}
