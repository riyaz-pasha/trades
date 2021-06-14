package com.example.trades;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "buy|sell")
    private String type;
    private Long user_id;
    private String symbol;

    @NotNull
    @Min(value = 1, message = "You should buy at least one share")
    @Max(value = 100, message = "You can not buy more than 100 shares")
    private int shares;
    private Long price;
    @CreationTimestamp
    private LocalDate timestamp;

    private Trade() {
    }

    public Trade(Long id, String type, Long user_id, String symbol, int shares, Long price, LocalDate timestamp) {
        this.id = id;
        this.type = type;
        this.user_id = user_id;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", user_id=" + user_id +
                ", symbol='" + symbol + '\'' +
                ", shares=" + shares +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
