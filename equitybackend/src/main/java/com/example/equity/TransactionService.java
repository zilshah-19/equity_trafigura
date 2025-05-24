package com.example.equity;

import com.example.equity.entity.Position;
import com.example.equity.entity.Transaction;
import com.example.equity.repository.PositionRepository;
import com.example.equity.repository.TransactionRepository;
import com.example.equity.util.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private PositionRepository positionRepo;

    @Transactional
    public Position processtransaction(Transaction transaction) {
        transactionRepo.save(transaction);
        Integer txnId = transaction.getTransactionId();
        String symbol = transaction.getSymbol();

        Position position = positionRepo.findByTransactionIdAndSymbol(txnId, symbol)
                .orElseGet(() -> {
                    Position newPos = new Position();
                    newPos.setTransactionId(txnId);
                    newPos.setSymbol(symbol);
                    return newPos;
                });

        if (transaction.getAction() == Action.BUY) {
            int newQty = position.getQuantity() + transaction.getQuantity();
            position.setQuantity(newQty);
        } else if (transaction.getAction() == Action.SELL) {
            if (transaction.getQuantity() > position.getQuantity()) {
                throw new IllegalArgumentException("Insufficient quantity to sell");
            }
            position.setQuantity(position.getQuantity() - transaction.getQuantity());
        }

        return positionRepo.save(position);

    }

    public List<Position> getAllPositionsForTransaction(String transactionId) {
        return positionRepo.findAll().stream()
                .filter(p -> p.getTransactionId().equals(transactionId))
                .collect(Collectors.toList());
    }
}
