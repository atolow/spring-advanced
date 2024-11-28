package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.Middle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiddleRepository extends JpaRepository<Middle, Long> {
}
