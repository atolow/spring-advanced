package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyRequestDto;
import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.dto.MiddleResponseDto;
import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
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
        return middleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("통화를 찾을 수 없습니다."));
    }
    public List<MiddleResponseDto> findAll() {
        return middleRepository.findAll().stream().map(MiddleResponseDto::toDto).toList();
    }
    public MiddleResponseDto save(MiddleResponseDto dto){
        User findUser = userRepository.findById(dto.getUser().getId())
                .orElseThrow(UserNotFoundException::new);
        Currency findCurrency = currencyRepository.findById(dto.getCurrency().getId())
                .orElseThrow(UserNotFoundException::new);

        BigDecimal amountInKrw = dto.getAmount_in_krw();
        BigDecimal exchangeRate = findCurrency.getExchangeRate();

        BigDecimal middleAmount = amountInKrw.divide(exchangeRate, 2, RoundingMode.HALF_UP);

        Middle middle = new Middle(findCurrency,findUser,dto.getAmount_in_krw(),middleAmount, Middle.MiddleStatus.NORMAL);

        Middle result = middleRepository.save(middle);

        return new MiddleResponseDto(result);
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        userRepository.deleteById(user.getId());
    }


}
