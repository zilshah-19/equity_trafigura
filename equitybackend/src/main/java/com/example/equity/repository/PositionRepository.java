package com.example.equity.repository;

import com.example.equity.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {
    Optional<Position> findByTransactionIdAndSymbol(Integer transactionId, String symbol);
}
