package cl.smartjob.ejercicio.api.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhoneRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(example = "1234567", required = true)
    @NotNull(message = "El campo numero no puede ser nulo")
    @Positive(message = "El campo numero debe ser un entero valido")
    private Integer number;
    @Schema(example = "1", required = true)
    @NotNull(message = "El campo codigo de ciudad no puede ser nulo")
    @Positive(message = "El campo codigo de ciudad debe ser un entero valido")
    private Integer cityCode;
    @Schema(example = "56", required = true)
    @NotNull(message = "El campo codigo de pais no puede ser nulo")
    @Positive(message = "El campo codigo de pais debe ser un entero valido")
    private Integer contryCode;

}
