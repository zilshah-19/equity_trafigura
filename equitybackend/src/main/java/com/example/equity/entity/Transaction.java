package com.example.equity.entity;

import com.example.equity.util.Action;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer transactionId;
    private Integer tradeId;
    private Integer version;
    private String symbol;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Action action;


}
