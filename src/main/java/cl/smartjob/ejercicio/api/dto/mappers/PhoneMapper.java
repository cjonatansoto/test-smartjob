package cl.smartjob.ejercicio.api.dto.mappers;

import cl.smartjob.ejercicio.api.dto.requests.PhoneRequest;
import cl.smartjob.ejercicio.api.dto.responses.PhoneResponse;
import cl.smartjob.ejercicio.domain.entities.Phone;
import org.mapstruct.Mapper;

@Mapper
public interface PhoneMapper {
    Phone requestToEntity(PhoneRequest phoneRequest);
    PhoneResponse entityToResponse(Phone phone);
}
