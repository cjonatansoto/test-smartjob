package cl.smartjob.ejercicio.dto.requests;

import cl.smartjob.ejercicio.util.CoreConstants;
import cl.smartjob.ejercicio.util.validations.annotations.UniqueEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(example = "Juan Rodriguez", required = true)
    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    private String name;
    @Schema(example = "juan@dominio.cl", required = true)
    @NotNull(message = "{email.El campo correo electronico no puede ser nulo}")
    @NotEmpty(message = "{email.El campo correo electronico no puede estar vacio}")
    @Pattern(regexp = CoreConstants.RGX_EMAIL, message = "{email.El campo correo electronico no admite formato}")
    @UniqueEmail(message = "{email.El campo correo electronico ya se encuentra registrado}")
    private String email;
    @Schema(example = "12345678", required = true)
    @NotNull(message = "El campo contraseña no puede ser nulo")
    @NotEmpty(message = "El campo contraseña no puede estar vacio")
    private String password;
    @NotNull(message = "Lista vacia, se debe enviar por lo menos un numero de telefono")
    @Valid
    private List<PhoneRequest> phones;
}
