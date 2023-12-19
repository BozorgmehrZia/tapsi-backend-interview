package ir.tapsi.code.service;

import ir.tapsi.code.dto.Code;
import ir.tapsi.code.dto.CreateCodeDto;
import ir.tapsi.code.validators.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CodeService {
    private static final int LENGTH = 5;
    private final List<Code> codes;
    private final List<Validator> validators;

    public CodeService(final List<Validator> validators) {
        this.validators = validators;
        this.codes = new ArrayList<>();
    }

    public List<Code> getAllCodes() {
        return codes.stream().filter(x -> x.expirationDate().isAfter(LocalDateTime.now())).collect(Collectors.toList());
    }

    public ResponseEntity<String> addCode(final CreateCodeDto dto) {
        Optional<Validator> firstException = validators.stream().filter(x -> !x.validate(dto)).findFirst();
        if (firstException.isPresent()) {
            return ResponseEntity.internalServerError().body(firstException.get().getMessage());
        }
        Code code = new Code(getRandomString(),
                             LocalDateTime.now().plusDays(dto.getExpirationDays()),
                             dto.getPercent(),
                             dto.getAmount(),
                             dto.getUserId());
        codes.add(code);
        return ResponseEntity.ok(code.code());
    }

    private String getRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < LENGTH) {
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();

    }
}
