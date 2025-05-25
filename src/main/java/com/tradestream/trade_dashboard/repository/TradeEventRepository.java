package com.tradestream.trade_dashboard.repository;

import com.tradestream.trade_dashboard.entity.TradeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeEventRepository extends JpaRepository<TradeEvent, Long> {
}
