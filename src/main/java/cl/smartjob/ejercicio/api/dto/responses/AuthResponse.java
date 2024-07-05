package cl.smartjob.ejercicio.api.dto.responses;

import cl.smartjob.ejercicio.util.CoreConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CoreConstants.DATE_FORMAT_DD_MM_YYYY_HH_MM_SS)
    private LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CoreConstants.DATE_FORMAT_DD_MM_YYYY_HH_MM_SS)
    private LocalDateTime modified;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CoreConstants.DATE_FORMAT_DD_MM_YYYY_HH_MM_SS)
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
}
