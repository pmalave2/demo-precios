package com.example.demo.precios.domain;

import java.time.LocalDateTime;

public record Prices(LocalDateTime startDate, LocalDateTime endDate, int productId, int priority, double price, String currency,
    int brandId, int priceList) {
}
