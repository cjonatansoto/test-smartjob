package cl.smartjob.ejercicio.util.validations;

import cl.smartjob.ejercicio.domain.repositories.UserRepository;
import cl.smartjob.ejercicio.util.validations.annotations.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return userRepository.findByEmail(field).isPresent() ? false : true;
    }
}
