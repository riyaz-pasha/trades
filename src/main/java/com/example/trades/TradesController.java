package com.example.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TradesController {

    @Autowired
    private TradesRepository tradesRepository;

    @PostMapping("/trades")
    public ResponseEntity createTrade(@RequestBody Trade trade) {
        Trade newTrade = tradesRepository.save(trade);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTrade);
    }

    @GetMapping("/trades")
    public ResponseEntity<List<Trade>> getTrades() {
        List<Trade> trades = tradesRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(trades);
    }

    @GetMapping("/trades/{tradeId}")
    public ResponseEntity getTradeById(@PathVariable Long tradeId) {
        Optional<Trade> trade = tradesRepository.findById(tradeId);
        if (!trade.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(trade);
    }
}
