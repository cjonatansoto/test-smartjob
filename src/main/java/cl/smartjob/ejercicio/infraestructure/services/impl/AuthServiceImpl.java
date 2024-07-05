package cl.smartjob.ejercicio.infraestructure.services.impl;

import cl.smartjob.ejercicio.domain.repositories.UserRepository;
import cl.smartjob.ejercicio.dto.requests.LoginRequest;
import cl.smartjob.ejercicio.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.infraestructure.jwt.JwtService;
import cl.smartjob.ejercicio.infraestructure.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.getToken(user);
        return AuthResponse
                .builder()
                .id(user.getId().toString())
                .name(user.getName())
                .email(user.getEmail())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getLastLogin())
                .token(token)
                .isActive(user.getIsActive())
                .build();
    }
}
