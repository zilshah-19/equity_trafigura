package com.example.equity.controller;


import com.example.equity.TransactionService;
import com.example.equity.entity.Position;
import com.example.equity.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trade")
public class TradeController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Position> createTrade(@RequestBody Transaction transaction) {
        Position position = transactionService.processtransaction(transaction);
        return ResponseEntity.ok(position);
    }

    @GetMapping("/positions/{transactionId}")
    public List<Position> getPositions(@PathVariable String transactionId) {
        return transactionService.getAllPositionsForTransaction(transactionId);
    }
}
