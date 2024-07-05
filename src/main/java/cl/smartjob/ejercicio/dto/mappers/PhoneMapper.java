package cl.smartjob.ejercicio.dto.mappers;

import cl.smartjob.ejercicio.domain.entities.Phone;
import cl.smartjob.ejercicio.dto.requests.PhoneRequest;
import cl.smartjob.ejercicio.dto.responses.PhoneResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PhoneMapper {
    Phone requestToEntity(PhoneRequest phoneRequest);
    PhoneResponse entityToResponse(Phone phone);
}
