package com.example.TradesManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TradesManagement.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
