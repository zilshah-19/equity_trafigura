package com.example.equity.repository;

import com.example.equity.entity.Position;
import com.example.equity.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> { }

