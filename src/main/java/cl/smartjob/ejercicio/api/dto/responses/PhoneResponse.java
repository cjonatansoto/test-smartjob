package cl.smartjob.ejercicio.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhoneResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer number;
    private Integer cityCode;
    private Integer contryCode;

}
