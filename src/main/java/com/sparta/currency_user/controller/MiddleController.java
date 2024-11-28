package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.MiddleRequestDto;
import com.sparta.currency_user.dto.MiddleResponseDto;

import com.sparta.currency_user.dto.UpdateResponseDto;
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
        List<MiddleResponseDto> allList = middleService.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MiddleResponseDto> save(
            @RequestBody MiddleRequestDto requestDto) {
        MiddleResponseDto save = middleService.save(requestDto);
        return new ResponseEntity<>(save,HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<MiddleResponseDto>> findMiddleListByUserId(@PathVariable Long userId) {
        List<MiddleResponseDto> exchangeList = middleService.getMiddleList(userId);
        return new ResponseEntity<>(exchangeList,HttpStatus.OK);
    }

    @PatchMapping("/id")
    public ResponseEntity<UpdateResponseDto> updateStatus(@PathVariable Long middleId){
        UpdateResponseDto updateResponseDto = middleService.updateStatus(middleId);
        return new ResponseEntity<>(updateResponseDto, HttpStatus.OK);


    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        middleService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
