package cl.smartjob.ejercicio.api.dto.mappers;

import cl.smartjob.ejercicio.api.dto.requests.UserRequest;
import cl.smartjob.ejercicio.api.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.api.dto.responses.UserResponse;
import cl.smartjob.ejercicio.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User requestToEntity(UserRequest userRequest);
    UserResponse entityToResponse(User user);
    AuthResponse entityToAuthResponse(User user);
}
