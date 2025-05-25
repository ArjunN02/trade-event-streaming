package com.tradestream.trade_dashboard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "trade_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeId;
    private String symbol;
    private String side; // BUY or SELL
    private double quantity;
    private double price;
    private Instant timestamp;
}
