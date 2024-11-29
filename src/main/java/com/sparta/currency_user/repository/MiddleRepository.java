package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.MiddleSummaryResponseDto;
import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiddleRepository extends JpaRepository<Middle, Long> {
    List<Middle> findByUser(User user);

    @Query("SELECT new com.sparta.currency_user.dto.MiddleSummaryResponseDto(" +
            "m.user.id, COUNT(m), SUM(m.amount_in_krw)) " +
            "FROM Middle m " +
            "WHERE m.user.id = :userId AND m.status = 'NORMAL' " +
            "GROUP BY m.user")
    List<MiddleSummaryResponseDto> getMiddleSummaryByUser(@Param("userId") Long userId);
}
