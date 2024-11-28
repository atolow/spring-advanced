package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.Middle;
import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiddleRepository extends JpaRepository<Middle, Long> {
    List<Middle> findByUser(User user);
}
