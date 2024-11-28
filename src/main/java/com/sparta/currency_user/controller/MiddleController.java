package com.sparta.currency_user.controller;


import com.sparta.currency_user.dto.MiddleRequestDto;
import com.sparta.currency_user.dto.MiddleResponseDto;

import com.sparta.currency_user.dto.UpdateResponseDto;


import com.sparta.currency_user.service.MiddleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/middle")
@RequiredArgsConstructor
public class MiddleController {

    private final MiddleService middleService;

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

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateResponseDto> updateStatus(@PathVariable Long id){
        UpdateResponseDto updateResponseDto = middleService.updateStatus(id);
        return new ResponseEntity<>(updateResponseDto, HttpStatus.OK);


    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        middleService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
