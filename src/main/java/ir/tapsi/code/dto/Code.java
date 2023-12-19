package ir.tapsi.code.dto;

import java.time.LocalDateTime;


public record Code (String code, LocalDateTime expirationDate, Integer percent, Integer amount, String userId) {
}
