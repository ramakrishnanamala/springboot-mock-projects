package com.example.TradesManagement.service;

import java.util.List;
import java.util.Optional;

import com.example.TradesManagement.entity.Trade;

public interface TradeService {

	Trade createTrade(Trade trade);
	
	List<Trade> getAllTrades(Trade trade);
	
	Optional<Trade> getTradeById(int id);

	void deleteTradeById(int id);

}
