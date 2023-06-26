package com.example.TradesManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TradesManagement.entity.Trade;
import com.example.TradesManagement.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	TradeService tradeService;

	@PostMapping("/trades")
	public ResponseEntity<Trade> createTarde(@RequestBody Trade trade) {
		return new ResponseEntity<Trade>(tradeService.createTrade(trade), HttpStatusCode.valueOf(201));
	}

	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> getAllTrades(Trade trade) {
		return new ResponseEntity<List<Trade>>(tradeService.getAllTrades(trade), HttpStatusCode.valueOf(200));
	}

	@GetMapping("/trades/{id}")
	public ResponseEntity<Optional<Trade>> getTradeById(@PathVariable("id") int id) {
		Optional<Trade> trade1 = tradeService.getTradeById(id);
		return new ResponseEntity<>(trade1, HttpStatusCode.valueOf(200));
	}

	@DeleteMapping("trades/{id}")
	public void deleteTradeById(@PathVariable("id") int id) {
		tradeService.deleteTradeById(id);
	}
	
}
