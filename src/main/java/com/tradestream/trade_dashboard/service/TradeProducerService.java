package com.tradestream.trade_dashboard.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradestream.trade_dashboard.model.Trade;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TradeProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TOPIC = "trade-events";

    public TradeProducerService() {
        this.kafkaTemplate = new KafkaTemplate<>(producerFactory());
    }

    private ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    public void produceRandomTrades(int count) {
        String[] stocks = {"AAPL", "GOOGL", "MSFT", "AMZN", "TSLA", "NFLX", "META", "NVDA", "BABA", "IBM"};
        String[] sides = {"BUY", "SELL"};
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            Trade trade = new Trade();
            trade.setTradeId(UUID.randomUUID().toString());
            trade.setSymbol(stocks[rand.nextInt(stocks.length)]);
            trade.setSide(sides[rand.nextInt(sides.length)]);
            trade.setPrice(Math.round((100 + rand.nextDouble() * 900) * 100.0) / 100.0);
            trade.setQuantity(rand.nextInt(490) + 10);
            trade.setTimestamp(System.currentTimeMillis());

            try {
                String json = objectMapper.writeValueAsString(trade);
                kafkaTemplate.send(TOPIC, json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
