package com.example.demo.precios.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Prices(UUID id, LocalDateTime startDate, LocalDateTime endDate, int productId, int priority, double price,
    String currency, int brandId, int priceList) {
}
