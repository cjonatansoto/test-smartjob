package cl.smartjob.ejercicio.infraestructure.services;

import cl.smartjob.ejercicio.api.dto.requests.UserRequest;
import cl.smartjob.ejercicio.api.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.api.dto.responses.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> findAll();
    AuthResponse register(UserRequest userRequest);
    UserResponse created(UserRequest userRequest);
    UserResponse show(UUID id);
    void delete(UUID id);
}
