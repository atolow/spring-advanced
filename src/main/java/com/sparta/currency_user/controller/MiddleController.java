package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.MiddleRequestDto;
import com.sparta.currency_user.dto.MiddleResponseDto;

import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.error.UserNotFoundException;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;

import com.sparta.currency_user.service.MiddleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/middle")
@RequiredArgsConstructor
public class MiddleController {

    private final MiddleService middleService;
    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<MiddleResponseDto>> findMiddle() {
        return ResponseEntity.ok().body(middleService.findAll());
    }

    @PostMapping
    public ResponseEntity<MiddleResponseDto> save(
            @RequestBody MiddleRequestDto requestDto) {
        return ResponseEntity.ok().body(middleService.save(requestDto));

    }

    @GetMapping("/{userId}")
    public List<MiddleResponseDto> findExchangeListByUserId(@PathVariable Long userId) {
        return middleService.getExchangeList(userId);
    }




    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        middleService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
