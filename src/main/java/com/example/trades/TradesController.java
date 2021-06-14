package com.example.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradesController {

    @Autowired
    private TradesRepository tradesRepository;

    @PostMapping("/trades")
    public Trade createTrade(@RequestBody Trade trade) {
        return tradesRepository.save(trade);
    }
}
