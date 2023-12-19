package ir.tapsi.code.validators;

import ir.tapsi.code.dto.CreateCodeDto;
import org.springframework.stereotype.Component;

@Component
public class TypeValidatorImpl implements Validator {
    @Override
    public boolean validate(CreateCodeDto dto) {
        return (dto.getPercent() != null && dto.getAmount() == null)
                || (dto.getPercent() == null && dto.getAmount() != null);
    }

    @Override
    public String getMessage() {
        return "Type should be amount or percent!";
    }
}
