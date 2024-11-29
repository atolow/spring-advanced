package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.*;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.error.DataNotFoundException;
import com.sparta.currency_user.error.UserNotFoundException;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.MiddleRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MiddleService {
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final MiddleRepository middleRepository;

    public MiddleResponseDto findById(Long id) {
        return new MiddleResponseDto(findMiddleById(id));
    }

    public Middle findMiddleById(Long id) {
        return middleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("middle 를 찾을 수 없습니다."));
    }
    public List<MiddleResponseDto> findAll() {
        return middleRepository.findAll().stream().map(MiddleResponseDto::toDto).toList();
    }
    public MiddleResponseDto save(MiddleRequestDto dto){
        User findUser = userRepository.findById(dto.getUser())
                .orElseThrow(UserNotFoundException::new);
        Currency findCurrency = currencyRepository.findById(dto.getCurrency())
                .orElseThrow(UserNotFoundException::new);

        BigDecimal amountInKrw = dto.getAmount_in_krw();
        BigDecimal exchangeRate = findCurrency.getExchangeRate();

        BigDecimal middleAmount = amountInKrw.divide(exchangeRate, 2, RoundingMode.HALF_UP);

        Middle middle = new Middle(findCurrency,findUser,dto.getAmount_in_krw(),middleAmount, Middle.MiddleStatus.NORMAL);

        Middle result = middleRepository.save(middle);

        return new MiddleResponseDto(result);
    }


    public List<MiddleResponseDto> getMiddleList(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        List<Middle> middle = middleRepository.findByUser(user);

        if (middle.isEmpty()) {
            throw new DataNotFoundException();
        }

        return middle.stream().map(MiddleResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public UpdateResponseDto updateStatus(Long middleId) {

        Middle middle = middleRepository.findById(middleId).orElseThrow(() -> new IllegalArgumentException("통화를 찾을 수 없습니다."));
        middle.changeStatusCancelled();

        return new UpdateResponseDto(middle);

    }

    public List<MiddleSummaryResponseDto> getMiddleSummaryList(Long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }

        if (middleRepository.getMiddleSummaryByUser(userId).isEmpty()) {
            throw new DataNotFoundException();
        }

        return middleRepository.getMiddleSummaryByUser(userId);
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        userRepository.deleteById(user.getId());
    }


}
