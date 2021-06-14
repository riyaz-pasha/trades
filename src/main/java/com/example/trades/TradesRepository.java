package com.example.trades;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradesRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByType(String type);

    List<Trade> findByUserId(Long userId);

    List<Trade> findByTypeAndUserId(String type, Long userId);
}
