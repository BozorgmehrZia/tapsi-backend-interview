package ir.tapsi.code.validators;

import ir.tapsi.code.dto.CreateCodeDto;
import org.springframework.stereotype.Component;

@Component
public class ExpirationDaysValidatorImpl implements Validator {
    @Override
    public boolean validate(CreateCodeDto dto) {
        return dto.getExpirationDays() > 0;
    }

    @Override
    public String getMessage() {
        return "expiration days should be positive!";
    }
}
