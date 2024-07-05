package cl.smartjob.ejercicio.dto.mappers;

import cl.smartjob.ejercicio.domain.entities.User;
import cl.smartjob.ejercicio.dto.requests.UserRequest;
import cl.smartjob.ejercicio.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.dto.responses.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User requestToEntity(UserRequest userRequest);
    UserResponse entityToResponse(User user);
    AuthResponse entityToAuthResponse(User user);
}
