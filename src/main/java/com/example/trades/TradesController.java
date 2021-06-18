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
    public ResponseEntity<List<Trade>> getTrades(@RequestParam Optional<String> type, @RequestParam(name = "user_id") Optional<Long> userId) {
        List<Trade> trades;
        if (type.isPresent() && userId.isPresent()) {
            trades = tradesRepository.findByTypeAndUserId(type.get(), userId.get());
        } else if (userId.isPresent()) {
            System.out.println("here----" + userId.get());
            trades = tradesRepository.findByUserId(userId.get());
            System.out.println("here----" + trades.toString());
        } else if (type.isPresent()) {
            trades = tradesRepository.findByType(type.get());
        } else {
            trades = tradesRepository.findAll();
        }
        return ResponseEntity.status(HttpStatus.OK).body(trades);
    }

    @GetMapping("/trades/{tradeId}")
    public ResponseEntity getTradeById(@PathVariable Long tradeId) {
        Optional<Trade> trade = tradesRepository.findById(tradeId);
        if (!trade.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(trade);
    }
}
