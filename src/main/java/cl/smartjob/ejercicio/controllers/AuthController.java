package cl.smartjob.ejercicio.controllers;

import cl.smartjob.ejercicio.dto.requests.LoginRequest;
import cl.smartjob.ejercicio.dto.requests.UserRequest;
import cl.smartjob.ejercicio.dto.responses.AuthResponse;
import cl.smartjob.ejercicio.infraestructure.services.AuthService;
import cl.smartjob.ejercicio.infraestructure.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
@Tag(name = "Auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Operation(summary = "Register", description = "Register user")
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> created(@Valid @RequestBody UserRequest userRequest) {
        //nuevo registro y devuelve token
        return ResponseEntity.ok(this.userService.register(userRequest));
    }

    @Operation(summary = "Login", description = "Login user")
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        //login
        return ResponseEntity.ok(authService.login(request));
    }

}
