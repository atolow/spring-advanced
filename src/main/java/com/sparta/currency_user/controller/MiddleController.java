package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.dto.MiddleResponseDto;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.MiddleRepository;
import com.sparta.currency_user.repository.UserRepository;
import com.sparta.currency_user.service.CurrencyService;
import com.sparta.currency_user.service.MiddleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/middle")
@RequiredArgsConstructor
public class MiddleController {

    private final MiddleService middleService;

    @GetMapping
    public ResponseEntity<List<MiddleResponseDto>> findMiddle() {
        return ResponseEntity.ok().body(middleService.findAll());
    }

    @PostMapping
    public ResponseEntity<MiddleResponseDto> save(
            @RequestBody MiddleResponseDto responseDto) {
        return ResponseEntity.ok().body(middleService.save(responseDto));

    }
}
