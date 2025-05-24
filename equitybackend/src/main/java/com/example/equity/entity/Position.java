package com.example.equity.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name = "Position")
@Data
@Qualifier("position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer transactionId;
    private String symbol;
    private Integer quantity;
}
