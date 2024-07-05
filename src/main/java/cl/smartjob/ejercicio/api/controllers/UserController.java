package cl.smartjob.ejercicio.api.controllers;

import cl.smartjob.ejercicio.api.dto.requests.UserRequest;
import cl.smartjob.ejercicio.api.dto.responses.UserResponse;
import cl.smartjob.ejercicio.infraestructure.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.SecurityMarker;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "users")
@Tag(name = "User")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "List Users", description = "List Users")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("all")
    public ResponseEntity<List<UserResponse>> findAll() {
        //todos los usuarios
        return ResponseEntity.ok(this.userService.findAll());
    }

    @Operation(summary = "Created new User", description = "Created new User")
    @SecurityMarker
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("save")
    public ResponseEntity<UserResponse> created(@Valid @RequestBody UserRequest userRequest) {
        // crear usuario
        return ResponseEntity.ok(this.userService.created(userRequest));
    }

    @Operation(summary = "Show user", description = "Show user")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(path = "show/{id}")
    public ResponseEntity<UserResponse> show(@PathVariable UUID id) {
        //ver usuario con telefonos
        return ResponseEntity.ok(this.userService.show(id));
    }

    @Operation(summary = "Delete user", description = "Delete user")
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        //borrado suave afecta columna is_active la deja en false!
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
