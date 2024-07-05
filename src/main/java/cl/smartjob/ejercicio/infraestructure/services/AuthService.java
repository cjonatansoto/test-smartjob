package cl.smartjob.ejercicio.infraestructure.services;

import cl.smartjob.ejercicio.api.dto.requests.LoginRequest;
import cl.smartjob.ejercicio.api.dto.responses.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
}
