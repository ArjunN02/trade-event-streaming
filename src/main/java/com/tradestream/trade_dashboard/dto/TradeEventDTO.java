package com.tradestream.trade_dashboard.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeEventDTO {
    private String tradeId;
    private String symbol;
    private String side; // BUY or SELL
    private double quantity;
    private double price;
    private Instant timestamp;
}
