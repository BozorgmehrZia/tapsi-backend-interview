package ir.tapsi.code.validators;

import ir.tapsi.code.dto.CreateCodeDto;
import org.springframework.stereotype.Component;

@Component
public class AmountValidatorImpl implements Validator {
    @Override
    public boolean validate(CreateCodeDto dto) {
        if (dto.getAmount() != null) {
            return dto.getAmount() > 0;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return "amount should be positive!";
    }
}
