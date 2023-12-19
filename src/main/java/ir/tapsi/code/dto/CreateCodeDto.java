package ir.tapsi.code.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class CreateCodeDto {
    private String userId;
    private int expirationDays;
    private Integer percent;
    private Integer amount;
}
