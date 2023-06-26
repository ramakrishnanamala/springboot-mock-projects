package com.example.TradesManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TradesManagement.entity.Trade;
import com.example.TradesManagement.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeRepository tradeRepository;
	
	@Override
	public Trade createTrade(Trade trade) {
		return tradeRepository.save(trade);
	}
	
	@Override
	public List<Trade> getAllTrades(Trade trade) {
		return tradeRepository.findAll();
	}
	
	@Override
	public Optional<Trade> getTradeById(int id) {
		return tradeRepository.findById(id);
	}

	@Override
	public void deleteTradeById(int id) {
		tradeRepository.deleteById(id);
	}
}
