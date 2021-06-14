package com.example.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradesController {

    @Autowired
    private TradesRepository tradesRepository;

    @PostMapping("/trades")
    public ResponseEntity createTrade(@RequestBody Trade trade) {
        Trade newTrade = tradesRepository.save(trade);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTrade);
    }
}
