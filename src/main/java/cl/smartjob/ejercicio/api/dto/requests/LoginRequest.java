package cl.smartjob.ejercicio.api.dto.requests;

import cl.smartjob.ejercicio.util.CoreConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(example = "aaaaaaa@dominio.cl", required = true)
    @NotNull(message = "{email.El campo correo electronico no puede ser nulo}")
    @NotEmpty(message = "{email.El campo correo electronico no puede estar vacio}")
    @Pattern(regexp = CoreConstants.RGX_EMAIL, message = "{email.El campo correo electronico no admite formato}")
    private String email;
    @Schema(example = "12345678", required = true)
    @NotNull(message = "{password.El campo contraseña no puede ser nulo}")
    @NotEmpty(message = "{password.El campo contraseña no puede estar vacio}")
    @Min(8)
    private String password;
}