package ir.tapsi.code.validators;

import ir.tapsi.code.dto.CreateCodeDto;
import org.springframework.stereotype.Component;

@Component
public class PercentValidatorImpl implements Validator {
    @Override
    public boolean validate(CreateCodeDto dto) {
        if (dto.getPercent() != null) {
            return dto.getPercent() > 0 && dto.getPercent() < 100;
        }
        return true;
    }

    @Override
    public String getMessage() {
        return "percent should be between 0 and 100";
    }
}
