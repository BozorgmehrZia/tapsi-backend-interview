package ir.tapsi.code.validators;

import ir.tapsi.code.dto.CreateCodeDto;

public interface Validator {
    boolean validate(CreateCodeDto dto);
    String getMessage();
}
