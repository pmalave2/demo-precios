package com.example.demo.precios.application.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReadPriceResponse(@Schema(example = "35455") int productId, @Schema(example = "1") int brandId,
    @Schema(example = "1") int priceList, @Schema(example = "2020-06-14T00:00:00") LocalDateTime startDate,
    @Schema(example = "2020-12-31T23:59:59") LocalDateTime endDate, @Schema(example = "35.50") double price) {
}
