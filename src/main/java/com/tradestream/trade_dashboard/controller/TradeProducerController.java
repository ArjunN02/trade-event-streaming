package com.tradestream.trade_dashboard.controller;

import com.tradestream.trade_dashboard.service.TradeProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trades")
public class TradeProducerController {

    private final TradeProducerService tradeProducerService;

    public TradeProducerController(TradeProducerService tradeProducerService) {
        this.tradeProducerService = tradeProducerService;
    }

    @PostMapping("/generate")
    public String generateTrades(@RequestParam(defaultValue = "100") int count) {
        tradeProducerService.produceRandomTrades(count);
        return count + " trades produced to Kafka.";
    }
}
