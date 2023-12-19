package ir.tapsi.code.controller;

import ir.tapsi.code.dto.Code;
import ir.tapsi.code.dto.CreateCodeDto;
import ir.tapsi.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CodeController {
    private final CodeService service;

    @GetMapping("api/v1/code")
    public ResponseEntity<List<Code>> getAllCodes() {
        return ResponseEntity.ok(service.getAllCodes());
    }

    @PostMapping("api/v1/code")
    public ResponseEntity<String> addCode(@RequestBody CreateCodeDto dto) {
        return service.addCode(dto);
    }
}
