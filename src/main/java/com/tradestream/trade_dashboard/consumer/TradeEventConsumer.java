package com.tradestream.trade_dashboard.consumer;


import com.tradestream.trade_dashboard.dto.TradeEventDTO;
import com.tradestream.trade_dashboard.entity.TradeEvent;
import com.tradestream.trade_dashboard.repository.TradeEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TradeEventConsumer {

    private final TradeEventRepository tradeEventRepository;

    @KafkaListener(topics = "trade-events", groupId = "trade-event-consumer-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(TradeEventDTO dto) {
        TradeEvent event = TradeEvent.builder()
                .tradeId(dto.getTradeId())
                .symbol(dto.getSymbol())
                .side(dto.getSide())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .timestamp(dto.getTimestamp())
                .build();

        tradeEventRepository.save(event);
        System.out.println("✅ Consumed and saved trade: " + dto.getTradeId());
    }
}
